package com.example.cr7.chatapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.cr7.adapter.ViewPagerAdaterDangNhap;

public class DangNhapActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dangnhap);

        tabLayout =  findViewById(R.id.tabDangNhap);
        viewPager =  findViewById(R.id.viewPagerDangNhap);
        //toolbar =  findViewById(R.id.toolBarDangNhap);

//        setSupportActionBar(toolbar);

        ViewPagerAdaterDangNhap viewPagerAdaterDangNhap = new ViewPagerAdaterDangNhap(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdaterDangNhap);
        viewPagerAdaterDangNhap.notifyDataSetChanged();

        tabLayout.setupWithViewPager(viewPager);
    }
}
