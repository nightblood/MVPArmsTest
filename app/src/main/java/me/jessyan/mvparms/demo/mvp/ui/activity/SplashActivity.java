package me.jessyan.mvparms.demo.mvp.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.OnClick;
import common.AppComponent;
import common.WEActivity;
import me.jessyan.mvparms.demo.R;
import me.jessyan.mvparms.demo.di.component.DaggerSplashComponent;
import me.jessyan.mvparms.demo.di.module.SplashModule;
import me.jessyan.mvparms.demo.mvp.contract.SplashContract;
import me.jessyan.mvparms.demo.mvp.model.entity.LoginResponse;
import me.jessyan.mvparms.demo.mvp.model.entity.SplashData;
import me.jessyan.mvparms.demo.mvp.presenter.SplashPresenter;
import me.jessyan.mvparms.demo.mvp.ui.widget.ProgressDialog;
import me.jessyan.mvparms.demo.widget.CustomPopupWindow;
import me.jessyan.mvparms.demo.widget.imageloader.ImageLoader;
import me.jessyan.mvparms.demo.widget.imageloader.glide.GlideImageConfig;

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
    @BindView(R.id.rl_rootview)
    RelativeLayout mRlRootView;

    private ImageLoader mImageLoader;
    private CustomPopupWindow mPopupWindow;
    private ProgressDialog mProgressDialog;

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
        mProgressDialog = new ProgressDialog.Builder(this)
                .desc("hello")
                .resId(R.layout.ui_progressbar)
                .build();

    }

    @Override
    public void showLoading() {
        mProgressDialog.show();
    }

    @Override
    public void hideLoading() {
//        mProgressDialog.dismiss();
    }

    @Override
    public void showMessage(String message) {
//        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        Snackbar.make(mIvAd, message, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void launchActivity(Intent intent) {

    }

    @Override
    public void killMyself() {

    }

    @Override
    public Context getContext() {
        return this;
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
        mPresenter.login(this, mEtAccount.getText().toString().trim(), mEtPwd.getText().toString().trim());
    }

    @Override
    public void loadFail() {
       /* new AlertDialog.Builder(this)
                .setTitle("title")
                .setMessage("message")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();*/
    }

    @Override
    public void loadSuccess(Object o) {
        LoginResponse loginResponse = (LoginResponse) o;
//        LoginResponse.Body value = loginResponse.getValue();
        Log.e("loadSuccess", loginResponse.getName());

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

                /*String userCfg = FileUtils.getConfigFromFile("user_info.cfg");
                Log.e("user_info", userCfg);
                JsonParser jsonParser = new JsonParser();
                JsonObject jsonObject = jsonParser.parse(userCfg).getAsJsonObject();
                JsonObject value = jsonObject.get("value").getAsJsonObject();
                Gson gson = new Gson();
                LoginResponse response = gson.fromJson(value, LoginResponse.class);
                Log.e("loadSuccess", response.getName());*/


        /*new AlertDialog.Builder(this)
                .setTitle("title")
                .setMessage("message")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();*/
    }
}
