package me.jessyan.mvparms.demo.mvp.ui.activity;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.jess.arms.widget.imageloader.ImageLoader;
import com.jess.arms.widget.imageloader.glide.GlideImageConfig;

import butterknife.BindView;
import butterknife.OnClick;
import common.AppComponent;
import common.WEActivity;
import me.jessyan.mvparms.demo.R;
import me.jessyan.mvparms.demo.di.component.DaggerSplashComponent;
import me.jessyan.mvparms.demo.di.module.SplashModule;
import me.jessyan.mvparms.demo.mvp.contract.SplashContract;
import me.jessyan.mvparms.demo.mvp.model.entity.SplashData;
import me.jessyan.mvparms.demo.mvp.presenter.SplashPresenter;

/**
 * Created by Administrator on 2017/1/13 0013.
 */
public class SplashActivity extends WEActivity<SplashPresenter> implements SplashContract.View {

    @BindView(R.id.iv_ad)
    ImageView mIvAd;
    @BindView(R.id.et_account)
    EditText mEtAccount;
    @BindView(R.id.et_pwd)
    EditText mEtPwd;
    @BindView(R.id.btn_commit)
    Button mBtnCommit;

    private ImageLoader mImageLoader;

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerSplashComponent.builder()
                .appComponent(appComponent)
                .splashModule(new SplashModule(this))
                .build()
                .inject(this);
        mImageLoader = appComponent.imageLoader();
    }

    @Override
    protected View initView() {
        return LayoutInflater.from(this).inflate(R.layout.act_splash, null);
    }

    @Override
    protected void initData() {
//        mPresenter.requestData();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void launchActivity(Intent intent) {

    }

    @Override
    public void killMyself() {

    }

    @Override
    public void updateView(SplashData splashData) {
        mImageLoader.loadImage(this,
                GlideImageConfig.builder()
                        .url(splashData.url)
                        .imagerView(mIvAd)
                        .build());
    }

    @OnClick(R.id.btn_commit)
    public void onCommit(View view) {
        mPresenter.login(this,mEtAccount.getText().toString().trim(), mEtPwd.getText().toString().trim());
    }
}
