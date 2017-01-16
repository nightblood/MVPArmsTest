package me.jessyan.mvparms.demo.mvp.presenter;

import android.content.Context;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.http.HttpException;
import com.jess.arms.http.HttpRequestCallback;
import com.jess.arms.mvp.BasePresenter;

import javax.inject.Inject;

import me.jessyan.mvparms.demo.mvp.contract.SplashContract;
import me.jessyan.mvparms.demo.mvp.model.entity.LoginResponse;
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
        mModel.doLogin(context, id, pwd, new HttpRequestCallback<LoginResponse>() {
            @Override
            public void onStart() {
                mRootView.showMessage("onStart");

            }

            @Override
            public void onFinish() {
                mRootView.showMessage("onFinish");

            }

            @Override
            public void onResponse(LoginResponse loginResponse) {
                    mRootView.showMessage("onResponse");

                }


            @Override
            public void onFailure(Call call, HttpException e) {
                mRootView.showMessage("onFailure" + e.toString());

            }
        });
    }
}
