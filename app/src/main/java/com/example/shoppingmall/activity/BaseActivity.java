package com.example.shoppingmall.activity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.gyf.immersionbar.ImmersionBar;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void initImmersionBar(View view) {
        ImmersionBar.with(this)
                .statusBarView(view)
                .autoDarkModeEnable(true)
                .init();
    }

}
