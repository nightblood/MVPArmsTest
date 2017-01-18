package me.jessyan.mvparms.demo.mvp.presenter;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import me.jessyan.mvparms.demo.base.AppManager;
import me.jessyan.mvparms.demo.base.DefaultAdapter;
import me.jessyan.mvparms.demo.di.scope.ActivityScope;
import me.jessyan.mvparms.demo.mvp.BasePresenter;
import me.jessyan.mvparms.demo.mvp.contract.UserContract;
import me.jessyan.mvparms.demo.mvp.model.entity.User;
import me.jessyan.mvparms.demo.mvp.ui.adapter.UserAdapter;
import me.jessyan.mvparms.demo.utils.PermissionUtil;
import me.jessyan.mvparms.demo.utils.RxUtils;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * Created by jess on 9/4/16 10:59
 * Contact with jess.yan.effort@gmail.com
 */
@ActivityScope
public class UserPresenter extends BasePresenter<UserContract.Model, UserContract.View> {
//    private RxErrorHandler mErrorHandler;
    private AppManager mAppManager;
    private Application mApplication;
    private List<User> mUsers = new ArrayList<>();
    private DefaultAdapter mAdapter;
    private int lastUserId = 1;

    @Inject
    public UserPresenter(UserContract.Model model, UserContract.View rootView
            , AppManager appManager, Application application) {
        //UserContract.Model , UserContract.View 由UserModule 创建实例
        //
        super(model, rootView);
        this.mApplication = application;
        this.mAppManager = appManager;
        mAdapter = new UserAdapter(mUsers);

//        View header = LayoutInflater.from(mRootView.getViewContext()).inflate(R.layout.ui_header, mRootView.getParentView(), false);
        mAdapter.setHeader(mRootView.initHeader());
        mRootView.setAdapter(mAdapter); //设置 Adapter, 调用UserFragment的setAdapter方法.mRootView即是UserFragment
    }

    public void requestUsers(final boolean pullToRefresh) {
        // 请求外部存储权限用于适配 android6.0的权限管理机制
        PermissionUtil.externalStorage(new PermissionUtil.RequestPermission() {
            @Override
            public void onRequestPermissionSuccess() {
                //request permission success, do something.
            }
        }, mRootView.getRxPermissions(), mRootView);

        if (pullToRefresh) lastUserId = 1;

        mModel.getUsers(lastUserId, pullToRefresh)
                .subscribeOn(Schedulers.io())
//                .retryWhen(new RetryWithDelay(3, 2))//遇到错误时重试,第一个参数为重试几次,第二个参数为重试的间隔
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        if (pullToRefresh)
                            mRootView.showLoading();//显示下拉刷新的进度条
                        else
                            mRootView.startLoadMore();
                    }
                }).subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doAfterTerminate(new Action0() {
                    @Override
                    public void call() {
                        if (pullToRefresh)
                            mRootView.hideLoading();//隐藏下拉刷新的进度条
                        else
                            mRootView.endLoadMore();
                    }
                })
                .compose(RxUtils.<List<User>>bindToLifecycle(mRootView))//使用RXlifecycle,使 subscription和 activity一起销毁
                .subscribe(new Subscriber<List<User>>() {
                    @Override
                    public void onNext(List<User> users) {
                        lastUserId = users.get(users.size() - 1).getId();//记录最后一个id,用于下一次请求
                        if (pullToRefresh) mUsers.clear();//如果是上拉刷新则晴空列表
                        for (User user : users) {
                            mUsers.add(user);
                        }
                        mAdapter.notifyDataSetChanged(); //通知更新数据
                    }

                    @Override
                    public void onError(Throwable e) {
                        // 请求失败处理
                    }

                    @Override
                    public void onCompleted() {
                    }
                });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mAdapter = null;
        this.mUsers = null;
        this.mAppManager = null;
        this.mApplication = null;
    }


}
