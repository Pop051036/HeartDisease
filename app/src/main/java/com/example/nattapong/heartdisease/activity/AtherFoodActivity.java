package com.example.nattapong.heartdisease.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.nattapong.heartdisease.R;
import com.example.nattapong.heartdisease.adapter.ViewPagerAdapter;
import com.example.nattapong.heartdisease.fragment.FragmentFood;
import com.example.nattapong.heartdisease.fragment.FragmentFoodAthey;
import com.example.nattapong.heartdisease.manager.UserDataLoginManager;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;


public class AtherFoodActivity extends AppCompatActivity  {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_ather);

        initInstances();
    }

    private void initInstances() {
        //ใส่โค้ด
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

       // invalidateOptionsMenu();



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
