package me.jessyan.mvparms.demo.mvp.contract;

import android.content.Context;

import com.tbruyelle.rxpermissions.RxPermissions;

import java.util.List;

import me.jessyan.mvparms.demo.base.DefaultAdapter;
import me.jessyan.mvparms.demo.mvp.BaseView;
import me.jessyan.mvparms.demo.mvp.IModel;
import me.jessyan.mvparms.demo.mvp.model.entity.User;
import rx.Observable;

/**
 * Created by jess on 9/4/16 10:47
 * Contact with jess.yan.effort@gmail.com
 */
public interface UserContract {
    // 对于经常使用的关于UI的方法可以定义到 BaseView中,如显示隐藏进度条,和显示文字消息
    interface View extends BaseView {
        void setAdapter(DefaultAdapter adapter);
        void startLoadMore();
        void endLoadMore();
        RxPermissions getRxPermissions(); //申请权限
        void showEmptyData();
        void showErrorLoad();
        Context getViewContext();
        android.view.ViewGroup getParentView();
        android.view.View initHeader();
    }
    // Model层定义接口,外部只需关心model返回的数据,无需关心内部细节,及是否使用缓存
    interface Model extends IModel {
        Observable<List<User>> getUsers(int lastIdQueried, boolean update);
    }
}
