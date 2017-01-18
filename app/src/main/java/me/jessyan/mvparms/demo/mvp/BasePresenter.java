package me.jessyan.mvparms.demo.mvp;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.simple.eventbus.EventBus;

import common.WEApplication;
import me.jessyan.mvparms.demo.app.utils.Constants;
import me.jessyan.mvparms.demo.http.HttpException;
import me.jessyan.mvparms.demo.http.HttpRequestCallback;
import me.jessyan.mvparms.demo.http.HttpRequestUtil;
import me.jessyan.mvparms.demo.http.RequestParams;
import me.jessyan.mvparms.demo.mvp.model.entity.SuccessTag;
import okhttp3.Call;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by jess on 16/4/28.
 */
public class BasePresenter<M extends IModel, V extends BaseView> implements Presenter {

    public static final String SUCCESS_MESSAGE_PARSE_DATA = "success_message_parse_data";
    public static final String SUCCESS_CONFIRM_MESSAGE = "success_confirm_message";
    public static final String SUCCESS_PARSE_DATA = "success_parse_data";
    public static final String SUCCESS_SHOW_PROMPT = "success_prompt_message";
    public static final String SUCCESS_LIST_EMPTY = "success_list_info_empty";
    public static final String SUCCESS_LIST_END = "success_list_page_end";
    public static final String FAIL_SHOW_TOAST = "fail_prompt_message";
    public static final String FAIL_SHOW_CONFIRM = "fail_confirm_message";
    public static final String FAIL_MUST_LOGIN = "fail_user_mustlogin";
    public static final String FAIL_LOGIN_KEY_ERROR = "fail_user_loginkeyerror";
    public static final String FAIL_NEED_VERIFY = "success_friend_add_wait_ta_verify";
    public static final String fail_other_user_auth_phone_message = "fail_other_user_auth_phone_message";
    protected final String TAG = this.getClass().getSimpleName();
    protected CompositeSubscription mCompositeSubscription;

    protected M mModel;
    protected V mRootView;

    public BasePresenter(M model, V rootView) {
        this.mModel = model;
        this.mRootView = rootView;
        onStart();
    }

    public BasePresenter(V rootView) {
        this.mRootView = rootView;
        onStart();
    }

    public BasePresenter() {
        onStart();
    }

    @Override
    public void onStart() {
        if (useEventBus()) // 如果要使用eventbus请将此方法返回true
            EventBus.getDefault().register(this); // 注册 eventbus
    }

    @Override
    public void onDestroy() {
        if (useEventBus())//如果要使用eventbus请将此方法返回true
            EventBus.getDefault().unregister(this);//解除注册eventbus
        unSubscribe();//解除订阅
        if (mModel != null) {
            mModel.onDestory();
            this.mModel = null;
        }
        this.mRootView = null;
        this.mCompositeSubscription = null;
    }

    /**
     * 是否使用 eventBus,默认为使用(true)，
     * @return
     */
    protected boolean useEventBus() {
        return false;
    }

    protected void addSubscrebe(Subscription subscription) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(subscription);//将所有 subscription放入,集中处理
    }

    protected void unSubscribe() {
        if (mCompositeSubscription != null) {
            mCompositeSubscription.unsubscribe();//保证 activity结束时取消所有正在执行的订阅
        }
    }

    @Override
    public void unSubscribe(Subscription subscription) {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();//保证 activity结束时取消所有正在执行的订阅
        }
    }

    public Object parse(Class resultClass, String result) throws Throwable {
        JsonObject jsonObject = null;
        JsonParser jsonParser = null;
        Log.e("parse", result);
        try {
            jsonParser = new JsonParser();
            jsonObject = jsonParser.parse(result).getAsJsonObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (jsonObject != null) {

            String action = jsonObject.get("action").getAsString();
//            final String value = jsonObject.get("value").getAsString();
            JsonElement jsonElement = jsonObject.get("value");
            switch (action) {
                case SUCCESS_CONFIRM_MESSAGE:
                    mRootView.showMessage(jsonElement.getAsString());
                    return new SuccessTag();
                case SUCCESS_MESSAGE_PARSE_DATA:
                    try {
//                        JsonObject res = jsonParser.parse(value).getAsJsonObject();
                        JsonObject value = jsonElement.getAsJsonObject();
                        final String message = value.get("message").getAsString();
                        String isConfirm = value.get("is_confirm").getAsString();
                        if ("1".equals(isConfirm)) {
                            mRootView.showMessage(message);
                        }

                        String data = value.get("data").getAsString();
                        Gson gson = new Gson();
                        return gson.fromJson(data, resultClass);
                    } catch (Exception e) {
                        mRootView.showMessage("数据解析失败");
                        e.printStackTrace();
                    }
                    return null;
                case SUCCESS_PARSE_DATA:
                    try {
                        Gson gson = new Gson();
                        return gson.fromJson(jsonElement.getAsJsonObject(), resultClass);
                    } catch (Exception e) {
                        mRootView.showMessage("数据解析失败");
                        e.printStackTrace();
                    }
                    return null;
                case SUCCESS_SHOW_PROMPT:
                    mRootView.showMessage(jsonElement.getAsString());
                    return new SuccessTag();
                case SUCCESS_LIST_EMPTY:
                    break;
                case SUCCESS_LIST_END:
                    break;
                case FAIL_SHOW_TOAST:
                case FAIL_SHOW_CONFIRM:
                case FAIL_MUST_LOGIN:
                   mRootView.showMessage(jsonElement.getAsString());
                    break;
                case FAIL_LOGIN_KEY_ERROR:
                    break;
                case FAIL_NEED_VERIFY:
                    mRootView.showMessage(jsonElement.getAsString());

                    break;
                case fail_other_user_auth_phone_message:
//                    MainApplication.runOnMainThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            MainApplication.getInstance().showAlerDialog(value, new View.OnClickListener() {
//                                @Override
//                                public void onClick(View v) {
//                                    deleteAllAuth();
//                                }
//                            });
//                        }
//                    });
                    RequestParams requestParams = new RequestParams();
                    requestParams.put("third_party", "all");
                    HttpRequestUtil.getInstance().postRequest(mRootView.getContext(), Constants.URL_AUTH_DELETE, requestParams.toParams(),
                            new HttpRequestCallback<SuccessTag>() {
                        @Override
                        public void onStart() {

                        }

                        @Override
                        public void onFinish() {

                        }

                        @Override
                        public void onResponse(String response) {
                            WEApplication.getInstance().doLogout();
                            WEApplication.getInstance().doLogin();
                        }

                        @Override
                        public void onFailure(Call call, HttpException e) {

                        }
                    });
                    break;
            }
        }
        return null;
    }

    private void deleteAllAuth() {
       /* E0575Params params = new E0575Params(Constants.URL_AUTH_DELETE);
        params.addBodyParameter("third_party", "all");
        HttpUtil.loadData(params, new Callback.CommonCallback<SuccessTag>() {
            @Override
            public void onSuccess(SuccessTag result) {
                if (result != null) {
                    MainApplication.getInstance().doLogout();
                    MainApplication.getInstance().doLogin();
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });*/
    }

}
