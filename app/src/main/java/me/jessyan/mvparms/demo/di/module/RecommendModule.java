package me.jessyan.mvparms.demo.di.module;

import dagger.Module;
import dagger.Provides;
import me.jessyan.mvparms.demo.mvp.contract.RecommendContact;
import me.jessyan.mvparms.demo.mvp.model.RecommendModel;

/**
 * Created by Administrator on 2017/1/18 0018.
 */
@Module
public class RecommendModule {

    RecommendContact.View mView;
    public RecommendModule(RecommendContact.View view) {
        mView = view;
    }

    @Provides
    RecommendContact.Model provideModel() {
        return new RecommendModel();
    }

    @Provides
    RecommendContact.View provideView() {
        return mView;
    }
}
