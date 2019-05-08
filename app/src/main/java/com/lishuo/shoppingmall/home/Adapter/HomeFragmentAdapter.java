package com.lishuo.shoppingmall.home.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lishuo.shoppingmall.R;
import com.lishuo.shoppingmall.home.bean.ResultBeanData;
import com.lishuo.shoppingmall.home.fragment.HomeFragment;


public class HomeFragmentAdapter extends RecyclerView.Adapter {

    private Context context;
    private ResultBeanData.ResultBean resultBean;
    LayoutInflater layoutInflater;

    //初始化数据：在实例化对象之前调用
    public HomeFragmentAdapter(Context context, ResultBeanData.ResultBean resultBean) {
        this.context = context;
        this.resultBean = resultBean;
        //提前创建初始化View布局的类
        layoutInflater = LayoutInflater.from(context);
        //View.inflate() 效率低
    }

    //定制6个视图类型
    public static final int BANNER = 0;    //横幅广告
    public static final int CHANNEL = 1;    //频道
    public static final int ACT = 2;    //活动
    public static final int SECKILL = 3;    // 秒杀
    public static final int RECOMEEND = 4;  // 横幅广告
    public static final int HOT = 5;  // 热卖

    //保存当前类型
    public static int currentType = BANNER;

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case BANNER:
                currentType = BANNER;
                break;
            case CHANNEL:
                currentType = CHANNEL;
                break;
            case ACT:
                currentType = ACT;
                break;
            case SECKILL:
                currentType = SECKILL;
                break;
            case RECOMEEND:
                currentType = RECOMEEND;
                break;
            case HOT:
                currentType = HOT;
                break;
        }
        return currentType;
    }


    // viewType：视图类型，0++
    // onCreateViewilolder=getView：获取定制的xml布局设置RecyclerView，可以获取布局
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        /*if (viewType == BANNER) {
            return new
                    BannerViewHolder(mLayoutInflater.inflate(R.layout.banner_viewpager, null), mContext, resultBean);
            return null;*/
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
