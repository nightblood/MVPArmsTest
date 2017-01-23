package me.jessyan.mvparms.demo.mvp.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import common.WEApplication;
import me.jessyan.mvparms.demo.R;
import me.jessyan.mvparms.demo.base.BaseHolder;
import me.jessyan.mvparms.demo.base.DefaultAdapter;
import me.jessyan.mvparms.demo.mvp.model.entity.DateResponse;
import me.jessyan.mvparms.demo.utils.KnifeUtil;
import me.jessyan.mvparms.demo.widget.imageloader.ImageLoader;
import me.jessyan.mvparms.demo.widget.imageloader.glide.GlideImageConfig;

/**
 * Created by Administrator on 2017/1/19 0019.
 */
public class DateFragmentAdapter extends DefaultAdapter<DateResponse.DateActivityBean> {

    private ImageLoader mImageLoader;

    public DateFragmentAdapter(List<DateResponse.DateActivityBean> infos) {
        super(infos);
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
        return R.layout.item_date;
    }

    public class HeaderHolder extends RecyclerView.ViewHolder {

        public HeaderHolder(View v) {
            super(v);
            KnifeUtil.bindTarget(this, v); //绑定
        }
    }

    public class ItemHolder extends BaseHolder<DateResponse.DateActivityBean> {
        @BindView(R.id.iv_icon)
        ImageView icon;
        @BindView(R.id.tv_name)
        TextView name;

        public ItemHolder(View v) {
            super(v);
        }

        @Override
        public void setData(DateResponse.DateActivityBean data) {

            name.setText(data.getUser().getName());
            mImageLoader.loadImage(WEApplication.getInstance().getAppManager().getCurrentActivity()
                    , GlideImageConfig.builder()
                    .url(data.getUser().getHead_portrait())
                    .imagerView(icon)
                    .build());
        }
    }
}
