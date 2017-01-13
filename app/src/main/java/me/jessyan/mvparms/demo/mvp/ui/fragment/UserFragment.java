package me.jessyan.mvparms.demo.mvp.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baoyz.widget.PullRefreshLayout;
import com.jess.arms.base.DefaultAdapter;
import com.jess.arms.base.GridItemDecoration;
import com.jess.arms.utils.UiUtils;
import com.paginate.Paginate;
import com.tbruyelle.rxpermissions.RxPermissions;

import butterknife.BindView;
import common.AppComponent;
import common.WEFragment;
import me.jessyan.mvparms.demo.R;
import me.jessyan.mvparms.demo.di.component.DaggerUserComponent;
import me.jessyan.mvparms.demo.di.module.UserModule;
import me.jessyan.mvparms.demo.mvp.contract.UserContract;
import me.jessyan.mvparms.demo.mvp.presenter.UserPresenter;
import me.jessyan.mvparms.demo.mvp.ui.widget.ExceptionView;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import timber.log.Timber;

/**
 * Created by Administrator on 2017/1/10 0010.
 */
public class UserFragment extends WEFragment<UserPresenter> implements UserContract.View, PullRefreshLayout.OnRefreshListener{

    @BindView(R.id.pull_refresh_layout)
    PullRefreshLayout mPullRefreshLayout;

    @Nullable
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    /*@Nullable
    @BindView(R.id.SwipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;*/
    @BindView(R.id.error_view)
    ExceptionView mErrorView;

    private Paginate mPaginate;
    private boolean isLoadingMore;
    private RxPermissions mRxPermissions;

    @Override
    public Context getViewContext() {
        return getContext();
    }

    @Override
    public ViewGroup getParentView() {
        return mRecyclerView;
    }

    @Override
    public View initHeader() {
        View header = LayoutInflater.from(getContext()).inflate(R.layout.ui_title_search, null);
        return header;
    }


    @Override
    protected void setupFragmentComponent(AppComponent appComponent) {
        this.mRxPermissions = new RxPermissions((Activity)getContext());
        DaggerUserComponent.builder()
                .appComponent(appComponent)
                .userModule(new UserModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected View initView() {
        return LayoutInflater.from(getContext()).inflate(R.layout.frag_user, null, false);
    }

    @Override
    protected void initData() {
        mPresenter.requestUsers(true); //打开 app时自动加载列表
        mErrorView.setOnReloadClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRefresh();
            }
        });
    }

    @Override
    public void onRefresh() {
        mPresenter.requestUsers(true);
    }

    private void initRecycleView() {
        mPullRefreshLayout.setRefreshStyle(PullRefreshLayout.STYLE_RING);
        mPullRefreshLayout.setOnRefreshListener(this);
        configRecycleView(mRecyclerView, new GridLayoutManager(getContext(), 3));
    }

    private void configRecycleView(RecyclerView recyclerView, final GridLayoutManager layoutManager) {
        recyclerView.setLayoutManager(layoutManager);
        //如果可以确定每个 item 的高度是固定的，设置这个选项可以提高性能
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new GridItemDecoration(getContext(), true));
        ((DefaultAdapter)recyclerView.getAdapter()).setHeaderSpanSize(layoutManager);
    }

    @Override
    public void showLoading() {
        Timber.tag(TAG).w("showLoading");
        Observable.just(1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        mPullRefreshLayout.setRefreshing(true);
                    }
                });
    }

    @Override
    public void hideLoading() {
        Timber.tag(TAG).w("hideLoading");
        mPullRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showMessage(String message) {
        UiUtils.SnackbarText(message);
    }

    @Override
    public void launchActivity(Intent intent) {
        UiUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
    }

    @Override
    public void setAdapter(DefaultAdapter adapter) {
        mRecyclerView.setAdapter(adapter);
        initRecycleView();
        initPaginate();
    }

    @Override
    public void startLoadMore() {
        isLoadingMore = true;
    }

    @Override
    public void endLoadMore() {
        isLoadingMore = false;
    }

    @Override
    public RxPermissions getRxPermissions() {
        return mRxPermissions;
    }

    @Override
    public void showEmptyData() {
        mRecyclerView.setVisibility(View.GONE);
        mErrorView.setVisibility(View.VISIBLE);
        mErrorView.showEmptyView();
    }

    @Override
    public void showErrorLoad() {
        mRecyclerView.setVisibility(View.GONE);
        mErrorView.setVisibility(View.VISIBLE);
        mErrorView.showLoadErroView();
    }

    private void initPaginate() {
        if (mPaginate == null) {
            Paginate.Callbacks callbacks = new Paginate.Callbacks() {
                @Override
                public void onLoadMore() {
                    mPresenter.requestUsers(false);
                }

                @Override
                public boolean isLoading() {
                    return isLoadingMore;
                }

                @Override
                public boolean hasLoadedAllItems() {
                    return false;
                }
            };

            mPaginate = Paginate.with(mRecyclerView, callbacks)
                    .setLoadingTriggerThreshold(0)
                    .build();
            mPaginate.setHasMoreDataToLoad(false);
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        this.mRxPermissions = null;
        this.mPaginate = null;
    }

}
