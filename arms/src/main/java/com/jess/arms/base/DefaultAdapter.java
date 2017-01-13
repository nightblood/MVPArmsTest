package com.jess.arms.base;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by jess on 2015/11/27.
 */
public abstract class DefaultAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int TYPE_HEADER = 1;
    public static final int TYPE_NOMAL = 2;
    protected List<T> mInfos;
    protected OnRecyclerViewItemClickListener mOnItemClickListener = null;
    private RecyclerView.ViewHolder mHolder;
    protected View header;

    public DefaultAdapter(List<T> infos) {
        super();
        this.mInfos = infos;
    }

    public void setHeader(View header) {
        this.header = header;
    }

    public View getHeader() {
        return header;
    }

    /**
     * 创建Hodler
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            mHolder = getHolder(header, viewType);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(getLayoutId(), parent, false);
            mHolder = getHolder(view, viewType);
            ((BaseHolder) mHolder).setOnItemClickListener(new BaseHolder.OnViewClickListener() {//设置Item点击事件
                @Override
                public void onViewClick(View view, int position) {
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClick(view, mInfos.get(position), position);
                    }
                }
            });
        }
        return mHolder;
    }

   /* @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager instanceof GridLayoutManager) {
            final GridLayoutManager gridLayoutManager = (GridLayoutManager) manager;
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    return getItemViewType(position) == TYPE_HEADER ?
                            gridLayoutManager.getSpanCount() : 1;
                }
            });
        }
    }*/

    public void setHeaderSpanSize(RecyclerView.LayoutManager manager) {
        if (manager instanceof GridLayoutManager) {
            final GridLayoutManager gridLayoutManager = (GridLayoutManager) manager;
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    return getItemViewType(position) == TYPE_HEADER ?
                            gridLayoutManager.getSpanCount() : 1;
                }
            });
        }
    }

    /**
     * 绑定数据
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == 0 && header != null) {
            ;
        } else {
            ((BaseHolder)holder).setData(mInfos.get(position));
        }
    }

    @Override
    public int getItemViewType(int position) {

        if (position == 0 && header != null) {
            return TYPE_HEADER;
        }
        return TYPE_NOMAL;
    }

    @Override
    public int getItemCount() {
        return mInfos.size();
    }

    public List<T> getInfos() {
        return mInfos;
    }

    public T getItem(int position) {
        return mInfos == null ? null : mInfos.get(position);
    }

    /**
     * 子类实现提供holder
     * @param v
     * @return
     */
    public abstract RecyclerView.ViewHolder getHolder(View v, int viewType);

    /**
     * 提供Item的布局
     * @return
     */
    public abstract int getLayoutId();

    public interface OnRecyclerViewItemClickListener<T> {
        void onItemClick(View view, T data, int position);
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
}
