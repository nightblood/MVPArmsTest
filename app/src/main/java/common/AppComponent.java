package common;

import android.app.Application;

import com.google.gson.Gson;
import com.jess.arms.base.AppManager;
import com.jess.arms.di.module.AppModule;
import com.jess.arms.di.module.ClientModule;
import com.jess.arms.di.module.GlobeConfigModule;
import com.jess.arms.di.module.ImageModule;
import com.jess.arms.widget.imageloader.ImageLoader;

import javax.inject.Singleton;

import dagger.Component;
import me.jessyan.mvparms.demo.di.module.CacheModule;

/**
 * Created by jess on 8/4/16.
 */
@Singleton
@Component(modules = {AppModule.class, ClientModule.class,  ImageModule.class,
        CacheModule.class, GlobeConfigModule.class})
public interface AppComponent {
    Application Application();
    //缓存管理器
    //图片管理器,用于加载图片的管理类,默认使用glide,使用策略模式,可替换框架
    ImageLoader imageLoader();
    //gson
    Gson gson();
    //用于管理所有activity
    AppManager appManager();
}
