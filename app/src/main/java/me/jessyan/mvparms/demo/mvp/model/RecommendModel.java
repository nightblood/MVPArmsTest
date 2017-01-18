package me.jessyan.mvparms.demo.mvp.model;

import android.content.Context;

import me.jessyan.mvparms.demo.app.utils.Constants;
import me.jessyan.mvparms.demo.http.HttpRequestCallback;
import me.jessyan.mvparms.demo.http.RequestParams;
import me.jessyan.mvparms.demo.mvp.BaseModel;
import me.jessyan.mvparms.demo.mvp.contract.RecommendContact;

/**
 * Created by Administrator on 2017/1/18 0018.
 */
public class RecommendModel extends BaseModel implements RecommendContact.Model {

    @Override
    public void getData(Context context, String gender, HttpRequestCallback callback) {
        RequestParams params = new RequestParams();
        params.put("gender", gender);
        setPostRequest(context, Constants.URL_NEWS_RECOMMEND, params, callback);
    }
}
