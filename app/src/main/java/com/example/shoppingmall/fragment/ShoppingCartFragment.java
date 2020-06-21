package com.example.shoppingmall.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.shoppingmall.R;
import com.example.shoppingmall.adapter.ShoppingCartAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 购物车
 */
public class ShoppingCartFragment extends BaseFragment {
    private ImageView iv_choose;
    private TextView tv_price;
    private RecyclerView recyclerView;
    private ShoppingCartAdapter adapter;
    private ArrayList<HashMap<String, String>> list_data = new ArrayList<>();
    private HashMap<String, String> hashMap;
    private boolean aBoolean = false;
    private int price = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_shopping_cart, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action.refreshFriend");
        getActivity().registerReceiver(mRefreshBroadcastReceiver, intentFilter);
        initView(getView());
        initData();
        initListener();
    }

    private void initView(View view) {
        iv_choose = view.findViewById(R.id.iv_choose);
        tv_price = view.findViewById(R.id.tv_price);
        recyclerView = view.findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ShoppingCartAdapter(R.layout.item_shopping_cart);
        recyclerView.setAdapter(adapter);
    }

    private void initData() {
    }

    private void initListener() {
        getView().findViewById(R.id.tv_settlement).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("消息提示");// 设置标题
                // builder.setIcon(R.drawable.ic_launcher);//设置图标
                builder.setMessage("请支付费用：" + price);// 为对话框设置内容
                // 为对话框设置取消按钮
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                });
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                });
                builder.create().show();// 使用show()方法显示对话框
            }
        });

        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                HashMap<String, String> hashMap = (HashMap<String, String>) adapter.getItem(position);
                switch (view.getId()) {
                    case R.id.layout_item:
                        if (hashMap.get("choose").equals("0")) {
                            list_data.get(position).put("choose", "1");
                            price += Integer.parseInt(hashMap.get("price"));
                        } else {
                            list_data.get(position).put("choose", "0");
                            price -= Integer.parseInt(hashMap.get("price"));
                        }
                        tv_price.setText("￥" + price);
                        adapter.notifyDataSetChanged();
                        break;
                }
            }
        });

        getView().findViewById(R.id.iv_choose).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (aBoolean) {
                    iv_choose.setImageResource(R.mipmap.pay_btn_choose_nor);
                    setAll(0);
                    aBoolean = false;
                    price = 0;
                    tv_price.setText("￥" + price);
                } else {
                    iv_choose.setImageResource(R.mipmap.pay_btn_choose_sel);
                    setAll(1);
                    aBoolean = true;
                }
            }
        });
    }

    public void setAll(int num) {
        if (num == 1) {//全选
            for (int i = 0; i < list_data.size(); i++) {
                list_data.get(i).put("choose", "1");
                price += Integer.parseInt(list_data.get(i).get("price"));
            }
            tv_price.setText("￥" + price);
        } else {
            for (int i = 0; i < list_data.size(); i++) {
                list_data.get(i).put("choose", "0");
            }
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void initImmersionBar() {
        statusBarConfig().titleBar(R.id.view).init();
    }

    private BroadcastReceiver mRefreshBroadcastReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("action.refreshFriend")) {
                hashMap = new HashMap<>();
                hashMap.put("content", intent.getExtras().getString("content"));
                hashMap.put("price", intent.getExtras().getString("price"));
                hashMap.put("choose", "0");
                list_data.add(hashMap);
                adapter.setNewData(list_data);
                adapter.notifyDataSetChanged();
            }
        }
    };
}