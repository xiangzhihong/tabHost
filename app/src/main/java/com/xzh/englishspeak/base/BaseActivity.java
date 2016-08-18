package com.xzh.englishspeak.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;

import com.xzh.englishspeak.base.utils.ActivityManager;
import com.xzh.englishspeak.base.utils.ViewHelper;
import com.xzh.englishspeak.view.LoadingDialog;

import java.util.List;

public class BaseActivity extends FragmentActivity {

    public LoadingDialog mLoadingDialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.pushActivity(this);
        mLoadingDialog = new LoadingDialog(this);
        mLoadingDialog.setCanceledOnTouchOutside(false);
    }

    @Override
    public void setContentView(int layoutResID) {
        setContentView(View.inflate(this, layoutResID, null));
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
    }


    @Override
    protected void onDestroy() {
        ActivityManager.popActivity(this);
        ViewHelper.clean(findViewById(android.R.id.content));
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    //解决activity嵌套fragment onActivityResult不执行的问题
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        FragmentManager fm = getSupportFragmentManager();
        int index = requestCode >> 16;
        if (index != 0) {
            index--;
            if (fm.getFragments() == null || index < 0 || index >= fm.getFragments().size()) {
                return;
            }
            Fragment frag = fm.getFragments().get(index);
            if (frag != null) {
                handleResult(frag, requestCode, resultCode, data);
            }
            return;
        }
    }

    private void handleResult(Fragment frag, int requestCode, int resultCode, Intent data) {
        frag.onActivityResult(requestCode & 0xffff, resultCode, data);
        List<Fragment> frags = frag.getChildFragmentManager().getFragments();
        if (frags == null) return;
        for (Fragment f : frags) {
            if (f != null)
                handleResult(f, requestCode, resultCode, data);
        }
    }

    protected void cancelLoadingDialog() {
        if (!isFinishing()) {
            mLoadingDialog.cancel();
        }
    }


}
