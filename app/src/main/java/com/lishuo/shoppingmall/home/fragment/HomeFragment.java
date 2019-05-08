package com.lishuo.shoppingmall.home.fragment;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.lishuo.shoppingmall.R;
import com.lishuo.shoppingmall.base.BaseFragment;
import com.lishuo.shoppingmall.home.Adapter.HomeFragmentAdapter;
import com.lishuo.shoppingmall.home.bean.ResultBeanData;
import com.lishuo.shoppingmall.utils.Constants;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

import static android.content.ContentValues.TAG;

public class HomeFragment extends BaseFragment {

    TextView tv_search_home;
    TextView tv_message_home;
    ImageButton ib_top;
    RecyclerView rv_home;

    @Override
    public View initView() {
        Log.e(TAG, "主页面初始化");
        //  view = new TextView(context);
        //  view.setTextSize(25);
        //  view.setGravity(Gravity.CENTER);
        View view = View.inflate(context, R.layout.fragment_home, null);
        tv_search_home = view.findViewById(R.id.tv_search_home);
        tv_message_home = view.findViewById(R.id.tv_message_home);
        rv_home = view.findViewById(R.id.rv_home);
        ib_top = view.findViewById(R.id.ib_top);
        initListener();
        return view;
    }

    private void initListener() {
        //置顶的监听
        ib_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //回到顶部
                rv_home.scrollToPosition(0);
            }
        });
        //搜素的监听
        tv_search_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "搜索",
                        Toast.LENGTH_SHORT).show();
            }
        });
        //消息的监听
        tv_message_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "进入消息中心",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void initData() {
        super.initData();
        //view.setText("主页");
        getDataFromNet();
    }

    //从网络请求获取数据
    public void getDataFromNet() {
        //发起Get请求：uri
        OkHttpUtils.get().url(Constants.HOME_URL).build().execute(new StringCallback() {
            @Override//网络请求错误回调
            public void onError(Call call, Exception e, int id) {
                Log.e(TAG, "onError:" + e.getMessage());
            }

            @Override//网络请求成功回调
            public void onResponse(String response, int id) {
                Log.e(TAG, "onError:" + response);
                parseData(response);
            }
        });
    }

    //解析json数据，Alibaba框架：fastjson
    private void parseData(String response) {
        ResultBeanData resultBeanData = JSON.parseObject(response, ResultBeanData.class);
        ResultBeanData.ResultBean result = resultBeanData.getResult();
        /*String name = result.getAct_info().get(0).getName();
        Log.e(TAG, "parseData:" + name);*/
        //创建适配器：传入适配器
        //适配器：定制组建视图
        if (result != null) {
            HomeFragmentAdapter homeFragmentAdapter = new HomeFragmentAdapter(context, result);
            rv_home.setAdapter(homeFragmentAdapter);
        }


    }
}
