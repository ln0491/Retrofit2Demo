package com.liu.retrofit2demo.service;

import com.liu.retrofit2demo.bean.CheckBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @Description: 描述
 * @AUTHOR 刘楠  Create By 2016/9/20 0020 14:35
 */
public interface CheckService {



    @FormUrlEncoded
    @POST("index")
    Call<CheckBean> getInfo(@Field("info")String info,@Field("key")String key);


    @FormUrlEncoded
    @POST("index")
    Call<CheckBean> getInfos(@FieldMap Map<String,String> params);
}
