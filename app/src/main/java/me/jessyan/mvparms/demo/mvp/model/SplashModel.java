package me.jessyan.mvparms.demo.mvp.model;

import android.content.Context;

import javax.inject.Inject;

import me.jessyan.mvparms.demo.di.scope.ActivityScope;
import me.jessyan.mvparms.demo.http.HttpRequestCallback;
import me.jessyan.mvparms.demo.http.RequestParams;
import me.jessyan.mvparms.demo.mvp.BaseModel;
import me.jessyan.mvparms.demo.mvp.contract.SplashContract;

/**
 * Created by Administrator on 2017/1/13 0013.
 */
@ActivityScope
public class SplashModel extends BaseModel implements SplashContract.Model {
    @Inject
    public SplashModel() {
    }


    @Override
    public void doLogin(Context context, String id, String pwd, HttpRequestCallback callback) {
        RequestParams requestParams = new RequestParams();
        requestParams.put("user", id);
        requestParams.put("password", pwd);
        setPostRequest(context, "http://app.0575.com/app.php?c=User&a=Login", requestParams, callback);
    }

   /* @Override
    public void deleteAllAuth(Context context, HttpRequestCallback callback) {
        RequestParams requestParams = new RequestParams();
        requestParams.put("third_party", "all");
        setPostRequest(context, Constants.URL_AUTH_DELETE, requestParams, callback);
    }*/
}
