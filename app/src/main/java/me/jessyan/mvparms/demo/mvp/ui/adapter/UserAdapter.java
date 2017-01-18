package me.jessyan.mvparms.demo.mvp.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import java.util.List;

import me.jessyan.mvparms.demo.R;
import me.jessyan.mvparms.demo.base.DefaultAdapter;
import me.jessyan.mvparms.demo.mvp.model.entity.User;
import me.jessyan.mvparms.demo.mvp.ui.holder.UserItemHolder;

/**
 * Created by jess on 9/4/16 12:57
 * Contact with jess.yan.effort@gmail.com
 */
public class UserAdapter extends DefaultAdapter<User> {
    public UserAdapter(List<User> infos) {
        super(infos);
    }

    @Override
    public RecyclerView.ViewHolder getHolder(View v, int viewType) {
        if (viewType == TYPE_HEADER) {
            return new Holder(v);
        } else {
            return new UserItemHolder(v);
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.recycle_list;
    }

    class Holder extends RecyclerView.ViewHolder {

        EditText mEt;

        public Holder(View item) {
            super(item);
            mEt = (EditText) item.findViewById(R.id.et_search);
        }

    }
}
