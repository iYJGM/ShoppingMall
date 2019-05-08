package com.lishuo.shoppingmall.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.lishuo.shoppingmall.R;
import com.lishuo.shoppingmall.base.BaseFragment;
import com.lishuo.shoppingmall.community.fragment.CommunityFragment;
import com.lishuo.shoppingmall.home.fragment.HomeFragment;
import com.lishuo.shoppingmall.shoppingcars.fragment.CartFragment;
import com.lishuo.shoppingmall.type.fragment.TypeFragment;
import com.lishuo.shoppingmall.user.fragment.UserFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends FragmentActivity {


    ArrayList<BaseFragment> fragment_list;
    int position = 0; //标识：fragment对项下标的位置

    @BindView(R.id.frame_layout)
    FrameLayout frameLayout;
    @BindView(R.id.rg_main)
    RadioGroup rgMain;

    private Fragment tempFragment;
    private BaseFragment nextFragment;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //框架buttonknife，自动检索xml文件包含的id，自动绑定组件和视图，效率优先于findViewById

        initFragment();//初始化Fragment
        initListener();//初始化事件

    }

    private void initFragment() {
        fragment_list = new ArrayList<>();
        fragment_list.add(new HomeFragment()); // 添加主页碎片
        fragment_list.add(new TypeFragment()); // 添加主页碎片
        fragment_list.add(new CommunityFragment()); // 添加主页碎片
        fragment_list.add(new CartFragment()); // 添加主页碎片
        fragment_list.add(new UserFragment()); // 添加主页碎片

    }

    private void initListener() {
        //对选中容器的监听
        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            //当每次选中发生改变，就会调用该函数响应
            //checkId:选中button的id
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //通过判断选中的id，得到button
                // 通过判断点击button的id
                // 需要通过点击获取fragment_list的里面的fragment对象：需要对应下表位置 0-4

                switch (checkedId) {
                    case R.id.rb_home:
                        position = 0;
                        break;
                    case R.id.rb_type:
                        position = 1;
                        break;
                    case R.id.rb_community:
                        position = 2;
                        break;
                    case R.id.rb_cart:
                        position = 3;
                        break;
                    case R.id.rb_user:
                        position = 4;
                        break;
                }

                BaseFragment aseFragment = getFragment(position);
                //分析：切换操作进行优化
                //   1.判断前后的fragment是否一致
                //   2.显示：add() show()

                switchFrgment(tempFragment, aseFragment);
            }

        });
        rgMain.check(R.id.rb_home);
    }

    private BaseFragment getFragment(int position) {
        //判断是否为空
        if (fragment_list != null && fragment_list.size() != 0) {
            BaseFragment baseFragment = fragment_list.get(position);
            return baseFragment;
        }
        return null;
    }

    private void switchFrgment(Fragment fromFragment, BaseFragment nextFragment) {
        //判断前一个和下一个是否相同
        if (tempFragment != nextFragment) {
            tempFragment = nextFragment;
            if (nextFragment != null) {
                //打开管理的对象事务
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                //判断fragment是否添加
                if (!nextFragment.isAdded()) {
                    if (fromFragment != null) {//隐藏上一个fragment
                        fragmentTransaction.hide(fromFragment);
                    }
                    fragmentTransaction.add(R.id.frame_layout, nextFragment).commit();
                } else {
                    if (fromFragment != null) {
                        fragmentTransaction.hide(fromFragment);
                    }
                    // 直接显示
                    fragmentTransaction.show(nextFragment).commit();

                }
            }
        }
    }
}
