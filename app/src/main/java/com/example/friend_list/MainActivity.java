package com.example.friend_list;// MainActivity.java

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.friend_list.homework1.FriendListFragment;
import com.example.friend_list.homework1.MyPagerAdapter;
import com.example.friend_list.homework1.Fragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = findViewById(R.id.leave_viewpager);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        String[] titles = new String[]{"好友列表", "我的好友"}; //设置标题

        List<androidx.fragment.app.Fragment> fragments = new ArrayList<>(); //
        fragments.add(new FriendListFragment());
        fragments.add(new Fragment());

        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);              //绑定adapter
        tabLayout.setupWithViewPager(viewPager);    //绑定viewPager

        for (int i = 0; i < titles.length; i++) {
            tabLayout.getTabAt(i).setText(titles[i]);   //设置标题
        }
    }

}
