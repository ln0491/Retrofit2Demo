package com.liu.retrofit2demo.service;

import com.liu.retrofit2demo.bean.WeatherData;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * @Description: 描述
 * @AUTHOR 刘楠  Create By 2016/9/20 0020 13:50
 */

public interface WeatherService {


    @GET("index")
    Call<WeatherData> getWeather(@Query("cityname") String cityname,@Query("key") String key,@Query("dtype") String dtype,@Query("format") int format);


    @GET("index")
    Call<WeatherData> getWeathers(@QueryMap Map<String,String> params);
}
