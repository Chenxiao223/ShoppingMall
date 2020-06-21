package com.example.shoppingmall.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shoppingmall.R;

/**
 * 注册
 */
public class RegisterActivity extends BaseActivity {
    private SharedPreferences.Editor editors;
    private TextView tv_title;
    private EditText et_name;
    private EditText et_pwd;
    private EditText et_pwd2;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initView();
        initListener();
    }

    private void initView() {
        tv_title = findViewById(R.id.tv_title);
        et_name = findViewById(R.id.et_name);
        et_pwd = findViewById(R.id.et_pwd);
        et_pwd2 = findViewById(R.id.et_pwd2);
        view = findViewById(R.id.view);
        initImmersionBar(view);
        tv_title.setText("注册");
    }

    public String getName() {
        return et_name.getText().toString().trim();
    }

    public String getPwd() {
        return et_pwd.getText().toString().trim();
    }

    public String getPwd2() {
        return et_pwd2.getText().toString().trim();
    }

    private void initListener() {
        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        findViewById(R.id.btn_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(getName())) {
                    Toast.makeText(RegisterActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(getPwd())) {
                    Toast.makeText(RegisterActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(getPwd2())) {
                    Toast.makeText(RegisterActivity.this, "请确认密码", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (getPwd().equals(getPwd2())) {
                    saveData(getName(), getPwd());
                    Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(RegisterActivity.this, "密码要一致", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void saveData(String name, String pwd) {
        SharedPreferences sharedPreferences = this.getSharedPreferences("data", Context.MODE_PRIVATE);
        editors = sharedPreferences.edit();
        editors.putString("name", name);
        editors.putString("pwd", pwd);
        editors.commit();//提交
    }
}
