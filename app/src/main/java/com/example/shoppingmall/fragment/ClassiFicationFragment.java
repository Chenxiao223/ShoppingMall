package com.example.shoppingmall.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.shoppingmall.R;
import com.example.shoppingmall.adapter.LeftMenuAdapter;
import com.example.shoppingmall.adapter.RightMenuAdapter;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * 分类
 */
public class ClassiFicationFragment extends BaseFragment {
    private RecyclerView leftRecylerView;
    private RecyclerView rightRecylerView;
    private RightMenuAdapter rightMenuAdapter;
    private LeftMenuAdapter leftMenuAdapter;
    private ArrayList<HashMap<String, String>> leftData = new ArrayList<>();
    private ArrayList<HashMap<String, String>> rightData = new ArrayList<>();
    private HashMap<String, String> leftHash;
    private HashMap<String, String> rightHash;
    private TextView tv_right_menu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_classi_fication, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView(getView());
        initData();
        initListener();
    }

    private void initListener() {
        leftMenuAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                HashMap<String, String> hashMap = (HashMap<String, String>) adapter.getItem(position);
                switch (view.getId()) {
                    case R.id.text:
                        switch (hashMap.get("content")) {
                            case "零食":
                                tv_right_menu.setText("零食");
                                setSnacks();
                                break;
                            case "水果":
                                tv_right_menu.setText("水果");
                                setFruits();
                                break;
                            case "日常":
                                tv_right_menu.setText("日常");
                                setDaily();
                                break;
                            case "衣服":
                                tv_right_menu.setText("衣服");
                                setClothes();
                                break;
                        }
                        break;
                }
            }
        });

        rightMenuAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                HashMap<String, String> hashMap = (HashMap<String, String>) adapter.getItem(position);
                switch (view.getId()) {
                    case R.id.iv_car:
                        Intent intent = new Intent();
                        intent.setAction("action.refreshFriend");
                        intent.putExtra("content",hashMap.get("content"));
                        intent.putExtra("price",hashMap.get("price"));
                        getActivity().sendBroadcast(intent);
                        Toast.makeText(getContext(), "加入购物车成功", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    private void initView(View view) {
        leftRecylerView = view.findViewById(R.id.left_menu);
        rightRecylerView = view.findViewById(R.id.right_menu);
        tv_right_menu = view.findViewById(R.id.tv_right_menu);

        leftRecylerView.setLayoutManager(new LinearLayoutManager(getContext()));
        leftMenuAdapter = new LeftMenuAdapter(R.layout.item_leftmenu);
        leftRecylerView.setAdapter(leftMenuAdapter);

        rightRecylerView.setLayoutManager(new LinearLayoutManager(getContext()));
        rightMenuAdapter = new RightMenuAdapter(R.layout.item_rightmenu);
        rightRecylerView.setAdapter(rightMenuAdapter);
    }

    private void initData() {
        leftHash = new HashMap<>();
        leftHash.put("content", "零食");
        leftData.add(leftHash);
        leftHash = new HashMap<>();
        leftHash.put("content", "水果");
        leftData.add(leftHash);
        leftHash = new HashMap<>();
        leftHash.put("content", "日常");
        leftData.add(leftHash);
        leftHash = new HashMap<>();
        leftHash.put("content", "衣服");
        leftData.add(leftHash);
        leftMenuAdapter.setNewData(leftData);
        leftMenuAdapter.notifyDataSetChanged();
        tv_right_menu.setText("零食");
        setSnacks();
    }

    public void setSnacks() {
        rightData.clear();
        rightHash = new HashMap<>();
        rightHash.put("content", "手撕肉干");
        rightHash.put("price", "50");
        rightData.add(rightHash);
        rightHash = new HashMap<>();
        rightHash.put("content", "大碗宽面");
        rightHash.put("price", "40");
        rightData.add(rightHash);
        rightHash = new HashMap<>();
        rightHash.put("content", "华味亨");
        rightHash.put("price", "14");
        rightData.add(rightHash);
        rightHash = new HashMap<>();
        rightHash.put("content", "奶油面包");
        rightHash.put("price", "22");
        rightData.add(rightHash);
        rightHash = new HashMap<>();
        rightHash.put("content", "华味亨");
        rightHash.put("price", "14");
        rightData.add(rightHash);
        rightHash = new HashMap<>();
        rightHash.put("content", "三只松鼠");
        rightHash.put("price", "34");
        rightData.add(rightHash);
        rightHash = new HashMap<>();
        rightHash.put("content", "旺旺雪饼");
        rightHash.put("price", "32");
        rightData.add(rightHash);
        rightHash = new HashMap<>();
        rightHash.put("content", "特制鱼干");
        rightHash.put("price", "65");
        rightData.add(rightHash);
        rightHash = new HashMap<>();
        rightHash.put("content", "坚果盒子");
        rightHash.put("price", "34");
        rightData.add(rightHash);
        rightHash = new HashMap<>();
        rightHash.put("content", "肉松饼");
        rightHash.put("price", "78");
        rightData.add(rightHash);
        rightMenuAdapter.setNewData(rightData);
        rightMenuAdapter.notifyDataSetChanged();
    }

    public void setFruits() {
        rightData.clear();
        rightHash = new HashMap<>();
        rightHash.put("content", "苹果");
        rightHash.put("price", "24");
        rightData.add(rightHash);
        rightHash = new HashMap<>();
        rightHash.put("content", "橘子");
        rightHash.put("price", "12");
        rightData.add(rightHash);
        rightHash = new HashMap<>();
        rightHash.put("content", "西瓜");
        rightHash.put("price", "14");
        rightData.add(rightHash);
        rightHash = new HashMap<>();
        rightHash.put("content", "芒果");
        rightHash.put("price", "22");
        rightData.add(rightHash);
        rightHash = new HashMap<>();
        rightHash.put("content", "菠萝");
        rightHash.put("price", "19");
        rightData.add(rightHash);
        rightHash = new HashMap<>();
        rightHash.put("content", "香蕉");
        rightHash.put("price", "7");
        rightData.add(rightHash);
        rightHash = new HashMap<>();
        rightHash.put("content", "香梨");
        rightHash.put("price", "6");
        rightData.add(rightHash);
        rightHash = new HashMap<>();
        rightHash.put("content", "柚子");
        rightHash.put("price", "30");
        rightData.add(rightHash);
        rightHash = new HashMap<>();
        rightHash.put("content", "柿子");
        rightHash.put("price", "4");
        rightData.add(rightHash);
        rightMenuAdapter.setNewData(rightData);
        rightMenuAdapter.notifyDataSetChanged();
    }

    public void setDaily() {
        rightData.clear();
        rightHash = new HashMap<>();
        rightHash.put("content", "碗筷");
        rightHash.put("price", "37");
        rightData.add(rightHash);
        rightHash = new HashMap<>();
        rightHash.put("content", "洗衣液");
        rightHash.put("price", "24");
        rightData.add(rightHash);
        rightHash = new HashMap<>();
        rightHash.put("content", "垃圾袋");
        rightHash.put("price", "14");
        rightData.add(rightHash);
        rightHash = new HashMap<>();
        rightHash.put("content", "拖把");
        rightHash.put("price", "22");
        rightData.add(rightHash);
        rightHash = new HashMap<>();
        rightHash.put("content", "扫把");
        rightHash.put("price", "14");
        rightData.add(rightHash);
        rightHash = new HashMap<>();
        rightHash.put("content", "纸巾");
        rightHash.put("price", "7");
        rightData.add(rightHash);
        rightHash = new HashMap<>();
        rightHash.put("content", "拖鞋");
        rightHash.put("price", "16");
        rightData.add(rightHash);
        rightHash = new HashMap<>();
        rightHash.put("content", "雨伞");
        rightHash.put("price", "24");
        rightData.add(rightHash);
        rightHash = new HashMap<>();
        rightHash.put("content", "脸盆");
        rightHash.put("price", "16");
        rightData.add(rightHash);
        rightMenuAdapter.setNewData(rightData);
        rightMenuAdapter.notifyDataSetChanged();
    }

    public void setClothes() {
        rightData.clear();
        rightHash = new HashMap<>();
        rightHash.put("content", "大衣");
        rightHash.put("price", "92");
        rightData.add(rightHash);
        rightHash = new HashMap<>();
        rightHash.put("content", "衬衫");
        rightHash.put("price", "70");
        rightData.add(rightHash);
        rightHash = new HashMap<>();
        rightHash.put("content", "棉衣");
        rightHash.put("price", "80");
        rightData.add(rightHash);
        rightHash = new HashMap<>();
        rightHash.put("content", "马甲");
        rightHash.put("price", "50");
        rightData.add(rightHash);
        rightHash = new HashMap<>();
        rightHash.put("content", "裙子");
        rightHash.put("price", "67");
        rightData.add(rightHash);
        rightHash = new HashMap<>();
        rightHash.put("content", "皮衣");
        rightHash.put("price", "78");
        rightData.add(rightHash);
        rightHash = new HashMap<>();
        rightHash.put("content", "短袖");
        rightHash.put("price", "36");
        rightData.add(rightHash);
        rightHash = new HashMap<>();
        rightHash.put("content", "短裤");
        rightHash.put("price", "24");
        rightData.add(rightHash);
        rightHash = new HashMap<>();
        rightHash.put("content", "长裤");
        rightHash.put("price", "34");
        rightData.add(rightHash);
        rightMenuAdapter.setNewData(rightData);
        rightMenuAdapter.notifyDataSetChanged();
    }

    @Override
    public void initImmersionBar() {
        statusBarConfig().titleBar(R.id.view).init();
    }
}