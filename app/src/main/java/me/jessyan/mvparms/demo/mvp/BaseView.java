package me.jessyan.mvparms.demo.mvp;

import android.content.Context;
import android.content.Intent;

/**
 * Created by jess on 16/4/22.
 */
public interface BaseView {

    void showLoading();
    void hideLoading();
    void showMessage(String message);
    void loadSuccess(Object o);
    void loadFail();
    void launchActivity(Intent intent);
    void killMyself();
    Context getContext();

    void refreshEnd();

    void showRefreshing();
}
