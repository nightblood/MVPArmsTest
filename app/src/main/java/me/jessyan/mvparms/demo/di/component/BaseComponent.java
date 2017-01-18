package me.jessyan.mvparms.demo.di.component;


import javax.inject.Singleton;

import common.WEApplication;
import dagger.Component;
import me.jessyan.mvparms.demo.di.module.AppModule;

/**
 * Created by jess on 14/12/2016 13:58
 * Contact with jess.yan.effort@gmail.com
 */
@Singleton
@Component(modules={AppModule.class})
public interface BaseComponent {
    void inject(WEApplication application);
}
