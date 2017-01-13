package me.jessyan.mvparms.demo.mvp.model;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.mvp.BaseModel;

import javax.inject.Inject;

import me.jessyan.mvparms.demo.mvp.contract.SplashContract;
import me.jessyan.mvparms.demo.mvp.model.api.cache.CacheManager;
import me.jessyan.mvparms.demo.mvp.model.api.service.ServiceManager;
import me.jessyan.mvparms.demo.mvp.model.entity.LoginResponse;
import me.jessyan.mvparms.demo.mvp.model.entity.SplashData;
import rx.Observable;

/**
 * Created by Administrator on 2017/1/13 0013.
 */
@ActivityScope
public class SplashModel extends BaseModel<ServiceManager, CacheManager> implements SplashContract.Model {
    @Inject
    public SplashModel(ServiceManager serviceManager, CacheManager cacheManager) {
        super(serviceManager, cacheManager);
    }

    @Override
    public Observable<SplashData> getSplashData() {
        return mServiceManager.getSplashService().getData();
    }

    @Override
    public Observable<LoginResponse> commit(String id, String pwd) {
        return mServiceManager.getSplashService().commit(id, pwd);
    }
}
