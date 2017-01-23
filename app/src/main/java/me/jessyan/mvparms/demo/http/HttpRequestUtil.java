package me.jessyan.mvparms.demo.http;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import common.WEApplication;
import me.jessyan.mvparms.demo.mvp.model.entity.LoginResponse;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * User: yxfang
 * Date: 2016-04-29
 * Time: 15:41
 * ------------- Description -------------
 * ---------------------------------------
 */
public class HttpRequestUtil {
    private static final String TAG = "HttpRequestUtil";
    private static HttpRequestUtil instance;
    private static OkHttpClient okHttpClient;
    private Handler httpHandler;
    private Gson gson;

    public HttpRequestUtil() {
        CookieJar cookieJar = new CookieJar() {
            @Override
            public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {

            }

            @Override
            public List<Cookie> loadForRequest(HttpUrl url) {
                return initCookies();
            }
        };
        okHttpClient = new OkHttpClient.Builder()
                .cookieJar(cookieJar)
                .build();

        httpHandler = new Handler(Looper.getMainLooper());
        gson = new Gson();
    }

    public static synchronized  HttpRequestUtil getInstance() {
        if (instance == null) {
            synchronized ( HttpRequestUtil.class) {
                instance = new HttpRequestUtil();
            }
        }
        return instance;
    }

    /**
     * http get 请求
     * @param url
     * @param callback
     */
    public void getRequest(Context context, HttpUrl url, final  HttpRequestCallback callback) {
        Request request = new Request.Builder()
                .tag(getTagByContext(context))
                .url(url)
                .get()
                .build();
        okHttpClient.newCall(request).enqueue(getCallback(context, callback));
    }

    public void postRequest(final Context context, String url, @Nullable FormBody params, HttpRequestCallback callback) {
        Request request = new Request.Builder()
                .tag(getTagByContext(context))
                .url(url)
                .post(params)
                .build();


        okHttpClient.newCall(request).enqueue(getCallback(context, callback));
    }

    private List<Cookie> initCookies() {
        ArrayList<Cookie> cookies = new ArrayList<>();
        cookies.add(new Cookie.Builder()
                .domain("app.0575.com")
                .name("sc0575app_device_resolution")
                .value("1080*1920")
                .build());
        cookies.add(new Cookie.Builder()
                .domain("app.0575.com")
                .name("sc0575app_device_image_type")
                .value("h")
                .build());
        cookies.add(new Cookie.Builder()
                .domain("app.0575.com")
                .name("sc0575app_network_environment")
                .value("wifi")
                .build());
        cookies.add(new Cookie.Builder()
                .domain("app.0575.com")
                .name("sc0575app_device_id")
                .value("9C525887AA44357606A349F415BBDEB3")
                .build());
        cookies.add(new Cookie.Builder()
                .domain("app.0575.com")
                .name("sc0575app_site_id")
                .value("1")
                .build());

        cookies.add(new Cookie.Builder()
                .domain("app.0575.com")
                .name("sc0575app_request_token")
                .value("9db68cdcd03e17e419788826f43f5f13_1484535243")
                .build());
        String loginKey = "";
        if (WEApplication.getInstance().isLogin()) {
            LoginResponse userInfo = WEApplication.getInstance().getUserInfo();
            loginKey = userInfo.getLogin_key();
        }
        cookies.add(new Cookie.Builder()
                .domain("app.0575.com")
                .name("sc0575app_user_loginkey")
                .value(loginKey)
                .build());
        return cookies;
    }

    /**
     * 通过context 生成http 请求tag
     * tag 用来标识 http 请求，可通过tag 来取消请求
     * @param context
     * @return
     */
    private String getTagByContext(Context context) {
        return context != null ? context.getClass().getName() : null;
    }

    /**
     * 重新封装一层callback
     * 添加onStart 和 onFinish
     * @param callback
     * @return
     */
    private Callback getCallback(final Context context, final HttpRequestCallback callback) {
        if (callback != null) {
            callback.onStart();
        }

        return new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                if (callback != null) {
                    HttpResult httpResult = new HttpResult(HttpHandler.HTTP_FAILURE);
                    httpResult.callback = callback;
                    httpResult.exception = new HttpException(e);
                    httpResult.call = call;
                    httpHandler.post(new HttpHandler(httpResult));
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (callback != null) {
                    if (response.code() == 200) {
                        HttpResult httpResult = new HttpResult(HttpHandler.HTTP_SUCCESS);
                        httpResult.callback = callback;
                        httpResult.response = response.body().string();
                        httpResult.call = call;
                        httpHandler.post(new HttpHandler(httpResult));
                    } else {
                        HttpResult httpResult = new HttpResult(HttpHandler.HTTP_FAILURE);
                        httpResult.callback = callback;
                        httpResult.call = call;
                        httpResult.exception = new HttpException(response.code());
                        httpHandler.post(new HttpHandler(httpResult));
                    }
                }
            }
        };
    }

    class HttpHandler implements Runnable {
        public static final int HTTP_SUCCESS = 1;
        public static final int HTTP_FAILURE = 2;

        private HttpResult httpResult;

        public HttpHandler(HttpResult httpResult) {
            this.httpResult = httpResult;
        }

        @Override
        public void run() {
            httpResult.callback.onFinish();

            if (httpResult.what == HTTP_SUCCESS) {
                /*if (httpResult.callback.type == String.class) {
                    httpResult.callback.onResponse(httpResult.response);
                } else {
                    Gson gson = new Gson();
                    Object object = gson.fromJson(httpResult.response, httpResult.callback.type);
                    httpResult.callback.onResponse(object);
                }*/
                httpResult.callback.onResponse(httpResult.response);
            } else {
                httpResult.callback.onFailure(httpResult.call, httpResult.exception);
            }
        }
    }

    class HttpResult {
        private HttpRequestCallback callback;
        private String response;
        private HttpException exception;
        private Call call;
        private int what;

        private Message msg;

        public HttpResult(int what) {
            this.msg = new Message();
            this.what = what;
        }

        public Message getMessage() {
            this.msg.what = what;
            msg.obj = this;
            return msg;
        }
    }


}
