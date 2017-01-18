package me.jessyan.mvparms.demo.mvp.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.List;

import butterknife.BindView;
import common.WEApplication;
import me.jessyan.mvparms.demo.R;
import me.jessyan.mvparms.demo.app.utils.ScreenUtils;
import me.jessyan.mvparms.demo.base.BaseActivity;
import me.jessyan.mvparms.demo.base.BaseHolder;
import me.jessyan.mvparms.demo.base.DefaultAdapter;
import me.jessyan.mvparms.demo.mvp.model.entity.NewsRecommend;
import me.jessyan.mvparms.demo.utils.KnifeUtil;
import me.jessyan.mvparms.demo.widget.imageloader.ImageLoader;
import me.jessyan.mvparms.demo.widget.imageloader.glide.GlideImageConfig;

/**
 * Created by Administrator on 2017/1/18 0018.
 */
public class RecommendAdapter extends DefaultAdapter<NewsRecommend.InfosBean> {

    private BaseActivity mCurrentActivity;
    private ImageLoader mImageLoader;

    public RecommendAdapter(List<NewsRecommend.InfosBean> infos) {
        super(infos);
        mCurrentActivity = WEApplication.getInstance().getAppManager().getCurrentActivity();
        mImageLoader = WEApplication.getInstance().getAppComponent().imageLoader();
    }

    @Override
    public RecyclerView.ViewHolder getHolder(View v, int viewType) {
        if (viewType == TYPE_HEADER) {
            return new HeaderHolder(v);
        } else {
            return new ItemHolder(v);
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_recommend;
    }

    public class HeaderHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.et_search)
        EditText mEt;
        public HeaderHolder(View v) {
            super(v);
            KnifeUtil.bindTarget(this, v); //绑定
        }
    }

    public class ItemHolder extends BaseHolder<NewsRecommend.InfosBean> {

        @BindView(R.id.iv_header)
        ImageView mAvater;

        public ItemHolder(View v) {
            super(v);
            int imageSize = (ScreenUtils.getScreenWidth() / 3);
            v.setLayoutParams(new ViewGroup.LayoutParams(imageSize, imageSize));
        }

        @Override
        public void setData(NewsRecommend.InfosBean data) {
            int imageSize = (ScreenUtils.getScreenWidth() / 3);
            mAvater.setLayoutParams(new RelativeLayout.LayoutParams(imageSize, imageSize));
            mImageLoader.loadImage(WEApplication.getInstance(),
                    GlideImageConfig.builder()
                            .url(data.getHead_portrait())
                            .imagerView(mAvater)
                            .build());
        }
    }
}
