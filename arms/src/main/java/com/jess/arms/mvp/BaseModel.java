package com.jess.arms.mvp;

import android.content.Context;

import com.jess.arms.http.HttpRequestCallback;
import com.jess.arms.http.HttpRequestUtil;
import com.jess.arms.http.RequestParams;

/**
 * Created by jess on 8/5/16 12:55
 * contact with jess.yan.effort@gmail.com
 */
public class BaseModel implements IModel{

    protected void setPostRequest(Context context, String url, RequestParams params, HttpRequestCallback callback) {

//        HttpRequestUtil.getInstance().postRequest(context, url, params == null ? null : params.toParams(), callback);
        HttpRequestUtil.getInstance().postRequest(context, url, params.toParams(), callback);
    }

    protected void sendGetRequest(Context context, String url, HttpRequestCallback callback) {
        HttpRequestUtil.getInstance().getRequest(context, url, callback);
    }

    @Override
    public void onDestory() {

    }
}
