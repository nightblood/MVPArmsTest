package me.jessyan.mvparms.demo.mvp.contract;

import android.content.Context;

import me.jessyan.mvparms.demo.http.HttpRequestCallback;
import me.jessyan.mvparms.demo.mvp.BaseView;
import me.jessyan.mvparms.demo.mvp.IModel;
import me.jessyan.mvparms.demo.mvp.ui.adapter.DateFragmentAdapter;

/**
 * Created by Administrator on 2017/1/18 0018.
 */
public interface DateFragmentContact {
    interface View extends BaseView {
        void setAdapter(DateFragmentAdapter mAdapter);

        String getCateId();

        void refreshEnd();

        void showRefreshing();
    }
    interface Model extends IModel {
        void getData(Context context,  String cateid, String pageParam, HttpRequestCallback callback);
    }
}
