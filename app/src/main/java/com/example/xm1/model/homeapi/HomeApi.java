package com.example.xm1.model.homeapi;

import com.example.xm1.bean.HomeBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface HomeApi {
    @GET("home/content")
    Flowable<HomeBean> getHome();
}
