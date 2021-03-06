package me.jessyan.mvparms.demo.mvp.ui.holder;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.jakewharton.rxbinding.widget.RxTextView;

import common.WEApplication;
import me.jessyan.mvparms.demo.app.utils.ScreenUtils;
import me.jessyan.mvparms.demo.base.BaseHolder;
import me.jessyan.mvparms.demo.mvp.model.entity.User;
import me.jessyan.mvparms.demo.widget.imageloader.ImageLoader;
import me.jessyan.mvparms.demo.widget.imageloader.glide.GlideImageConfig;
import rx.Observable;

/**
 * Created by jess on 9/4/16 12:56
 * Contact with jess.yan.effort@gmail.com
 */
public class UserItemHolder extends BaseHolder<User> {

    @Nullable
//    @BindView(R.id.iv_avatar)
    ImageView mAvater;
    @Nullable
//    @BindView(R.id.tv_name)
    TextView mName;
    private ImageLoader mImageLoader; // 用于加载图片的管理类,默认使用 glide,使用策略模式,可替换框架
    private final WEApplication mApplication;

    public UserItemHolder(View itemView) {
        super(itemView);
        //可以在任何可以拿到 Application的地方,拿到 AppComponent,从而得到用 Dagger管理的单例对象
        mApplication = (WEApplication) itemView.getContext().getApplicationContext();
        mImageLoader = mApplication.getAppComponent().imageLoader();
    }

    @Override
    public void setData(User data) {
        int imageSize = (ScreenUtils.getScreenWidth() / 3);
        mAvater.setLayoutParams(new FrameLayout.LayoutParams(imageSize, imageSize));
        Observable.just(data.getLogin()).subscribe(RxTextView.text(mName));
        mImageLoader.loadImage(mApplication,
                GlideImageConfig.builder()
                        .url(data.getAvatarUrl())
                        .imagerView(mAvater)
                        .build());
    }
}
