package me.jessyan.mvparms.demo.mvp.contract;

import com.jess.arms.mvp.BaseView;
import com.jess.arms.mvp.IModel;

import me.jessyan.mvparms.demo.mvp.model.entity.LoginResponse;
import me.jessyan.mvparms.demo.mvp.model.entity.SplashData;
import rx.Observable;

/**
 * Created by Administrator on 2017/1/13 0013.
 */
public interface SplashContract {
    interface View extends BaseView {

        void updateView(SplashData splashData);
    }
    interface Model extends IModel {
        Observable<SplashData> getSplashData();
        Observable<LoginResponse> commit(String id, String pwd);

    }
}
