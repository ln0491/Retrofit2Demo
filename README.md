##Retrofit 入门学习官方RetrofitAPI

### 官方的一个例子

    public interface GitHubService {
      @GET("users/{user}/repos")
      Call<List<Repo>> listRepos(@Path("user") String user);
    }
这些注解都有一个参数 value，用来配置其路径，比如示例中的 users/{user}/repos，
我们还注意到在构造 Retrofit 之时我们还传入了一个
 baseUrl("https://api.github.com/")，请求的完整 Url

    https://api.github.com/users/{user}/repos 传入user参数替换{user}

 就是通过 baseUrl 与注解的 value（下面称 “path“ ） 整合起来的，具体整合的规则如下：

        path 是绝对路径的形式：
        path = "/apath"，baseUrl = "http://host:port/a/b"
          Url = "http://host:port/apath"
        path 是相对路径，baseUrl 是目录形式：
          path = "apath"，baseUrl = "http://host:port/a/b/"
          Url = "http://host:port/a/b/apath"
        path 是相对路径，baseUrl 是文件形式：
          path = "apath"，baseUrl = "http://host:port/a/b"
          Url = "http://host:port/a/apath"
        path 是完整的 Url：
          path = "http://host:port/aa/apath"，baseUrl = "http://host:port/a/b"
          Url = "http://host:port/aa/apath"

(@Path("user") String user) 中user参数会替换 @GET("users/{user}/repos")中的{user}

建议采用第二种方式来配置，并尽量使用同一种路径形式

> 请求

    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .build();

    GitHubService service = retrofit.create(GitHubService.class);

> 调用

    Call<List<Repo>> repos = service.listRepos("octocat");

这个是个什么鬼List<Repo> 找了半天没找到Repo这个类

尝试去访问

    https://api.github.com/users/octocat/repos

