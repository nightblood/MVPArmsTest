package me.jessyan.mvparms.demo.mvp.model.api.service;

import me.jessyan.mvparms.demo.mvp.model.entity.LoginResponse;
import me.jessyan.mvparms.demo.mvp.model.entity.SplashData;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2017/1/13 0013.
 */
public interface SplashService {

    @GET("/app.php")
    Observable<SplashData> getData();

    @POST("/app.php")
    Observable<LoginResponse> commit(@Query("user")String id, @Query("password")String pwd);
}
