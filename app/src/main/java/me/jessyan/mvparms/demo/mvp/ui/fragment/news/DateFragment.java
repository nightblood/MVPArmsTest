package me.jessyan.mvparms.demo.mvp.ui.fragment.news;

import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.baoyz.widget.PullRefreshLayout;
import com.paginate.Paginate;
import com.paginate.recycler.LoadingListItemSpanLookup;

import butterknife.BindView;
import common.AppComponent;
import common.WEFragment;
import me.jessyan.mvparms.demo.R;
import me.jessyan.mvparms.demo.di.component.DaggerDateFragmentComponent;
import me.jessyan.mvparms.demo.di.module.news.DateFragmentModule;
import me.jessyan.mvparms.demo.mvp.contract.DateFragmentContact;
import me.jessyan.mvparms.demo.mvp.model.DateFragmentModel;
import me.jessyan.mvparms.demo.mvp.presenter.DateFragmentPresenter;
import me.jessyan.mvparms.demo.mvp.ui.adapter.DateFragmentAdapter;

/**
 * Created by Administrator on 2017/1/18 0018.
 */
public class DateFragment extends WEFragment<DateFragmentPresenter> implements DateFragmentContact.View, PullRefreshLayout.OnRefreshListener{

    @BindView(R.id.recyclerView)
    RecyclerView mRvMain;
    @BindView(R.id.swipelayout)
    PullRefreshLayout mRefreshLayout;
    private Paginate paginate;

    @Override
        protected void setupFragmentComponent(AppComponent appComponent) {
        DaggerDateFragmentComponent.builder()
                .appComponent(appComponent)
                .dateFragmentModule(new DateFragmentModule(this))
                .build()
                .inject(this);
    }
    @Override
    protected View initView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.frag_list, null);
        mRefreshLayout =(PullRefreshLayout) view.findViewById(R.id.swipelayout);
        mRvMain = (RecyclerView)view.findViewById(R.id.recyclerView);
        mPresenter = new DateFragmentPresenter(new DateFragmentModel(), this);
        return view;
    }

    @Override
    protected void initData() {
        mPresenter.load();
    }

    @Override
    public void setAdapter(DateFragmentAdapter adapter) {
        initRecyclerView(adapter);
    }

    private void initRecyclerView(DateFragmentAdapter adapter) {
        mRefreshLayout.setOnRefreshListener(this);
        mRefreshLayout.setRefreshStyle(PullRefreshLayout.STYLE_RING);

        mRvMain.setLayoutManager(new GridLayoutManager(getContext(), 1));
        mRvMain.setHasFixedSize(true);
        mRvMain.setItemAnimator(new DefaultItemAnimator());
        mRvMain.setAdapter(adapter);
        paginate = Paginate.with(mRvMain, new Paginate.Callbacks() {
            @Override
            public void onLoadMore() {
                Log.e("paginate", "onLoadMore");
                if (mPresenter != null)
                    mPresenter.load();
            }

            @Override
            public synchronized boolean isLoading() {
                Log.e("paginate", "isLoading " + mPresenter.isLoading());
                if (mPresenter != null) {
                    return mPresenter.isLoading();
                } else {
                    return false;
                }
            }

            @Override
            public boolean hasLoadedAllItems() {
                Log.e("paginate", "hasLoadedAllItems " + mPresenter.hasLoadedAllItems());
                if (mPresenter != null)
                    return mPresenter.hasLoadedAllItems();
                return false;
            }
        })
                .setLoadingTriggerThreshold(0)
                .addLoadingListItem(true)
                .setLoadingListItemCreator(null)
                .setLoadingListItemSpanSizeLookup(new LoadingListItemSpanLookup() {
                    @Override
                    public int getSpanSize() {
                        return 1;
                    }
                })
                .build();

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {
    }

    @Override
    public void showMessage(String message) {
        showToast(message);
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

    @Override
    public String getCateId() {
        return "";
    }

    @Override
    public void refreshEnd() {
        mRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        mPresenter.refresh();
    }


    /******************* PAGINATE ***********************/
    /*@Override
    public void onLoadMore() {
        Log.e("paginate", "onLoadMore");
        if (mPresenter != null)
            mPresenter.load();
    }

    @Override
    public synchronized boolean isLoading() {
        Log.e("paginate", "isLoading " + mPresenter.isLoading());
        if (mPresenter != null) {
            return mPresenter.isLoading();
        } else {
            return false;
        }
    }

    @Override
    public boolean hasLoadedAllItems() {
        Log.e("paginate", "hasLoadedAllItems " + mPresenter.hasLoadedAllItems());
        if (mPresenter != null)
            return mPresenter.hasLoadedAllItems();
        return false;
    }*/
    /******************** PAGINATE **********************/
    @Override
    public void showRefreshing() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onDestroy();
            mPresenter = null;
        }
        mRvMain = null;
        if (paginate != null) {
            paginate.unbind();
        }
    }
}
