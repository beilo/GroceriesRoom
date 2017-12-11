package com.minister.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by 被咯苏州 on 2017/12/11.
 */

public class Fragment1 extends SupportFragment {
    public static Fragment1 newInstance(){
        Fragment1 fragment = new Fragment1();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(_mActivity).inflate(R.layout.fragment_main, null);
        TextView textView = view.findViewById(R.id.tv_content);
        textView.setText("1");
        return view;
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        Log.d("onLazyInitView", "Fragment1: ");
    }
}
