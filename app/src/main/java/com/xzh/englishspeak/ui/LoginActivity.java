package com.xzh.englishspeak.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.xzh.englishspeak.R;
import com.xzh.englishspeak.base.BaseActivity;
import com.xzh.englishspeak.ui.main.MainActivity;
import com.xzh.englishspeak.utils.TintBarUtil;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        TintBarUtil.setColor(this, Color.RED);
    }

    @OnClick(R.id.btn_login)
    public void onClick() {
        startActivity(new Intent(this,MainActivity.class));
    }
}
