package me.jessyan.mvparms.demo.mvp.contract;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import me.jessyan.mvparms.demo.http.HttpRequestCallback;
import me.jessyan.mvparms.demo.mvp.BaseView;
import me.jessyan.mvparms.demo.mvp.IModel;
import me.jessyan.mvparms.demo.mvp.ui.adapter.RecommendAdapter;

/**
 * Created by Administrator on 2017/1/18 0018.
 */
public interface RecommendContact {
    interface View extends BaseView {
        android.view.View initHeader();
        void setAdapter(RecommendAdapter adapter);
        RecyclerView.LayoutManager getLayoutManager();
    }
    interface Model extends IModel {
        void getData(Context context, String gender, HttpRequestCallback callback);
    }
}
