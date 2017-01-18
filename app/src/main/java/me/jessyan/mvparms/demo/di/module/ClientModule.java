package me.jessyan.mvparms.demo.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.jessyan.mvparms.demo.base.AppManager;

/**
 * Created by jessyan on 2016/3/14.
 */
@Module
public class ClientModule {
    private static final int TIME_OUT = 10;
    public static final int HTTP_RESPONSE_DISK_CACHE_MAX_SIZE = 10 * 1024 * 1024;//缓存文件最大值为10Mb
    private AppManager mAppManager;

    public ClientModule(AppManager appManager) {
        this.mAppManager = appManager;
    }

    /**
     * 提供管理所有activity的管理类
     * @return
     */
    @Singleton
    @Provides
    AppManager provideAppManager() {
        return mAppManager;
    }

}
