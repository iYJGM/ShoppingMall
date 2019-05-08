package com.lishuo.shoppingmall.app;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lishuo.shoppingmall.R;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //活动类：Activity后台的服务
        //实现2s页面切换到主页面
        //Handler 信使：负责主线程和子线程之间的信息传递，可以派发子线程
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {//会在2s之后执行
                //跳转视图页面：意图（1.从哪里2.跳哪里）
                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                //闭关当前活动
                finish();

            }
        }, 2000);
    }
}
