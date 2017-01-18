package me.jessyan.mvparms.demo.mvp.ui.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import me.jessyan.mvparms.demo.R;

/**
 * Created by Administrator on 2017/1/17 0017.
 */
public class ProgressDialog extends Dialog {

    public ProgressDialog(Context context) {
        super(context);
    }

    public ProgressDialog(Builder builder) {
        super(builder.context);
        View view = LayoutInflater.from(builder.context).inflate(builder.resId, null);
        setContentView(view);
        TextView textView = (TextView) view.findViewById(R.id.tv_desc);
        textView.setText(builder.desc);

    }

    public static class Builder {

        Context context;
        String desc;
        int resId;
        public Builder(Context context) {
            this.context = context;
        }

        public Builder resId(int resId) {
            this.resId = resId;
            return this;
        }

        public Builder desc(String desc) {
            this.desc = desc;
            return this;
        }

        public ProgressDialog build() {
            return new ProgressDialog(this);
        }
    }
}
