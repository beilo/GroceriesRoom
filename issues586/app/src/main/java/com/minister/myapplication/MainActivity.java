package com.minister.myapplication;

import android.os.Bundle;

import com.minister.myapplication.view.BottomBar;
import com.minister.myapplication.view.BottomBarTab;

import me.yokeyword.fragmentation.SupportActivity;
import me.yokeyword.fragmentation.SupportFragment;

public class MainActivity extends SupportActivity {

    SupportFragment[] mFragments = new SupportFragment[3];

    private BottomBar mBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragments[0] = Fragment1.newInstance();
        mFragments[1] = Fragment2.newInstance();
        mFragments[2] = Fragment3.newInstance();
        loadMultipleRootFragment(R.id.fl_container, 0, mFragments);



        mBottomBar = (BottomBar) findViewById(R.id.bottomBar);

        mBottomBar.addItem(new BottomBarTab(this, R.drawable.ic_home_white_24dp))
                .addItem(new BottomBarTab(this, R.drawable.ic_discover_white_24dp))
                .addItem(new BottomBarTab(this, R.drawable.ic_message_white_24dp));

        mBottomBar.setOnTabSelectedListener(new BottomBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, int prePosition) {
                showHideFragment(mFragments[position], mFragments[prePosition]);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }
}
