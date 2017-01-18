package me.jessyan.mvparms.demo.mvp.presenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import me.jessyan.mvparms.demo.di.scope.ActivityScope;
import me.jessyan.mvparms.demo.http.HttpException;
import me.jessyan.mvparms.demo.http.HttpRequestCallback;
import me.jessyan.mvparms.demo.mvp.BasePresenter;
import me.jessyan.mvparms.demo.mvp.contract.RecommendContact;
import me.jessyan.mvparms.demo.mvp.model.entity.NewsRecommend;
import me.jessyan.mvparms.demo.mvp.ui.adapter.RecommendAdapter;
import okhttp3.Call;

/**
 * Created by Administrator on 2017/1/18 0018.
 */
@ActivityScope
public class RecommendPresenter extends BasePresenter<RecommendContact.Model, RecommendContact.View> {

    private RecommendAdapter mAdapter;
    private List<NewsRecommend.InfosBean> mData = new ArrayList<>();

    @Inject
    public RecommendPresenter(RecommendContact.Model model, RecommendContact.View v) {
        super(model, v);

        mAdapter = new RecommendAdapter(mData);
        mRootView.setAdapter(mAdapter);
        mAdapter.setHeader(mRootView.initHeader()); // 设置RecyclerView的Header（第一个Item），然后设置该Item的宽度
        mAdapter.setHeaderSpanSize(mRootView.getLayoutManager());
    }

    public void getData() {
        mModel.getData(mRootView.getContext(), "", new HttpRequestCallback<NewsRecommend>() {
            @Override
            public void onStart() {
                mRootView.showLoading();
            }

            @Override
            public void onFinish() {
                mRootView.hideLoading();
            }

            @Override
            public void onResponse(String response) {
                Object parse = null;
                try {
                    parse = parse(NewsRecommend.class, response);
                    if (parse != null) {
                        mRootView.loadSuccess(parse);
                    }
                    mData.clear();
                    mData.addAll(((NewsRecommend) parse).getInfos());
                    /*RecommendAdapter recommendAdapter = new RecommendAdapter(mData);
                    mRootView.setAdapter(recommendAdapter);
                    recommendAdapter.notifyDataSetChanged();*/
                    mAdapter.notifyDataSetChanged();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call call, HttpException e) {
                mRootView.loadFail();
            }
        });
    }

}
