package me.jessyan.mvparms.demo.di.component;

import com.jess.arms.di.scope.ActivityScope;

import common.AppComponent;
import dagger.Component;
import me.jessyan.mvparms.demo.di.module.SplashModule;
import me.jessyan.mvparms.demo.mvp.ui.activity.SplashActivity;

/**
 * Created by Administrator on 2017/1/13 0013.
 */
@ActivityScope
@Component(modules = SplashModule.class, dependencies = AppComponent.class)
public interface SplashComponent {


    void inject(SplashActivity activity);

}
