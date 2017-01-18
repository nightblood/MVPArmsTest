package me.jessyan.mvparms.demo.di.component;

import android.support.v4.app.Fragment;

import common.AppComponent;
import dagger.Component;
import me.jessyan.mvparms.demo.di.module.RecommendModule;
import me.jessyan.mvparms.demo.di.scope.ActivityScope;

/**
 * Created by Administrator on 2017/1/18 0018.
 */
@ActivityScope
@Component(modules = RecommendModule.class, dependencies = AppComponent.class)
public interface RecommendComponent {
    void inject(Fragment fragment);
//    void inject(WEFragment weFragment);

}
