package com.example.shoppingmall.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.gyf.immersionbar.ImmersionBar;
import com.gyf.immersionbar.components.ImmersionFragment;

public abstract class BaseFragment extends ImmersionFragment {
    private ImmersionBar mImmersionBar;

    /**
     * 初始化沉浸式状态栏
     */
    protected ImmersionBar statusBarConfig() {
        // 在BaseFragment里初始化
        mImmersionBar = ImmersionBar.with(this)
                // 默认状态栏字体颜色为黑色
                .statusBarDarkFont(statusBarDarkFont())
                // 解决软键盘与底部输入框冲突问题，默认为false，还有一个重载方法，可以指定软键盘mode
                .keyboardEnable(false);
        return mImmersionBar;
    }

    /**
     * 获取状态栏字体颜色
     */
    public Boolean statusBarDarkFont() {
        // 返回真表示黑色字体
        return true;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
