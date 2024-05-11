package com.example.friend_list.homework1;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class MyPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> fragmentList;

    //构造方法，方便之后赋值调用
    
    public MyPagerAdapter(FragmentManager fm, List<Fragment> fragmentList){
        super(fm);
        this.fragmentList = fragmentList;
    }

    //根据Item的位置返回对应位置的Fragment，绑定item和Fragment
    
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    //设置item的数量
    
    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
