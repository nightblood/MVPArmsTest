package me.jessyan.mvparms.demo.mvp.presenter;

import rx.Subscription;

/**
 * Created by Administrator on 2017/1/19 0019.
 */
public interface Presenter {
    void onStart();
    void onDestroy();
    void unSubscribe(Subscription subscription);
}