终于有东东了，把结果转成JAVA BEAN


        package com.liu.retrofit2demo.bean;

        import com.google.gson.annotations.SerializedName;

        /**
         * @Description: 描述
         * @AUTHOR 刘楠  Create By 2016/9/19 0019 18:10
         */
        public class Repo {


            /**
             * id : 68529654
             * name : aidlDemo
             * full_name : ln0491/aidlDemo
             * owner : {"login":"ln0491","id":10574995,"avatar_url":"https://avatars.githubusercontent.com/u/10574995?v=3","gravatar_id":"","url":"https://api.github.com/users/ln0491","html_url":"https://github.com/ln0491","followers_url":"https://api.github.com/users/ln0491/followers","following_url":"https://api.github.com/users/ln0491/following{/other_user}","gists_url":"https://api.github.com/users/ln0491/gists{/gist_id}","starred_url":"https://api.github.com/users/ln0491/starred{/owner}{/repo}","subscriptions_url":"https://api.github.com/users/ln0491/subscriptions","organizations_url":"https://api.github.com/users/ln0491/orgs","repos_url":"https://api.github.com/users/ln0491/repos","events_url":"https://api.github.com/users/ln0491/events{/privacy}","received_events_url":"https://api.github.com/users/ln0491/received_events","type":"User","site_admin":false}
             * private : false
             * html_url : https://github.com/ln0491/aidlDemo
             * description : null
             * fork : false
             * url : https://api.github.com/repos/ln0491/aidlDemo
             * forks_url : https://api.github.com/repos/ln0491/aidlDemo/forks
             * keys_url : https://api.github.com/repos/ln0491/aidlDemo/keys{/key_id}
             * collaborators_url : https://api.github.com/repos/ln0491/aidlDemo/collaborators{/collaborator}
             * teams_url : https://api.github.com/repos/ln0491/aidlDemo/teams
             * hooks_url : https://api.github.com/repos/ln0491/aidlDemo/hooks
             * issue_events_url : https://api.github.com/repos/ln0491/aidlDemo/issues/events{/number}
             * events_url : https://api.github.com/repos/ln0491/aidlDemo/events
             * assignees_url : https://api.github.com/repos/ln0491/aidlDemo/assignees{/user}
             * branches_url : https://api.github.com/repos/ln0491/aidlDemo/branches{/branch}
             * tags_url : https://api.github.com/repos/ln0491/aidlDemo/tags
             * blobs_url : https://api.github.com/repos/ln0491/aidlDemo/git/blobs{/sha}
             * git_tags_url : https://api.github.com/repos/ln0491/aidlDemo/git/tags{/sha}
             * git_refs_url : https://api.github.com/repos/ln0491/aidlDemo/git/refs{/sha}
             * trees_url : https://api.github.com/repos/ln0491/aidlDemo/git/trees{/sha}
             * statuses_url : https://api.github.com/repos/ln0491/aidlDemo/statuses/{sha}
             * languages_url : https://api.github.com/repos/ln0491/aidlDemo/languages
             * stargazers_url : https://api.github.com/repos/ln0491/aidlDemo/stargazers
             * contributors_url : https://api.github.com/repos/ln0491/aidlDemo/contributors
             * subscribers_url : https://api.github.com/repos/ln0491/aidlDemo/subscribers
             * subscription_url : https://api.github.com/repos/ln0491/aidlDemo/subscription
             * commits_url : https://api.github.com/repos/ln0491/aidlDemo/commits{/sha}
             * git_commits_url : https://api.github.com/repos/ln0491/aidlDemo/git/commits{/sha}
             * comments_url : https://api.github.com/repos/ln0491/aidlDemo/comments{/number}
             * issue_comment_url : https://api.github.com/repos/ln0491/aidlDemo/issues/comments{/number}
             * contents_url : https://api.github.com/repos/ln0491/aidlDemo/contents/{+path}
             * compare_url : https://api.github.com/repos/ln0491/aidlDemo/compare/{base}...{head}
             * merges_url : https://api.github.com/repos/ln0491/aidlDemo/merges
             * archive_url : https://api.github.com/repos/ln0491/aidlDemo/{archive_format}{/ref}
             * downloads_url : https://api.github.com/repos/ln0491/aidlDemo/downloads
             * issues_url : https://api.github.com/repos/ln0491/aidlDemo/issues{/number}
             * pulls_url : https://api.github.com/repos/ln0491/aidlDemo/pulls{/number}
             * milestones_url : https://api.github.com/repos/ln0491/aidlDemo/milestones{/number}
             * notifications_url : https://api.github.com/repos/ln0491/aidlDemo/notifications{?since,all,participating}
             * labels_url : https://api.github.com/repos/ln0491/aidlDemo/labels{/name}
             * releases_url : https://api.github.com/repos/ln0491/aidlDemo/releases{/id}
             * deployments_url : https://api.github.com/repos/ln0491/aidlDemo/deployments
             * created_at : 2016-09-18T15:24:32Z
             * updated_at : 2016-09-18T15:29:01Z
             * pushed_at : 2016-09-19T06:06:09Z
             * git_url : git://github.com/ln0491/aidlDemo.git
             * ssh_url : git@github.com:ln0491/aidlDemo.git
             * clone_url : https://github.com/ln0491/aidlDemo.git
             * svn_url : https://github.com/ln0491/aidlDemo
             * homepage : null
             * size : 229
             * stargazers_count : 0
             * watchers_count : 0
             * language : Java
             * has_issues : true
             * has_downloads : true
             * has_wiki : true
             * has_pages : false
             * forks_count : 0
             * mirror_url : null
             * open_issues_count : 0
             * forks : 0
             * open_issues : 0
             * watchers : 0
             * default_branch : master
             */

            public int id;
            public String name;
            public String full_name;
            /**
             * login : ln0491
             * id : 10574995
             * avatar_url : https://avatars.githubusercontent.com/u/10574995?v=3
             * gravatar_id :
             * url : https://api.github.com/users/ln0491
             * html_url : https://github.com/ln0491
             * followers_url : https://api.github.com/users/ln0491/followers
             * following_url : https://api.github.com/users/ln0491/following{/other_user}
             * gists_url : https://api.github.com/users/ln0491/gists{/gist_id}
             * starred_url : https://api.github.com/users/ln0491/starred{/owner}{/repo}
             * subscriptions_url : https://api.github.com/users/ln0491/subscriptions
             * organizations_url : https://api.github.com/users/ln0491/orgs
             * repos_url : https://api.github.com/users/ln0491/repos
             * events_url : https://api.github.com/users/ln0491/events{/privacy}
             * received_events_url : https://api.github.com/users/ln0491/received_events
             * type : User
             * site_admin : false
             */

            public OwnerEntity owner;
            @SerializedName("private")
            public boolean privateX;
            public String  html_url;
            public Object  description;
            public boolean fork;
            public String  url;
            public String  forks_url;
            public String  keys_url;
            public String  collaborators_url;
            public String  teams_url;
            public String  hooks_url;
            public String  issue_events_url;
            public String  events_url;
            public String  assignees_url;
            public String  branches_url;
            public String  tags_url;
            public String  blobs_url;
            public String  git_tags_url;
            public String  git_refs_url;
            public String  trees_url;
            public String  statuses_url;
            public String  languages_url;
            public String  stargazers_url;
            public String  contributors_url;
            public String  subscribers_url;
            public String  subscription_url;
            public String  commits_url;
            public String  git_commits_url;
            public String  comments_url;
            public String  issue_comment_url;
            public String  contents_url;
            public String  compare_url;
            public String  merges_url;
            public String  archive_url;
            public String  downloads_url;
            public String  issues_url;
            public String  pulls_url;
            public String  milestones_url;
            public String  notifications_url;
            public String  labels_url;
            public String  releases_url;
            public String  deployments_url;
            public String  created_at;
            public String  updated_at;
            public String  pushed_at;
            public String  git_url;
            public String  ssh_url;
            public String  clone_url;
            public String  svn_url;
            public Object  homepage;
            public int     size;
            public int     stargazers_count;
            public int     watchers_count;
            public String  language;
            public boolean has_issues;
            public boolean has_downloads;
            public boolean has_wiki;
            public boolean has_pages;
            public int     forks_count;
            public Object  mirror_url;
            public int     open_issues_count;
            public int     forks;
            public int     open_issues;
            public int     watchers;
            public String  default_branch;

            public static class OwnerEntity {
                public String  login;
                public int     id;
                public String  avatar_url;
                public String  gravatar_id;
                public String  url;
                public String  html_url;
                public String  followers_url;
                public String  following_url;
                public String  gists_url;
                public String  starred_url;
                public String  subscriptions_url;
                public String  organizations_url;
                public String  repos_url;
                public String  events_url;
                public String  received_events_url;
                public String  type;
                public boolean site_admin;

                @Override
                public String toString() {
                    return "OwnerEntity{" +
                            "login='" + login + '\'' +
                            ", id=" + id +
                            ", avatar_url='" + avatar_url + '\'' +
                            ", gravatar_id='" + gravatar_id + '\'' +
                            ", url='" + url + '\'' +
                            ", html_url='" + html_url + '\'' +
                            ", followers_url='" + followers_url + '\'' +
                            ", following_url='" + following_url + '\'' +
                            ", gists_url='" + gists_url + '\'' +
                            ", starred_url='" + starred_url + '\'' +
                            ", subscriptions_url='" + subscriptions_url + '\'' +
                            ", organizations_url='" + organizations_url + '\'' +
                            ", repos_url='" + repos_url + '\'' +
                            ", events_url='" + events_url + '\'' +
                            ", received_events_url='" + received_events_url + '\'' +
                            ", type='" + type + '\'' +
                            ", site_admin=" + site_admin +
                            '}';
                }
            }

            @Override
            public String toString() {
                return "Repo{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", full_name='" + full_name + '\'' +
                        ", owner=" + owner +
                        ", privateX=" + privateX +
                        ", html_url='" + html_url + '\'' +
                        ", description=" + description +
                        ", fork=" + fork +
                        ", url='" + url + '\'' +
                        ", forks_url='" + forks_url + '\'' +
                        ", keys_url='" + keys_url + '\'' +
                        ", collaborators_url='" + collaborators_url + '\'' +
                        ", teams_url='" + teams_url + '\'' +
                        ", hooks_url='" + hooks_url + '\'' +
                        ", issue_events_url='" + issue_events_url + '\'' +
                        ", events_url='" + events_url + '\'' +
                        ", assignees_url='" + assignees_url + '\'' +
                        ", branches_url='" + branches_url + '\'' +
                        ", tags_url='" + tags_url + '\'' +
                        ", blobs_url='" + blobs_url + '\'' +
                        ", git_tags_url='" + git_tags_url + '\'' +
                        ", git_refs_url='" + git_refs_url + '\'' +
                        ", trees_url='" + trees_url + '\'' +
                        ", statuses_url='" + statuses_url + '\'' +
                        ", languages_url='" + languages_url + '\'' +
                        ", stargazers_url='" + stargazers_url + '\'' +
                        ", contributors_url='" + contributors_url + '\'' +
                        ", subscribers_url='" + subscribers_url + '\'' +
                        ", subscription_url='" + subscription_url + '\'' +
                        ", commits_url='" + commits_url + '\'' +
                        ", git_commits_url='" + git_commits_url + '\'' +
                        ", comments_url='" + comments_url + '\'' +
                        ", issue_comment_url='" + issue_comment_url + '\'' +
                        ", contents_url='" + contents_url + '\'' +
                        ", compare_url='" + compare_url + '\'' +
                        ", merges_url='" + merges_url + '\'' +
                        ", archive_url='" + archive_url + '\'' +
                        ", downloads_url='" + downloads_url + '\'' +
                        ", issues_url='" + issues_url + '\'' +
                        ", pulls_url='" + pulls_url + '\'' +
                        ", milestones_url='" + milestones_url + '\'' +
                        ", notifications_url='" + notifications_url + '\'' +
                        ", labels_url='" + labels_url + '\'' +
                        ", releases_url='" + releases_url + '\'' +
                        ", deployments_url='" + deployments_url + '\'' +
                        ", created_at='" + created_at + '\'' +
                        ", updated_at='" + updated_at + '\'' +
                        ", pushed_at='" + pushed_at + '\'' +
                        ", git_url='" + git_url + '\'' +
                        ", ssh_url='" + ssh_url + '\'' +
                        ", clone_url='" + clone_url + '\'' +
                        ", svn_url='" + svn_url + '\'' +
                        ", homepage=" + homepage +
                        ", size=" + size +
                        ", stargazers_count=" + stargazers_count +
                        ", watchers_count=" + watchers_count +
                        ", language='" + language + '\'' +
                        ", has_issues=" + has_issues +
                        ", has_downloads=" + has_downloads +
                        ", has_wiki=" + has_wiki +
                        ", has_pages=" + has_pages +
                        ", forks_count=" + forks_count +
                        ", mirror_url=" + mirror_url +
                        ", open_issues_count=" + open_issues_count +
                        ", forks=" + forks +
                        ", open_issues=" + open_issues +
                        ", watchers=" + watchers +
                        ", default_branch='" + default_branch + '\'' +
                        '}';
            }
        }


