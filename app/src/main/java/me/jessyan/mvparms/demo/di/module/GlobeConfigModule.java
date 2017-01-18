package me.jessyan.mvparms.demo.di.module;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;

/**
 * Created by jessyan on 2016/3/14.s
 */
@Module
public class GlobeConfigModule {
    private HttpUrl mApiUrl;
    private List<Interceptor> mInterceptors;

    private GlobeConfigModule(Buidler buidler) {
        this.mApiUrl = buidler.apiUrl;
        this.mInterceptors = buidler.interceptors;
    }

    public static Buidler buidler() {
        return new Buidler();
    }

    @Singleton
    @Provides
    List<Interceptor> provideInterceptors() {
        return mInterceptors;
    }

    @Singleton
    @Provides
    HttpUrl provideBaseUrl() {
        return mApiUrl;
    }

    public static final class Buidler {
        private HttpUrl apiUrl = HttpUrl.parse("https://api.github.com/");
        private List<Interceptor> interceptors = new ArrayList<>();

        private Buidler() {
        }

        public Buidler baseurl(String baseurl) {//基础url
            if (TextUtils.isEmpty(baseurl)) {
                throw new IllegalArgumentException("baseurl can not be empty");
            }
            this.apiUrl = HttpUrl.parse(baseurl);
            return this;
        }

        public Buidler addInterceptor(Interceptor interceptor) { //动态添加任意个 interceptor
            this.interceptors.add(interceptor);
            return this;
        }

        public GlobeConfigModule build() {
            return new GlobeConfigModule(this);
        }

    }

}
