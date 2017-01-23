package me.jessyan.mvparms.demo.mvp.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.tbruyelle.rxpermissions.RxPermissions;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import common.AppComponent;
import common.WEActivity;
import me.jessyan.mvparms.demo.R;
import me.jessyan.mvparms.demo.mvp.presenter.NullPresenter;
import me.jessyan.mvparms.demo.mvp.ui.fragment.FindFragment;
import me.jessyan.mvparms.demo.mvp.ui.fragment.MyFragment;
import me.jessyan.mvparms.demo.mvp.ui.fragment.NewsFragment;
import me.jessyan.mvparms.demo.mvp.ui.fragment.StarFragment;
import me.jessyan.mvparms.demo.mvp.ui.fragment.WeiboFragment;

public class MainActivity extends WEActivity<NullPresenter> {

    @BindView(R.id.fl_container)
    FrameLayout mFlContainer;
//    @BindView(R.id.vp_container)
//    ViewPager mVpContainer;
    @BindView(R.id.ll_news)
    RelativeLayout mLlNews;
    @BindView(R.id.ll_my)
    RelativeLayout mLlMy;
    @BindView(R.id.ll_find)
    RelativeLayout mLlFind;
    @BindView(R.id.ll_weibo)
    RelativeLayout mLlWeibo;
    @BindView(R.id.star)
    View mBarStar;
    @BindView(R.id.weibo)
    View mBarWeibo;
    @BindView(R.id.find)
    View mBarFind;
    @BindView(R.id.my)
    View mBarMy;
    @BindView(R.id.dongtai)
    View mBarNews;
    private List<View> mBarViews = new ArrayList<>();

    private RxPermissions mRxPermissions;
//    private List<Class> mFragmentList = new ArrayList<>();
//    private UserFragment mUserFragment;

    private NewsFragment mNewsFragment;
    private StarFragment mStarFragment;
    private WeiboFragment mWeiboFragment;
    private FindFragment mFindFragment;
    private MyFragment mMyFragment;
    private Fragment mCurrentFragment;

    @Override
    protected View initView() {
        View view = LayoutInflater.from(this).inflate(R.layout.activit_main, null, false);
        mNewsFragment = new NewsFragment();
        mCurrentFragment = mNewsFragment;
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.fl_container, mCurrentFragment).commit();
        return view;
    }

    @Override
    protected void initData() {

        mBarViews.add(mBarNews);
        mBarViews.add(mBarStar);
        mBarViews.add(mBarWeibo);
        mBarViews.add(mBarFind);
        mBarViews.add(mBarMy);
        selectedFragment(0);
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @OnClick({R.id.ll_news, R.id.ll_star, R.id.ll_find,R.id.ll_weibo, R.id.ll_my})
    public void onClick(View view) {
        int id = view.getId();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        int index = 0;
        switch (id) {
            case R.id.ll_find:
                if (mCurrentFragment != null) {
                    transaction.hide(mCurrentFragment);
                }
                if (mFindFragment == null) {
                    mFindFragment = new FindFragment();
                    transaction.add(R.id.fl_container, mFindFragment);
                } else {
                    transaction.show(mFindFragment);
                }
                mCurrentFragment = mFindFragment;
                index = 3;
                break;
            case R.id.ll_weibo:
                if (mCurrentFragment != null) {
                    transaction.hide(mCurrentFragment);
                }
                if (mWeiboFragment == null) {
                    mWeiboFragment = new WeiboFragment();
                    transaction.add(R.id.fl_container, mWeiboFragment);
                } else {
                    transaction.show(mWeiboFragment);
                }
                mCurrentFragment = mWeiboFragment;
                index = 2;
                break;
            case R.id.ll_news:
                if (mCurrentFragment != null) {
                    transaction.hide(mCurrentFragment);
                }
                if (mNewsFragment == null) {
                    mNewsFragment = new NewsFragment();
                    transaction.add(R.id.fl_container, mNewsFragment);
                } else {
                    transaction.show(mNewsFragment);
                }
                mCurrentFragment = mNewsFragment;
                index = 0;
                break;
            case R.id.ll_my:
                if (mCurrentFragment != null) {
                    transaction.hide(mCurrentFragment);
                }
                if (mMyFragment == null) {
                    mMyFragment = new MyFragment();
                    transaction.add(R.id.fl_container, mMyFragment);
                } else {
                    transaction.show(mMyFragment);
                }
                mCurrentFragment = mMyFragment;
                index = 4;
                break;
            case R.id.ll_star:
                if (mCurrentFragment != null) {
                    transaction.hide(mCurrentFragment);
                }
                if (mStarFragment == null) {
                    mStarFragment = new StarFragment();
                    transaction.add(R.id.fl_container, mStarFragment);
                } else {
                    transaction.show(mStarFragment);
                }
                mCurrentFragment = mStarFragment;
                index = 1;
                break;
            default:
                return;
        }
        transaction.commit();
        selectedFragment(index);
    }

    private void selectedFragment(int index) {
        for (int i = 0; i < mBarViews.size(); ++i) {
            if (i == index) mBarViews.get(i).setSelected(true);
            else mBarViews.get(i).setSelected(false);
        }
    }


}