## 使用
### 导入依赖

         compile 'com.squareup.retrofit2:retrofit:2.1.0'
        compile 'com.squareup.retrofit2:converter-gson:2.1.0'


### 建立Service



    public interface GitHubService {


        @GET("users/{user}/repos")
        Call<List<Repo>> listRepos(@Path("user") String user);
    }

### 构造 Retrofit 使用单例


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
                //BASE_URL 可以自行替换
            public static final String BASE_URL = "https://api.github.com/";
        }
    }

### 在Activity中调用

>添加网络权限

      <uses-permission android:name="android.permission.INTERNET"/>

>在点击事件时调用

    private void getUserRepo() {

            GitHubService gitHubService = RetrofitWrapper.getInstance().create(GitHubService.class);

            Call<List<Repo>> call = gitHubService.listRepos("octocat");


            call.enqueue(new Callback<List<Repo>>() {
                @Override
                public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                    //接收结果
                    List<Repo> list = response.body();

                    Log.d(TAG, "onResponse: " + list.size() + "    " + list.toString());
                    Log.d(TAG, "onResponse:当前线程 "+Thread.currentThread().getName());
                                     /**
                                     * 回调是在主线程可以更新UI
                                     */
                                    mTv.setText(list.get(0).full_name);
                                    mPb.setProgress(50);
                }

                @Override
                public void onFailure(Call<List<Repo>> call, Throwable t) {

                    Log.d(TAG, "onFailure: " + t.getMessage());
                    Log.d(TAG, "onFailure:当前线程 "+Thread.currentThread().getName());
                }
            });


        }

