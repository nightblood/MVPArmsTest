package me.jessyan.mvparms.demo.mvp.presenter;

import android.text.TextUtils;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import me.jessyan.mvparms.demo.di.scope.ActivityScope;
import me.jessyan.mvparms.demo.http.HttpException;
import me.jessyan.mvparms.demo.http.HttpRequestCallback;
import me.jessyan.mvparms.demo.mvp.BasePresenter;
import me.jessyan.mvparms.demo.mvp.contract.DateFragmentContact;
import me.jessyan.mvparms.demo.mvp.model.entity.DateResponse;
import me.jessyan.mvparms.demo.mvp.ui.adapter.DateFragmentAdapter;
import okhttp3.Call;

/**
 * Created by Administrator on 2017/1/18 0018.
 */
@ActivityScope
public class DateFragmentPresenter extends BasePresenter<DateFragmentContact.Model, DateFragmentContact.View>{

    private DateFragmentAdapter mAdapter;
    private List<DateResponse.DateActivityBean> mData = new ArrayList<>();
    private String mPageParam = "";

    public DateFragmentPresenter(DateFragmentContact.Model model, DateFragmentContact.View view) {
        super(model, view);
        mAdapter = new DateFragmentAdapter(mData);
        mRootView.setAdapter(mAdapter);
    }

    public void load() {
        Log.e("debug", "DateFragment: load=================" + mPageParam);
        mModel.getData(mRootView.getContext(), mRootView.getCateId(), mPageParam, new HttpRequestCallback<DateResponse.DateActivityBean>() {
            @Override
            public void onStart() {
               onStartState();
            }

            @Override
            public void onFinish() {
                onFinishState();
            }

            @Override
            public void onResponse(String response) {
                try {
                    Object object = parse(DateResponse.class, response);
                    int preSize = mData.size();
                    if (object != null) {
                        if (TextUtils.isEmpty(mPageParam)) {
                            mData.clear();
                        }
                        DateResponse res = (DateResponse) object;
                        mPageParam = res.getNext_page_params();
                        mData.addAll(res.getInfos());
                        Log.e("debug", "DateFragment: onResponse--------------" + preSize + " " + mData.size());
                    }
                    if (mData.size() == preSize || preSize == 0) {
                        mAdapter.notifyDataSetChanged();
                    } else {
                        mAdapter.notifyItemRangeInserted(preSize, mData.size() - preSize);
                    }

                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                    mRootView.showMessage(throwable.toString());
                }
            }

            @Override
            public void onFailure(Call call, HttpException e) {
                mRootView.showMessage(e.toString());
            }
        });
    }

    public void refresh() {
        Log.e("debug", "DateFragment: refresh=================");
        mRvState = STATE_REFRESH;
        mPageParam = "";
        load();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
