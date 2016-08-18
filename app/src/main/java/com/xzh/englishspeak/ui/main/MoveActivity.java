package com.xzh.englishspeak.ui.main;

import android.graphics.Color;
import android.os.Bundle;

import com.xzh.englishspeak.R;
import com.xzh.englishspeak.base.BaseActivity;
import com.xzh.englishspeak.base.TabFragment;
import com.xzh.englishspeak.view.tabhost.TabItem;
import com.xzh.englishspeak.view.tabhost.XFragmentTabHost;


public class MoveActivity extends BaseActivity {

    private XFragmentTabHost mTabHost;
    String[] mTabTitle = new String[] {"首页", "软件", "游戏", "管理"};
    int[] mImageResId = new int[] {R.drawable.sel_tab_home, R.drawable.sel_tab_app,
            R.drawable.sel_tab_game, R.drawable.sel_tab_mag};
    Class[] mFragClass = new Class[] {TabFragment.class, TabFragment.class,
            TabFragment.class, TabFragment.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move);
        _initTabHost();
    }

    private void _initTabHost() {
        mTabHost = (XFragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.relate_tab_content);
        mTabHost.setTabMode(XFragmentTabHost.TabMode.MoveToTop);
        mTabHost.setTextActiveColor(Color.BLUE);

        for (int i = 0; i < mFragClass.length; i++) {
            Bundle bundle = new Bundle();
            bundle.putString(TabFragment.FRAG_KEY, mTabTitle[i]);
            mTabHost.addTabItem(new TabItem(mTabTitle[i], mImageResId[i]), mFragClass[i], bundle);
        }
    }
}
