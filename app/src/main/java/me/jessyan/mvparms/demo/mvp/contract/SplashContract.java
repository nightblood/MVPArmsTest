package me.jessyan.mvparms.demo.mvp.contract;

import android.content.Context;

import me.jessyan.mvparms.demo.http.HttpRequestCallback;
import me.jessyan.mvparms.demo.mvp.BaseView;
import me.jessyan.mvparms.demo.mvp.IModel;
import me.jessyan.mvparms.demo.mvp.model.entity.SplashData;

/**
 * Created by Administrator on 2017/1/13 0013.
 */
public interface SplashContract {
    interface View extends BaseView {

        void updateView(SplashData splashData);
    }
    interface Model extends IModel {
        void doLogin(Context context, String id, String pwd, HttpRequestCallback callback);
    }
}
