package me.jessyan.mvparms.demo.di.component;

import android.support.v4.app.Fragment;

import common.AppComponent;
import dagger.Component;
import dagger.Module;
import me.jessyan.mvparms.demo.di.module.news.DateFragmentModule;
import me.jessyan.mvparms.demo.di.scope.ActivityScope;

/**
 * Created by Administrator on 2017/1/19 0019.
 */
@ActivityScope
@Component(modules = DateFragmentModule.class, dependencies = AppComponent.class)
public interface DateFragmentComponent {
    void inject(Fragment fragment);
}
