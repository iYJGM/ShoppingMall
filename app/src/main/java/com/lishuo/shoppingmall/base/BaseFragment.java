package com.lishuo.shoppingmall.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 基础类BaseFragement
 */

public abstract class BaseFragment extends Fragment {

    protected Context context;
    //onCreate：获取上下文对象〉onCreateView：加载视图）onActivitycreated：加载数据
    @Override
    // onCreate:在被系统创建的时候调用
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
    }


    // onCreateView：在创建视图的时候调用
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //View view = View.inflate(context,R.layout.activity_main,null);
        // Inflate the layout for this fragment
        return initView();// 返回初始化函数
    }


    // onCreateView：在创建活动的时候调用额
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }
    //抽象函数
    public abstract View initView();// 初始化视图函数,用于初始化每一个fragment的不同的初始布局
    public void initData(){}// 初始化数据函数,用于初始化每一个fragment
}
