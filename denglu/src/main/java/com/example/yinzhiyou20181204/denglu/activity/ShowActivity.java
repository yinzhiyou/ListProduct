package com.example.yinzhiyou20181204.denglu.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yinzhiyou20181204.denglu.R;
import com.example.yinzhiyou20181204.denglu.adapter.ShowAdapter;

public class ShowActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        initView();
        initData();
    }

    private void initData() {
        viewPager.setAdapter(new ShowAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);


    }

    private void initView() {
        tabLayout = findViewById(R.id.tablaout);
        viewPager = findViewById(R.id.viewpager);
    }
}
