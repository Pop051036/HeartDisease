package com.example.nattapong.heartdisease.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.nattapong.heartdisease.R;
import com.example.nattapong.heartdisease.adapter.ViewPagerAdapter;
import com.example.nattapong.heartdisease.fragment.FragmentFoodAthen;
import com.example.nattapong.heartdisease.fragment.FragmentFoodAthey;
import com.example.nattapong.heartdisease.manager.UserDataLoginManager;


public class AtherFoodActivity extends AppCompatActivity  {

    Toolbar toolbar;
    TabLayout tabLayout1;
    ViewPager viewPager1;
    ViewPagerAdapter viewPagerAdapter1;



    UserDataLoginManager userDataLoginManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_ather);
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        tabLayout1 = (TabLayout) findViewById(R.id.tabLayout1);
        viewPager1 = (ViewPager) findViewById(R.id.viewPager1);
        viewPagerAdapter1 = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter1.addFragments(new FragmentFoodAthey(), "อาหารที่ควรรับประทาน");
        viewPagerAdapter1.addFragments(new FragmentFoodAthen(), "อาหารที่ไม่ควรรับประทาน");
        viewPager1.setAdapter(viewPagerAdapter1);
        tabLayout1.setupWithViewPager(viewPager1);

        userDataLoginManager = new UserDataLoginManager();



        initInstances();
    }

    private void initInstances() {
        //ใส่โค้ด

       // invalidateOptionsMenu();


    }






}
