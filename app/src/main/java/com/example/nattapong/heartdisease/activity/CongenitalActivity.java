package com.example.nattapong.heartdisease.activity;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.nattapong.heartdisease.R;
import com.example.nattapong.heartdisease.fragment.ExerciseCongenitalFragment;
import com.example.nattapong.heartdisease.fragment.FoodCongenitalFragment;
import com.example.nattapong.heartdisease.fragment.HomeCongenitalFragment;
import com.example.nattapong.heartdisease.fragment.PracticeCongenitalFragment;
import com.example.nattapong.heartdisease.fragment.SymptomCongenitalFragment;
import com.example.nattapong.heartdisease.fragment.TraetCongenitalFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class CongenitalActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congenital);

        initInstsnces();
    }

    private void initInstsnces() {
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("โรคหัวใจพิการแต่กำเนิด");
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        BottomBar bottomBar4 = (BottomBar) findViewById(R.id.bottomBar4);
        bottomBar4.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_favorites) {
                    // The tab with id R.id.tab_favorites was selected,
                    // change your content accordingly.
                }
                if (tabId == R.id.tab_recents1){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contentContainerCongen, HomeCongenitalFragment.newInstance())
                            .setCustomAnimations(
                                    R.anim.from_right, R.anim.to_left,
                                    R.anim.from_left, R.anim.to_right
                            )
                            .addToBackStack(null)
                            .commit();

                }
                if (tabId == R.id.tab_recents){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contentContainerCongen, SymptomCongenitalFragment.newInstance())
                            .setCustomAnimations(
                                    R.anim.from_right, R.anim.to_left,
                                    R.anim.from_left, R.anim.to_right
                            )
                            .addToBackStack(null)
                            .commit();

                }
                if (tabId == R.id.tab_favorites){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contentContainerCongen, PracticeCongenitalFragment.newInstance())
                            .setCustomAnimations(
                                    R.anim.from_right, R.anim.to_left,
                                    R.anim.from_left, R.anim.to_right
                            )
                            .addToBackStack(null)
                            .commit();

                }
                if (tabId == R.id.tab_nearby){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contentContainerCongen, TraetCongenitalFragment.newInstance())
                            .setCustomAnimations(
                                    R.anim.from_right, R.anim.to_left,
                                    R.anim.from_left, R.anim.to_right
                            )
                            .addToBackStack(null)
                            .commit();

                }
                //if (tabId == R.id.tab_friends){
                //    getSupportFragmentManager().beginTransaction()
                //            .replace(R.id.contentContainerCongen, FoodCongenitalFragment.newInstance())
                //            .setCustomAnimations(
                //                    R.anim.from_right, R.anim.to_left,
                //                    R.anim.from_left, R.anim.to_right
                //            )
                //            .addToBackStack(null)
                //            .commit();

                //}
                //if (tabId == R.id.tab_food){
                //    getSupportFragmentManager().beginTransaction()
                //            .replace(R.id.contentContainerCongen, ExerciseCongenitalFragment.newInstance())
                //            .setCustomAnimations(
                //                    R.anim.from_right, R.anim.to_left,
                //                    R.anim.from_left, R.anim.to_right
                //            )
                //            .addToBackStack(null)
                //            .commit();

                //}

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
