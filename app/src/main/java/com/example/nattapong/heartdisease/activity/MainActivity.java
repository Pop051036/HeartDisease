package com.example.nattapong.heartdisease.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.example.nattapong.heartdisease.R;
import com.example.nattapong.heartdisease.adapter.ViewPagerAdapter;
import com.example.nattapong.heartdisease.fragment.ExerciseFragment;
import com.example.nattapong.heartdisease.fragment.FragmentComment;
import com.example.nattapong.heartdisease.fragment.FragmentFood;
import com.example.nattapong.heartdisease.fragment.FragmentHomeHeart;
import com.example.nattapong.heartdisease.fragment.FragmentMap;
import com.example.nattapong.heartdisease.fragment.FragmentMapHospital;
import com.example.nattapong.heartdisease.fragment.FragmentTell;
import com.example.nattapong.heartdisease.manager.UserDataLoginManager;


public class MainActivity extends AppCompatActivity  {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;



    UserDataLoginManager userDataLoginManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new FragmentHomeHeart(), "ประเภทโรคหัวใจ");
        viewPagerAdapter.addFragments(new FragmentTell(), "แนะนำ");
        viewPagerAdapter.addFragments(new FragmentComment(), "ปรึกษาแพทย์");
        viewPagerAdapter.addFragments(new FragmentMapHospital(), "ศูนย์โรคหัวใจ");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        userDataLoginManager = new UserDataLoginManager();



        initInstances();
    }

    private void initInstances() {
        //ใส่โค้ด

       // invalidateOptionsMenu();


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem itemLogin = menu.findItem(R.id.action_second_fragment);
        MenuItem itemLogout = menu.findItem(R.id.action_logout_fragment);
        if (userDataLoginManager.getUser() != null){
            itemLogout.setVisible(true);
            itemLogin.setVisible(false);

        }else {
            itemLogout.setVisible(false);
            itemLogin.setVisible(true);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_second_fragment) {
            Intent i=new Intent(MainActivity.this, LoginActivity.class);
            startActivity(i);
            return true;
        }if (item.getItemId() == R.id.action_logout_fragment){
            userDataLoginManager.clear();
            Intent i=new Intent(MainActivity.this, MainActivity.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
