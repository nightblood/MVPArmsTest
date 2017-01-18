package me.jessyan.mvparms.demo.mvp.ui.fragment.news;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.baoyz.widget.PullRefreshLayout;

import butterknife.BindView;
import common.AppComponent;
import common.WEFragment;
import me.jessyan.mvparms.demo.R;
import me.jessyan.mvparms.demo.di.component.DaggerRecommendComponent;
import me.jessyan.mvparms.demo.di.module.RecommendModule;
import me.jessyan.mvparms.demo.mvp.contract.RecommendContact;
import me.jessyan.mvparms.demo.mvp.model.RecommendModel;
import me.jessyan.mvparms.demo.mvp.model.entity.NewsRecommend;
import me.jessyan.mvparms.demo.mvp.presenter.RecommendPresenter;
import me.jessyan.mvparms.demo.mvp.ui.adapter.RecommendAdapter;

/**
 * Created by Administrator on 2017/1/18 0018.
 */
public class RecommendFragment extends WEFragment<RecommendPresenter> implements RecommendContact.View, PullRefreshLayout.OnRefreshListener {

    @BindView(R.id.recyclerView)
    RecyclerView mRvMain;
    @BindView(R.id.swipelayout)
    PullRefreshLayout mSwipeLayout;
    NewsRecommend mData;
    @Override
    protected void setupFragmentComponent(AppComponent appComponent) {
        DaggerRecommendComponent.builder()
                .appComponent(appComponent)
                .recommendModule(new RecommendModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected View initView() {
        return LayoutInflater.from(getContext()).inflate(R.layout.frag_recommend, null);
    }

    @Override
    protected void initData() {
        mPresenter= new RecommendPresenter(new RecommendModel(), this);
        mPresenter.getData();
    }

    @Override
    public View initHeader() {
        return LayoutInflater.from(getContext()).inflate(R.layout.ui_title_search, null);
    }

    @Override
    public void setAdapter(RecommendAdapter adapter) {
        mRvMain.setAdapter(adapter);
        initRecyclerView();
    }

    @Override
    public RecyclerView.LayoutManager getLayoutManager() {
        return mRvMain.getLayoutManager();
    }

    @Override
    public void showLoading() {
        mSwipeLayout.setRefreshing(true);

    }

    @Override
    public void hideLoading() {
        mSwipeLayout.setRefreshing(false);

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void loadSuccess(Object o) {
        mData = (NewsRecommend) o;
        mSwipeLayout.setRefreshing(false);

    }

    @Override
    public void loadFail() {
        mSwipeLayout.setRefreshing(false);
    }

    @Override
    public void launchActivity(Intent intent) {

    }

    @Override
    public void killMyself() {

    }

    private void initRecyclerView() {
        mSwipeLayout.setOnRefreshListener(this);
        mSwipeLayout.setRefreshStyle(PullRefreshLayout.STYLE_RING);
        configRecyclerView(mRvMain, new GridLayoutManager(getContext(), 3));
    }

    private void configRecyclerView(RecyclerView recyclerView, RecyclerView.LayoutManager layoutManager) {
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onRefresh() {
        mPresenter.getData();
    }
}
