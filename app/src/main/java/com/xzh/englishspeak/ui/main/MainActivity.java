package com.xzh.englishspeak.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.xzh.englishspeak.R;
import com.xzh.englishspeak.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_normal, R.id.btn_move, R.id.btn_ripple, R.id.btn_clip})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_normal:
                startActivity(new Intent(MainActivity.this, NormalActivity.class));
                break;
            case R.id.btn_move:
                startActivity(new Intent(MainActivity.this, MoveActivity.class));
                break;
            case R.id.btn_ripple:
                startActivity(new Intent(MainActivity.this, QihooActivity.class));
                break;
            case R.id.btn_clip:
                startActivity(new Intent(MainActivity.this, ClipActivity.class));
                break;
        }
    }

}
