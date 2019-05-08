package com.lishuo.shoppingmall.community.fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.lishuo.shoppingmall.base.BaseFragment;

import static android.content.ContentValues.TAG;

public class CommunityFragment extends BaseFragment {

    TextView view;

    @Override
    public View initView() {
        Log.e(TAG, "发现页面初始化");
        view = new TextView(context);
        view.setTextSize(25);
        view.setGravity(Gravity.CENTER);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        view.setText("发现");
    }


}
