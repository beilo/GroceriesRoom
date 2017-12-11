package com.minister.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.minister.myapplication.view.BottomBar;
import com.minister.myapplication.view.BottomBarTab;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by 被咯苏州 on 2017/12/11.
 */

public class Fragment2 extends SupportFragment {
    public static Fragment2 newInstance(){
        Fragment2 fragment = new Fragment2();
        return fragment;
    }

    SupportFragment[] mFragments = new SupportFragment[3];

    private BottomBar mBottomBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(_mActivity).inflate(R.layout.activity_main, null);
        mBottomBar = (BottomBar) view.findViewById(R.id.bottomBar);

        mFragments[0] = FragmentA.newInstance();
        mFragments[1] = FragmentB.newInstance();
        mFragments[2] = FragmentC.newInstance();
        loadMultipleRootFragment(R.id.fl_container, 0, mFragments);

        mBottomBar.addItem(new BottomBarTab(_mActivity, R.drawable.ic_home_white_24dp))
                .addItem(new BottomBarTab(_mActivity, R.drawable.ic_discover_white_24dp))
                .addItem(new BottomBarTab(_mActivity, R.drawable.ic_message_white_24dp));

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
        return view;
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        Log.d("onLazyInitView", "Fragment2: ");
    }
}
