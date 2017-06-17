package com.example.nattapong.heartdisease.activity;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.nattapong.heartdisease.R;
import com.example.nattapong.heartdisease.fragment.ExerciseMuscleFragment;
import com.example.nattapong.heartdisease.fragment.FoodMuscleFragment;
import com.example.nattapong.heartdisease.fragment.HomeMuscleFragment;
import com.example.nattapong.heartdisease.fragment.PracticeMuscleFragment;
import com.example.nattapong.heartdisease.fragment.SymptomMuscleFragment;
import com.example.nattapong.heartdisease.fragment.TreatMuscleFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MuscleActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muscle);

        initInstsnces();

    }

    private void initInstsnces() {
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("โรคกล้ามเนื้อหัวใจ");
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        BottomBar bottomBar1 = (BottomBar) findViewById(R.id.bottomBar1);
        bottomBar1.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {

                if (tabId == R.id.tab_recents1){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contentContainerMuscle, HomeMuscleFragment.newInstance())
                            .setCustomAnimations(
                                    R.anim.from_right, R.anim.to_left,
                                    R.anim.from_left, R.anim.to_right
                            )
                            .addToBackStack(null)
                            .commit();

                }
                if (tabId == R.id.tab_recents){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contentContainerMuscle, SymptomMuscleFragment.newInstance())
                            .setCustomAnimations(
                                    R.anim.from_right, R.anim.to_left,
                                    R.anim.from_left, R.anim.to_right
                            )
                            .addToBackStack(null)
                            .commit();

                }
                if (tabId == R.id.tab_favorites){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contentContainerMuscle, PracticeMuscleFragment.newInstance())
                            .setCustomAnimations(
                                    R.anim.from_right, R.anim.to_left,
                                    R.anim.from_left, R.anim.to_right
                            )
                            .addToBackStack(null)
                            .commit();

                }
                if (tabId == R.id.tab_nearby){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contentContainerMuscle, TreatMuscleFragment.newInstance())
                            .setCustomAnimations(
                                    R.anim.from_right, R.anim.to_left,
                                    R.anim.from_left, R.anim.to_right
                            )
                            .addToBackStack(null)
                            .commit();

                }
                //if (tabId == R.id.tab_friends){
                //    getSupportFragmentManager().beginTransaction()
                //            .replace(R.id.contentContainerMuscle, FoodMuscleFragment.newInstance())
                //            .setCustomAnimations(
                //                    R.anim.from_right, R.anim.to_left,
                //                    R.anim.from_left, R.anim.to_right
                //            )
                //            .addToBackStack(null)
                //            .commit();

                //}
                //if (tabId == R.id.tab_food){
                //    getSupportFragmentManager().beginTransaction()
                //            .replace(R.id.contentContainerMuscle, ExerciseMuscleFragment.newInstance())
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
