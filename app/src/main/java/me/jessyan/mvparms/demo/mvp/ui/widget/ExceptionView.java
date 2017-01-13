package me.jessyan.mvparms.demo.mvp.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import me.jessyan.mvparms.demo.R;

/**
 * Created by Administrator on 2017/1/12 0012.
 */
public class ExceptionView extends FrameLayout {

    private View mLoadErroView;
    private View mEmptyView;
    private OnClickListener mOnReloadListener;

    public ExceptionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        mLoadErroView = inflate(getContext(), R.layout.ui_error_load, null);
        mEmptyView = inflate(getContext(), R.layout.ui_error_empty, null);
        mEmptyView.setOnClickListener(mOnReloadListener);
        mLoadErroView.setOnClickListener(mOnReloadListener);
        addView(mLoadErroView);
        addView(mEmptyView);
    }

    public void showLoadErroView() {
        mEmptyView.setVisibility(GONE);
        mLoadErroView.setVisibility(VISIBLE);
//        removeAllViews();
//        addView(mLoadErroView);
    }

    public void showEmptyView() {
        mEmptyView.setVisibility(VISIBLE);
        mLoadErroView.setVisibility(GONE);
    }

    public void setOnReloadClickListener(OnClickListener onClickListener) {
        mOnReloadListener = onClickListener;
    }
}
