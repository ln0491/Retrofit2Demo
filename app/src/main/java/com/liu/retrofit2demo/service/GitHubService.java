package com.liu.retrofit2demo.service;

import com.liu.retrofit2demo.bean.GithubBean;
import com.liu.retrofit2demo.bean.Repo;
import com.liu.retrofit2demo.bean.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @Description: 描述
 * @AUTHOR 刘楠  Create By 2016/9/19 0019 17:57
 */
public interface GitHubService {


    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);


    @GET("users/list")
    Call<User> getUser();

    @GET("/")
    Call<GithubBean> getGitHubApi();
}
