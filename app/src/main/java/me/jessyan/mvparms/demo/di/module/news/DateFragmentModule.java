package me.jessyan.mvparms.demo.di.module.news;

import dagger.Module;
import me.jessyan.mvparms.demo.mvp.contract.DateFragmentContact;
import me.jessyan.mvparms.demo.mvp.model.DateFragmentModel;

/**
 * Created by Administrator on 2017/1/19 0019.
 */
@Module
public class DateFragmentModule {

    DateFragmentContact.View mView;
    public DateFragmentModule(DateFragmentContact.View view) {
        mView = view;
    }
    DateFragmentContact.View provideView() {
        return mView;
    }
    DateFragmentContact.Model provideModle() {
        return new DateFragmentModel();
    }
}
