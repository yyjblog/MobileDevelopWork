package com.example.friend_list.homework1;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.airbnb.lottie.LottieAnimationView;
import com.example.friend_list.R;

import java.util.ArrayList;
import java.util.List;

public class FriendListFragment extends Fragment implements AdapterView.OnItemClickListener {

    private LottieAnimationView loadingAnimationView;
    private ListView listView;
    private List<String> friends;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friend_list, container, false);

        loadingAnimationView = view.findViewById(R.id.loadingAnimationView);
        listView = view.findViewById(R.id.listView);

        // 加载并播放 Lottie 动画
        loadingAnimationView.setAnimation("loading_animation1.json");
        loadingAnimationView.loop(true);
        loadingAnimationView.playAnimation();

        // 延迟 5 秒后显示列表
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 停止动画并隐藏
                loadingAnimationView.animate().alpha(0f).setDuration(500).start();

                // 假设您的数据是从其他地方获取并设置到适配器中
                List<String> dataList = getDataList();
                ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, dataList);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(FriendListFragment.this);

                // 淡入效果显示列表
                listView.setAlpha(0f);
                listView.setVisibility(View.VISIBLE);
                listView.animate().alpha(1f).setDuration(500).start();
            }
        }, 5000);



        return view;
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String string = (String) parent.getItemAtPosition(position);
        Toast.makeText(getActivity(), string, Toast.LENGTH_SHORT).show();
    }
    private List<String> getDataList() {
        List<String> dataList = new ArrayList<>();
        // 添加数据到列表中
        dataList.add("张三");
        dataList.add("李四");
        dataList.add("王五");
        dataList.add("Alice");
        dataList.add("Bob");
        dataList.add("Jack");
        return dataList;
    }
}
