package com.liu.retrofit2demo.wrapper;

import com.liu.retrofit2demo.conf.AppUrl;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Description: 描述
 * @AUTHOR 刘楠  Create By 2016/9/19 0019 17:59
 */
public class RetrofitWrapper {

    private static RetrofitWrapper instance;
    private        Retrofit        mRetrofit;

    private RetrofitWrapper() {

        //初始化 添加转换工厂
        mRetrofit = new Retrofit.Builder().baseUrl(Constant.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }


    public static RetrofitWrapper getInstance() {

        if(instance == null) {
            synchronized(RetrofitWrapper.class) {
                if(instance == null) {
                    instance = new RetrofitWrapper();
                }
            }
        }

        return instance;
    }

    /**
     * 转换为对象的Service
     * @param service
     * @param <T>
     * @return
     */
    public <T> T create(Class<T> service){
        return mRetrofit.create(service);
    }

    /**
     * 常量类 基本的URL
     */
    public class Constant {
        //GithubService-base_url
       // public static final String BASE_URL = "https://api.github.com/";

        /**
         * 测试用API路径
         * get 与post 带参数
         */
      public static final String BASE_URL = AppUrl.BASE_URL;
    }
}
