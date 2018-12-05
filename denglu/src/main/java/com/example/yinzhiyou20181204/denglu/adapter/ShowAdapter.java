package com.example.yinzhiyou20181204.denglu.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.yinzhiyou20181204.denglu.fragment.FragmentData;
import com.example.yinzhiyou20181204.denglu.fragment.FragmentName;

public class ShowAdapter extends FragmentPagerAdapter {
    private String[] menus=new String[]{"我的数据","我的名片"};
    private Context context;

    public ShowAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    public ShowAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0 :
                return new FragmentName();
            case 1:
                return new FragmentData();
        }
        return null;
    }

    @Override
    public int getCount() {
        return menus.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return menus[position];
    }
}
