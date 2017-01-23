package me.jessyan.mvparms.demo.mvp.model;

import android.content.Context;

import me.jessyan.mvparms.demo.http.HttpRequestCallback;
import me.jessyan.mvparms.demo.mvp.BaseModel;
import me.jessyan.mvparms.demo.mvp.contract.DateFragmentContact;
import okhttp3.HttpUrl;

/**
 * Created by Administrator on 2017/1/19 0019.
 */
public class DateFragmentModel extends BaseModel implements DateFragmentContact.Model{

    @Override
    public void getData(Context context, String cateid, String pageParam, HttpRequestCallback callback) {
//        RequestParams params = new RequestParams();
//        params.put("category_id", cateid);
//        params.put("page_params", pageParam);
//        setPostRequest(context, Constants.URL_NEWS_DATE_INFO, params, callback);

        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host("app.0575.com")
                .addPathSegment("app.php")
                .addQueryParameter("c", "Invite")
                .addQueryParameter("a", "ActivityList")
                .addQueryParameter("category_id", cateid)
                .addQueryParameter("page_params", pageParam)
                .build();

        sendGetRequest(context, url, callback);
    }
}
