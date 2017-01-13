package me.jessyan.mvparms.demo.mvp.presenter;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.mvp.BasePresenter;

import javax.inject.Inject;

import me.jessyan.mvparms.demo.mvp.contract.SplashContract;
import me.jessyan.mvparms.demo.mvp.model.entity.LoginResponse;
import me.jessyan.mvparms.demo.mvp.model.entity.SplashData;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/1/13 0013.
 */
@ActivityScope
public class SplashPresenter extends BasePresenter<SplashContract.Model, SplashContract.View> {

    @Inject
    public SplashPresenter(SplashContract.Model model, SplashContract.View rootView) {
        super(model, rootView);

    }

    public void requestData() {

        mModel.getSplashData()
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<SplashData>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mRootView.showMessage(e.toString());
                    }

                    @Override
                    public void onNext(SplashData splashData) {
                        mRootView.updateView(splashData);
                    }
                });
    }

    public void onCommit(String id, String pwd) {
        mModel.commit(id, pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<LoginResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(LoginResponse loginResponse) {
                        mRootView.showMessage(loginResponse.action);
                    }
                });
    }
}
