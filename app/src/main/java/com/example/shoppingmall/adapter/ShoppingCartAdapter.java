package com.example.shoppingmall.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.shoppingmall.R;

import java.util.HashMap;

public class ShoppingCartAdapter extends BaseQuickAdapter<HashMap<String, String>, BaseViewHolder> {
    public ShoppingCartAdapter(int Layout) {
        super(Layout);
    }

    @Override
    protected void convert(BaseViewHolder helper, HashMap<String, String> item) {
        helper.setText(R.id.tv_name, item.get("content")).setText(R.id.tv_price, "￥" + item.get("price"));
        if (item.get("choose").equals("0")) {
            helper.setImageResource(R.id.iv_choose, R.mipmap.pay_btn_choose_nor);
        } else {
            helper.setImageResource(R.id.iv_choose, R.mipmap.pay_btn_choose_sel);
        }
        helper.addOnClickListener(R.id.layout_item);
    }
}
