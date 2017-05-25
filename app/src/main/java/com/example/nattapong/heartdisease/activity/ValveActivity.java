package com.example.nattapong.heartdisease.activity;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.nattapong.heartdisease.R;
import com.example.nattapong.heartdisease.fragment.ExersiseValveFragment;
import com.example.nattapong.heartdisease.fragment.FoodValveFragment;
import com.example.nattapong.heartdisease.fragment.HomeValveFragment;
import com.example.nattapong.heartdisease.fragment.PracticeValveFragment;
import com.example.nattapong.heartdisease.fragment.SymptomValveFragment;
import com.example.nattapong.heartdisease.fragment.TreatValveFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class ValveActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valve);

        initInstsnces();
    }

    private void initInstsnces() {
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        BottomBar bottomBar3 = (BottomBar) findViewById(R.id.bottomBar3);
        bottomBar3.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {

                if (tabId == R.id.tab_recents1){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contentContainerValve, HomeValveFragment.newInstance())
                            .setCustomAnimations(
                                    R.anim.from_right, R.anim.to_left,
                                    R.anim.from_left, R.anim.to_right
                            )
                            .addToBackStack(null)
                            .commit();

                }
                if (tabId == R.id.tab_recents){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contentContainerValve, SymptomValveFragment.newInstance())
                            .setCustomAnimations(
                                    R.anim.from_right, R.anim.to_left,
                                    R.anim.from_left, R.anim.to_right
                            )
                            .addToBackStack(null)
                            .commit();

                }
                if (tabId == R.id.tab_favorites){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contentContainerValve, PracticeValveFragment.newInstance())
                            .setCustomAnimations(
                                    R.anim.from_right, R.anim.to_left,
                                    R.anim.from_left, R.anim.to_right
                            )
                            .addToBackStack(null)
                            .commit();

                }
                if (tabId == R.id.tab_nearby){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contentContainerValve, TreatValveFragment.newInstance())
                            .setCustomAnimations(
                                    R.anim.from_right, R.anim.to_left,
                                    R.anim.from_left, R.anim.to_right
                            )
                            .addToBackStack(null)
                            .commit();

                }
                if (tabId == R.id.tab_friends){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contentContainerValve, FoodValveFragment.newInstance())
                            .setCustomAnimations(
                                    R.anim.from_right, R.anim.to_left,
                                    R.anim.from_left, R.anim.to_right
                            )
                            .addToBackStack(null)
                            .commit();

                }
                if (tabId == R.id.tab_food){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contentContainerValve, ExersiseValveFragment.newInstance())
                            .setCustomAnimations(
                                    R.anim.from_right, R.anim.to_left,
                                    R.anim.from_left, R.anim.to_right
                            )
                            .addToBackStack(null)
                            .commit();

                }


            }
        });
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
