package me.jessyan.mvparms.demo.mvp.ui.fragment.news;

import android.content.Intent;
import android.view.View;

import me.jessyan.mvparms.demo.base.BaseFragment;
import me.jessyan.mvparms.demo.mvp.contract.DateContact;
import me.jessyan.mvparms.demo.mvp.presenter.DatePresenter;

/**
 * Created by Administrator on 2017/1/18 0018.
 */
public class DateFragment extends BaseFragment<DatePresenter> implements DateContact.View{

    @Override
    protected void ComponentInject() {
        // DaggeC
    }

    @Override
    protected View initView() {
        return null;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void loadSuccess(Object o) {

    }

    @Override
    public void loadFail() {

    }

    @Override
    public void launchActivity(Intent intent) {

    }

    @Override
    public void killMyself() {

    }
}
