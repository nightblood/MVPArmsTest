package me.jessyan.mvparms.demo.di.module;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.jessyan.mvparms.demo.widget.imageloader.BaseImageLoaderStrategy;
import me.jessyan.mvparms.demo.widget.imageloader.glide.GlideImageLoaderStrategy;

/**
 * Created by jess on 8/5/16 16:10
 * contact with jess.yan.effort@gmail.com
 */
@Module
public class ImageModule {

    @Singleton
    @Provides
    public BaseImageLoaderStrategy provideImageLoaderStrategy(GlideImageLoaderStrategy glideImageLoaderStrategy) {
        return glideImageLoaderStrategy;
    }

}