>日志

    onResponse: 7    [Repo{id=18221276, name='git-...太长省略
    onResponse:当前线程 main

不容易，终于成功了.
突然觉得请求接口就好像访问自家的方法
也看到了回调是在主线程中。可以做UI操作



### 接都走官方的API
> BASE_URL

    https://api.github.com/

> API

    http://square.github.io/retrofit/


    public interface GitHubService {


        @GET("users/{user}/repos")
        Call<List<Repo>> listRepos(@Path("user") String user);


        @GET("users/list")
        Call<User> getUser();
    }


> 调用

    private void getUser() {
            GitHubService gitHubService = RetrofitWrapper.getInstance().create(GitHubService.class);

            Call<User> userCall = gitHubService.getUser();

            userCall.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    User user = response.body();

                    Log.d(TAG, "getUser onResponse: "+user.toString());
                    Log.d(TAG, " getUser onResponse: "+response.code()+"    "+response.isSuccessful()+"    "+response.message());
                    mTv.setText(user.toString());
                    mPb.setProgress(100);
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {

                    Log.d(TAG, "onFailure: "+t.getMessage());
                }
            });
        }

> 日志

     getUser onResponse: User{login='list', id=1133421, avatar_url='https://avatars.githubusercontent.com/u/1133421?v=3',...省略
      getUser onResponse: 200    true    OK


### 访问根据路径

    @GET("/")
    Call<GithubBean> getGitHubApi();

一定要有 （"/"） 不然会报错

private void getGithubApi() {

        GitHubService gitHubService = RetrofitWrapper.getInstance().create(GitHubService.class);
        Call<GithubBean> apiBeanCall = gitHubService.getGitHubApi();

        apiBeanCall.enqueue(new Callback<GithubBean>() {
            @Override
            public void onResponse(Call<GithubBean> call, Response<GithubBean> response) {

                Log.d(TAG, "getGithubApi onResponse: "+response.message());
                GithubBean githubBean = response.body();

                Log.d(TAG, "onResponse: "+githubBean.toString());
                mTv.setText(githubBean.toString());
                mPb.setProgress(78);
            }

            @Override
            public void onFailure(Call<GithubBean> call, Throwable t) {
                Log.d(TAG, "getGithubApi onFailure: "+t.getMessage());
            }
        });

    }

### 带参数的get请求

##### Query
    public interface MyServcie {



    @GET(AppUrl.GET_USE_HELP)
    Call<UseHelpBean> getUseHelp(@Query("sign")String sign,@Query("appKey") String appKey,@Query("osName")String osName);

    }



>日志

    getUseHelp onResponse: OK
    onResponse: UseHelpBean{info=InfoEntity{questList=[QuestListEntity{typeName='生活宝箱', reply='可以，选择你想加为好友的用户，点击“加好友”便可。', typeId=1002}, QuestListEntity{typeName='账户', reply='可以，点击用户...



#### QueryMap




    @GET(AppUrl.GET_USE_HELP)
    Call<UseHelpBean> getUseHelp(@Query("sign")String sign,@Query("appKey") String appKey,@Query("osName")int osName);


    @GET(AppUrl.GET_USE_HELP)
    Call<UseHelpBean> getUseHelps(@QueryMap Map<String,String> params);



结果与上面一样

再看一个天气的

    https://www.juhe.cn/docs/api/id/235
    开放的API可以自己申请
BASE_URL

    http://v.juhe.cn/weather/
    key:88ca9906a9ac5408ecd46b42c8e5324f

> Service

    public interface WeatherService {


        @GET("index")
        Call<WeatherData> getWeather(@Query("cityname") String cityname,@Query("key") String key,@Query("dtype") String dtype,@Query("format") int format);


        @GET("index")
        Call<WeatherData> getWeathers(@QueryMap Map<String,String> params);
    }



### POST请求 --POST 提交表单Field & FieldMap



#### 表单-参数Field

    @FormUrlEncoded
    @POST("index")
    Call<CheckBean> getInfo(@Field("info")String info,@Field("key")String key);


#### 表单 -多参数用FieldMap

    @FormUrlEncoded
    @POST("index")
    Call<CheckBean> getInfos(@FieldMap Map<String,String> params);




源码：







