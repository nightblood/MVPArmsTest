package me.jessyan.mvparms.demo.mvp.contract;

import me.jessyan.mvparms.demo.mvp.BaseView;
import me.jessyan.mvparms.demo.mvp.IModel;
import me.jessyan.mvparms.demo.mvp.model.entity.SplashData;
import rx.Observable;

/**
 * Created by Administrator on 2017/1/11 0011.
 */
public interface NewsContract {
    interface Model extends IModel {
        Observable<SplashData> getData();
    }

    interface View extends BaseView {
    }
}
