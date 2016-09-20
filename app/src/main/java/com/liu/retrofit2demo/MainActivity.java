package com.liu.retrofit2demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.liu.retrofit2demo.bean.CheckBean;
import com.liu.retrofit2demo.bean.GithubBean;
import com.liu.retrofit2demo.bean.Repo;
import com.liu.retrofit2demo.bean.UseHelpBean;
import com.liu.retrofit2demo.bean.User;
import com.liu.retrofit2demo.bean.WeatherData;
import com.liu.retrofit2demo.conf.ConfigureInfo;
import com.liu.retrofit2demo.service.CheckService;
import com.liu.retrofit2demo.service.GitHubService;
import com.liu.retrofit2demo.service.MyServcie;
import com.liu.retrofit2demo.service.WeatherService;
import com.liu.retrofit2demo.wrapper.RetrofitWrapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "vivi";
    @Bind(R.id.btnUser)
    Button mBtnUser;
    @Bind(R.id.btnGetUser)
    Button mBtnGetUser;


    @Bind(R.id.tv)
    TextView    mTv;
    @Bind(R.id.pb)
    ProgressBar mPb;
    @Bind(R.id.btnGetGithubApi)
    Button      mBtnGetGithubApi;
    @Bind(R.id.btnGetUseHelp)
    Button      mBtnGetUseHelp;
    @Bind(R.id.btnGetUseHelps)
    Button      mBtnGetUseHelps;
    @Bind(R.id.btnGetWeather)
    Button      mBtnGetWeather;
    @Bind(R.id.btnGetWeathers)
    Button      mBtnGetWeathers;
    @Bind(R.id.btnGetCheckcode)
    Button      mBtnGetCheckcode;
    @Bind(R.id.btnGetCheckcodes)
    Button      mBtnGetCheckcodes;

    /**
     * /storage/emulated/0/MagazineUnlock/magazine-unlock-03-2.3.311-bigpicture_03_20.jpg
     * /storage/emulated/0/MagazineUnlock/magazine-unlock-04-2.3.356-bigpicture_04_40.jpg
     * /storage/emulated/0/MagazineUnlock/magazine-unlock-03-2.3.366-bigpicture_03_70.jpg
     * /storage/emulated/0/MagazineUnlock/magazine-unlock-04-2.3.330-bigpicture_04_50.jpg
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }


    @OnClick({R.id.btnUser, R.id.btnGetUser, R.id.btnGetGithubApi, R.id.btnGetUseHelp, R.id.btnGetUseHelps, R.id.btnGetWeather, R.id.btnGetWeathers,R.id.btnGetCheckcode,R.id.btnGetCheckcodes})
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btnUser:
                getUserRepo();
                break;
            case R.id.btnGetUser:
                getUser();
                break;
            case R.id.btnGetGithubApi:
                getGithubApi();
                break;
            case R.id.btnGetUseHelp:
                getUseHelp();
                break;
            case R.id.btnGetUseHelps:
                getUseHelps();
                break;
            case R.id.btnGetWeather:
                getWeakData();
                break;
            case R.id.btnGetWeathers:
                getWeakDatas();
                break;
            case R.id.btnGetCheckcode:
                getCheckCode();
                break;
            case R.id.btnGetCheckcodes:
                getCheckCodes();
                break;
        }
    }



    private void getCheckCode() {

        CheckService checkService = RetrofitWrapper.getInstance().create(CheckService.class);

        Call<CheckBean> call = checkService.getInfo( "去范德萨a" ,"242127af0184f6c5724a30048ed5030a");

        call.enqueue(new Callback<CheckBean>() {
            @Override
            public void onResponse(Call<CheckBean> call, Response<CheckBean> response) {
                CheckBean checkBean = response.body();
                Log.d(TAG, " getCheckCode  onResponse: "+checkBean.toString() +"   "+response.code()+"  "+response.message());
            }

            @Override
            public void onFailure(Call<CheckBean> call, Throwable t) {

                t.printStackTrace();
            }
        });

    }

    private void getCheckCodes() {
        CheckService checkService = RetrofitWrapper.getInstance().create(CheckService.class);

        Map<String, String> params = new HashMap<>();
        params.put("info","土木工程载厅暮云春树工塔顶地");
        params.put("key","242127af0184f6c5724a30048ed5030a");
        Call<CheckBean> call = checkService.getInfos(params);
        call.enqueue(new Callback<CheckBean>() {
            @Override
            public void onResponse(Call<CheckBean> call, Response<CheckBean> response) {
                CheckBean checkBean = response.body();
                Log.d(TAG, "getCheckCodes  onResponse: "+checkBean.toString() +"   "+response.code()+"  "+response.message());
            }

            @Override
            public void onFailure(Call<CheckBean> call, Throwable t) {

                t.printStackTrace();
            }
        });



    }

    private void getWeakData() {


        WeatherService weatherService = RetrofitWrapper.getInstance().create(WeatherService.class);

        Call<WeatherData> call = weatherService.getWeather("深圳", "88ca9906a9ac5408ecd46b42c8e5324f", "json", 2);
        call.enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                WeatherData weatherData = response.body();

                Log.d(TAG, "onResponse: " + response.code() + "    " + response.message() + "   " + response.isSuccessful());
                Log.d(TAG, "getWeakData onResponse: " + weatherData.toString());

                mTv.setText(weatherData.result.future.get(0).toString());
                mPb.setProgress(23);
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                Log.d(TAG, "getWeakData onFailure: " + t.getMessage());
                t.printStackTrace();
            }
        });
    }

    private void getWeakDatas() {

        WeatherService weatherService = RetrofitWrapper.getInstance().create(WeatherService.class);

        Map<String, String> params = new HashMap<>();
        params.put("cityname", "深圳");
        params.put("key", "88ca9906a9ac5408ecd46b42c8e5324f");
        params.put("dtype", "json");
        params.put("format", 2 + "");
        Call<WeatherData> call = weatherService.getWeathers(params);


        call.enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                WeatherData weatherData = response.body();

                Log.d(TAG, "onResponse: " + response.code() + "    " + response.message() + "   " + response.isSuccessful());
                Log.d(TAG, "getWeakDatas onResponse: " + weatherData.toString());

                mTv.setText(weatherData.result.today.toString());
                mPb.setProgress(11);
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                Log.d(TAG, "getWeakDatas onFailure: " + t.getMessage());
                t.printStackTrace();
            }
        });


    }

    private void getUseHelps() {

        MyServcie myServcie = RetrofitWrapper.getInstance().create(MyServcie.class);

        Map<String, String> params = new HashMap<>();
        params.put("sign", ConfigureInfo.SIGN);
        params.put("appKey", ConfigureInfo.APP_KEY);
        params.put("osName", ConfigureInfo.OS_NAME + "");

        Call<UseHelpBean> useHelpBeanCall = myServcie.getUseHelps(params);

        useHelpBeanCall.enqueue(new Callback<UseHelpBean>() {
            @Override
            public void onResponse(Call<UseHelpBean> call, Response<UseHelpBean> response) {
                Log.d(TAG, "getUseHelps onResponse: " + response.message());

                UseHelpBean useHelpBean = response.body();

                Log.d(TAG, "getUseHelps onResponse: " + useHelpBean.toString());
                mTv.setText(useHelpBean.toString());
                mPb.setProgress(44);
            }

            @Override
            public void onFailure(Call<UseHelpBean> call, Throwable t) {
                Log.d(TAG, "getUseHelps onFailure: " + t.getMessage());
                t.printStackTrace();
            }
        });


    }

    private void getUseHelp() {

        MyServcie myServcie = RetrofitWrapper.getInstance().create(MyServcie.class);

        Call<UseHelpBean> useHelpBeanCall = myServcie.getUseHelp(ConfigureInfo.SIGN, ConfigureInfo.APP_KEY, ConfigureInfo.OS_NAME);


        useHelpBeanCall.enqueue(new Callback<UseHelpBean>() {
            @Override
            public void onResponse(Call<UseHelpBean> call, Response<UseHelpBean> response) {

                Log.d(TAG, "getUseHelp onResponse: " + response.message());

                UseHelpBean useHelpBean = response.body();

                Log.d(TAG, "onResponse: " + useHelpBean.toString());
                mTv.setText(useHelpBean.toString());
                mPb.setProgress(33);
            }

            @Override
            public void onFailure(Call<UseHelpBean> call, Throwable t) {

                Log.d(TAG, "getUseHelp onFailure: " + t.getMessage());
                t.printStackTrace();
            }
        });

    }

    /**
     * @GET Call<GithubBean> getGitHubApi();
     */
    private void getGithubApi() {

        GitHubService    gitHubService = RetrofitWrapper.getInstance().create(GitHubService.class);
        Call<GithubBean> apiBeanCall   = gitHubService.getGitHubApi();

        apiBeanCall.enqueue(new Callback<GithubBean>() {
            @Override
            public void onResponse(Call<GithubBean> call, Response<GithubBean> response) {

                Log.d(TAG, "getGithubApi onResponse: " + response.message());
                GithubBean githubBean = response.body();

                Log.d(TAG, "onResponse: " + githubBean.toString());
                mTv.setText(githubBean.toString());
                mPb.setProgress(78);
            }

            @Override
            public void onFailure(Call<GithubBean> call, Throwable t) {
                Log.d(TAG, "getGithubApi onFailure: " + t.getMessage());
                t.printStackTrace();
            }
        });

    }

    /**
     * ("users/list")
     * 1133421
     */
    private void getUser() {
        GitHubService gitHubService = RetrofitWrapper.getInstance().create(GitHubService.class);

        Call<User> userCall = gitHubService.getUser();

        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();

                Log.d(TAG, "getUser onResponse: " + user.toString());
                Log.d(TAG, " getUser onResponse: " + response.code() + "    " + response.isSuccessful() + "    " + response.message());
                mTv.setText(user.toString());
                mPb.setProgress(100);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

    /**
     * UserRepo
     * ("users/{user}/repos")
     */
    private void getUserRepo() {

        GitHubService gitHubService = RetrofitWrapper.getInstance().create(GitHubService.class);

        Call<List<Repo>> call = gitHubService.listRepos("octocat");


        call.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                //接收结果
                List<Repo> list = response.body();

                Log.d(TAG, "getUserRepo onResponse: " + list.size() + "    " + list.toString());
                Log.d(TAG, "getUserRepo onResponse:当前线程 " + Thread.currentThread().getName());

                /**
                 * 回调是在主线程可以更新UI
                 */
                mTv.setText(list.get(0).toString());
                mPb.setProgress(50);

            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {

                Log.d(TAG, "onFailure: " + t.getMessage());
                Log.d(TAG, "onFailure:当前线程 " + Thread.currentThread().getName());
                t.printStackTrace();
            }
        });


    }


}
