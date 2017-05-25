package com.example.nattapong.heartdisease.activity;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.nattapong.heartdisease.R;
import com.example.nattapong.heartdisease.fragment.ExercisePericardiumFragment;
import com.example.nattapong.heartdisease.fragment.FoodPericardiumFragment;
import com.example.nattapong.heartdisease.fragment.HomePericardiumFragment;
import com.example.nattapong.heartdisease.fragment.PracticePericardiumFragment;
import com.example.nattapong.heartdisease.fragment.SymptomPericardiumFragment;
import com.example.nattapong.heartdisease.fragment.TreatPericardiumFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class PericardiumActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pericardium);

        initInstsnces();
    }

    private void initInstsnces() {
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        BottomBar bottomBar2 = (BottomBar) findViewById(R.id.bottomBar2);
        bottomBar2.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_recents1){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contentContainerPericar, HomePericardiumFragment.newInstance())
                            .setCustomAnimations(
                                    R.anim.from_right, R.anim.to_left,
                                    R.anim.from_left, R.anim.to_right
                            )
                            .addToBackStack(null)
                            .commit();

                }
                if (tabId == R.id.tab_recents){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contentContainerPericar, SymptomPericardiumFragment.newInstance())
                            .setCustomAnimations(
                                    R.anim.from_right, R.anim.to_left,
                                    R.anim.from_left, R.anim.to_right
                            )
                            .addToBackStack(null)
                            .commit();

                }
                if (tabId == R.id.tab_favorites){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contentContainerPericar, PracticePericardiumFragment.newInstance())
                            .setCustomAnimations(
                                    R.anim.from_right, R.anim.to_left,
                                    R.anim.from_left, R.anim.to_right
                            )
                            .addToBackStack(null)
                            .commit();

                }
                if (tabId == R.id.tab_nearby){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contentContainerPericar, TreatPericardiumFragment.newInstance())
                            .setCustomAnimations(
                                    R.anim.from_right, R.anim.to_left,
                                    R.anim.from_left, R.anim.to_right
                            )
                            .addToBackStack(null)
                            .commit();

                }
                if (tabId == R.id.tab_friends){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contentContainerPericar, FoodPericardiumFragment.newInstance())
                            .setCustomAnimations(
                                    R.anim.from_right, R.anim.to_left,
                                    R.anim.from_left, R.anim.to_right
                            )
                            .addToBackStack(null)
                            .commit();

                }
                if (tabId == R.id.tab_food){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contentContainerPericar, ExercisePericardiumFragment.newInstance())
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
