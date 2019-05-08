package com.lishuo.shoppingmall.app;

import android.app.Application;

import com.zhy.http.okhttp.OkHttpUtils;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;


public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initOkHttpUtils();
    }

    private void initOkHttpUtils() {
        //OkHttpClient：设置网络请求参数

        OkHttpClient okHttpClient  = new OkHttpClient.Builder()
                .connectTimeout(1000, TimeUnit.MILLISECONDS)
                .readTimeout(1000,TimeUnit.MILLISECONDS)
                .build();
        //OkHttpClient：根据网络参数发起请求，get() post()
        OkHttpUtils.initClient(okHttpClient);
    }

}
