package com.example.shoppingmall.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.shoppingmall.R;

import java.util.HashMap;

public class LeftMenuAdapter extends BaseQuickAdapter<HashMap<String, String>, BaseViewHolder> {
    public LeftMenuAdapter(int LayoutResId) {
        super(LayoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, HashMap<String, String> item) {

        helper.setText(R.id.text, item.get("content"));
        helper.addOnClickListener(R.id.text);
    }
}
