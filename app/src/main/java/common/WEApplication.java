package common;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import javax.inject.Inject;

import me.jessyan.mvparms.demo.BuildConfig;
import me.jessyan.mvparms.demo.app.utils.Utils;
import me.jessyan.mvparms.demo.base.AppManager;
import me.jessyan.mvparms.demo.di.component.DaggerBaseComponent;
import me.jessyan.mvparms.demo.di.module.AppModule;
import me.jessyan.mvparms.demo.di.module.CacheModule;
import me.jessyan.mvparms.demo.di.module.ClientModule;
import me.jessyan.mvparms.demo.di.module.GlobeConfigModule;
import me.jessyan.mvparms.demo.di.module.ImageModule;
import me.jessyan.mvparms.demo.mvp.model.api.Api;
import me.jessyan.mvparms.demo.mvp.model.entity.LoginResponse;
import timber.log.Timber;

/**
 * Created by jess on 8/5/16 11:07
 * contact with jess.yan.effort@gmail.com
 */
public class WEApplication extends Application {

    private boolean mFlagLogin = false;
    private LoginResponse mUserInfo;
    static private WEApplication mApplication;
    private ClientModule mClientModule;
    private AppModule mAppModule;
    private ImageModule mImagerModule;
    private GlobeConfigModule mGlobeConfigModule;
    @Inject
    protected AppManager mAppManager;

    protected final String TAG = this.getClass().getSimpleName();
    private AppComponent mAppComponent;

    private RefWatcher mRefWatcher;// leakCanary观察器

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        this.mAppModule = new AppModule(this); //提供application
        DaggerBaseComponent.builder()
                .appModule(mAppModule)
                .build()
                .inject(this);
        this.mImagerModule = new ImageModule(); //图片加载框架默认使用glide
        this.mClientModule = new ClientModule(mAppManager); //用于提供okhttp和retrofit的单例
//        this.mGlobeConfigModule = checkNotNull(getGlobeConfigModule(), "lobeConfigModule is required");
        this.mGlobeConfigModule = getGlobeConfigModule();
        Utils.init(this);
        mAppComponent = DaggerAppComponent
                .builder()
                .appModule(getAppModule())//baseApplication提供
                .clientModule(getClientModule())//baseApplication提供
                .imageModule(getImageModule())//baseApplication提供
                .globeConfigModule(getGlobeConfigModule())//全局配置
                .cacheModule(new CacheModule())//需自行创建
                .build();
        if (BuildConfig.LOG_DEBUG) {//Timber日志打印
            Timber.plant(new Timber.DebugTree());
        }
        installLeakCanary();//leakCanary内存泄露检查
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        if (mClientModule != null)
            this.mClientModule = null;
        if (mAppModule != null)
            this.mAppModule = null;
        if (mImagerModule != null)
            this.mImagerModule = null;
        if (mAppManager != null) {//释放资源
            this.mAppManager.release();
            this.mAppManager = null;
        }
        if (mApplication != null)
            this.mApplication = null;
        if (mAppComponent != null)
            this.mAppComponent = null;
        if (mRefWatcher != null)
            this.mRefWatcher = null;
    }

    public ClientModule getClientModule() {
        return mClientModule;
    }

    public AppModule getAppModule() {
        return mAppModule;
    }

    public ImageModule getImageModule() {
        return mImagerModule;
    }

    public AppManager getAppManager() {
        return mAppManager;
    }

    public static WEApplication getInstance() {
        return mApplication;
    }
    public void doLogin() {

    }

    public void doLogout() {

    }

    /**
     * 安装leakCanary检测内存泄露
     */
    protected void installLeakCanary() {
        this.mRefWatcher = BuildConfig.USE_CANARY ? LeakCanary.install(this) : RefWatcher.DISABLED;
    }

    /**
     * 获得leakCanary观察器
     * @param context
     * @return
     */
    public static RefWatcher getRefWatcher(Context context) {
        WEApplication application = (WEApplication) context.getApplicationContext();
        return application.mRefWatcher;
    }

    /**
     * 将 AppComponent返回出去,供其它地方使用, AppComponent接口中声明的方法返回的实例, 在 getAppComponent()拿到对象后都可以直接使用
     * @return
     */
    public AppComponent getAppComponent() {
        return mAppComponent;
    }
    /**
     * app的全局配置信息封装进 module(使用 Dagger注入到需要配置信息的地方)
     * @return
     */
    protected GlobeConfigModule getGlobeConfigModule() {
        return GlobeConfigModule
                .buidler()
                .baseurl(Api.APP_DOMAIN)
                .build();
    }

    public boolean isLogin() {
        return mFlagLogin;
    }
    public void setUserInfo(LoginResponse result) {
        mUserInfo = result;
        mFlagLogin = true;
    }
    public LoginResponse getUserInfo() {
        return mUserInfo;
    }
}
