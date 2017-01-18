package me.jessyan.mvparms.demo.mvp.presenter;

import android.content.Context;

import javax.inject.Inject;

import common.WEApplication;
import me.jessyan.mvparms.demo.di.scope.ActivityScope;
import me.jessyan.mvparms.demo.http.HttpException;
import me.jessyan.mvparms.demo.http.HttpRequestCallback;
import me.jessyan.mvparms.demo.mvp.BasePresenter;
import me.jessyan.mvparms.demo.mvp.contract.SplashContract;
import me.jessyan.mvparms.demo.mvp.model.entity.BaseResponse;
import me.jessyan.mvparms.demo.mvp.model.entity.LoginResponse;
import me.jessyan.mvparms.demo.utils.FileUtils;
import okhttp3.Call;

/**
 * Created by Administrator on 2017/1/13 0013.
 */
@ActivityScope
public class SplashPresenter extends BasePresenter<SplashContract.Model, SplashContract.View> {

    @Inject
    public SplashPresenter(SplashContract.Model model, SplashContract.View rootView) {
        super(model, rootView);

    }

    public void login(Context context, String id, String pwd) {
        mModel.doLogin(context, id, pwd, new HttpRequestCallback<BaseResponse>() {
            @Override
            public void onStart() {
            }

            @Override
            public void onFinish() {
                mRootView.hideLoading();
            }

            @Override
            public void onResponse(String response) {
                Object parse = null;
                try {
                    parse = parse(LoginResponse.class, response);

                    if (parse != null) {
                        LoginResponse result = (LoginResponse) parse;
                        WEApplication.getInstance().setUserInfo(result);
                        FileUtils.saveConfigFile("user_info.cfg", response);
                        mRootView.loadSuccess(result);
                    }
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call call, HttpException e) {
                mRootView.loadFail();
            }
        });
    }


}
