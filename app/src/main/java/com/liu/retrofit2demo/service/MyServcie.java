package com.liu.retrofit2demo.service;

import com.liu.retrofit2demo.bean.UseHelpBean;
import com.liu.retrofit2demo.conf.AppUrl;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * @Description: 描述
 * @AUTHOR 刘楠  Create By 2016/9/20 0020 11:41
 */
public interface MyServcie {



    @GET(AppUrl.GET_USE_HELP)
    Call<UseHelpBean> getUseHelp(@Query("sign")String sign,@Query("appKey") String appKey,@Query("osName")int osName);


    @GET(AppUrl.GET_USE_HELP)
    Call<UseHelpBean> getUseHelps(@QueryMap Map<String,String> params);



}
