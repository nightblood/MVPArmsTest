package me.jessyan.mvparms.demo.di.module;

import dagger.Module;
import dagger.Provides;
import me.jessyan.mvparms.demo.mvp.contract.SplashContract;
import me.jessyan.mvparms.demo.mvp.model.SplashModel;

/**
 * Created by Administrator on 2017/1/13 0013.
 */
@Module
public class SplashModule {

    private SplashContract.View mView;
    public SplashModule(SplashContract.View view) {
        mView = view;
    }

    @Provides
    public SplashContract.View provideView() {
        return mView;
    }
    @Provides
    public SplashContract.Model provideModel(SplashModel model) {
        return model;
    }
}
