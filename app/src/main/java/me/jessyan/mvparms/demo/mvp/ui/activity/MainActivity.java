package me.jessyan.mvparms.demo.mvp.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.tbruyelle.rxpermissions.RxPermissions;

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
//        mNewsFragment = new NewsFragment();
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.fl_container, mNewsFragment).commit();
        mCurrentFragment = mNewsFragment;
        return view;
    }

    @Override
    protected void initData() {

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
                break;
            default:
                return;
        }
        transaction.commit();
    }


}
