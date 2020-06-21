package com.example.shoppingmall.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.shoppingmall.R;

import java.util.HashMap;

public class RightMenuAdapter extends BaseQuickAdapter<HashMap<String, String>, BaseViewHolder> {
    public RightMenuAdapter(int LayoutResId) {
        super(LayoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, HashMap<String, String> item) {
        helper.setText(R.id.tv_name, item.get("content")).setText(R.id.tv_price, "￥" + item.get("price"));
        helper.addOnClickListener(R.id.layout_item).addOnClickListener(R.id.iv_car);
    }
}
