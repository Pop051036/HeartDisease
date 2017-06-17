package com.example.nattapong.heartdisease.activity;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.nattapong.heartdisease.R;
import com.example.nattapong.heartdisease.fragment.ExerciseFragment;
import com.example.nattapong.heartdisease.fragment.FragmentFoodAthey;
import com.example.nattapong.heartdisease.fragment.HomeFragment;
import com.example.nattapong.heartdisease.fragment.PracticeFeagment;
import com.example.nattapong.heartdisease.fragment.SympotomFragment;
import com.example.nattapong.heartdisease.fragment.TreatFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class AtherosclerosisActivity extends AppCompatActivity {


    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atherosclerosis);

        if (savedInstanceState == null){

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, HomeFragment.newInstance())
                    .commit();
        }
        initInstsnces();
    }

    private void initInstsnces() {

        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("โรคหลอดเลือดหัวใจ");
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {

                if (tabId == R.id.tab_recents1){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contentContainer, HomeFragment.newInstance())
                            .setCustomAnimations(
                                    R.anim.from_right, R.anim.to_left,
                                    R.anim.from_left, R.anim.to_right
                            )
                            .addToBackStack(null)
                            .commit();

                }
                if (tabId == R.id.tab_recents){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contentContainer, SympotomFragment.newInstance())
                            .setCustomAnimations(
                                    R.anim.from_right, R.anim.to_left,
                                    R.anim.from_left, R.anim.to_right
                            )
                            .addToBackStack(null)
                            .commit();

                }
                if (tabId == R.id.tab_favorites){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contentContainer, PracticeFeagment.newInstance())
                            .setCustomAnimations(
                                    R.anim.from_right, R.anim.to_left,
                                    R.anim.from_left, R.anim.to_right
                            )
                            .addToBackStack(null)
                            .commit();

                }
                if (tabId == R.id.tab_nearby){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contentContainer, TreatFragment.newInstance())
                            .setCustomAnimations(
                                    R.anim.from_right, R.anim.to_left,
                                    R.anim.from_left, R.anim.to_right
                            )
                            .addToBackStack(null)
                            .commit();

                }
                //if (tabId == R.id.tab_friends){
                //   getSupportFragmentManager().beginTransaction()
                //            .replace(R.id.contentContainer, FragmentFoodAthey.newInstance())
                //            .setCustomAnimations(
                //                    R.anim.from_right, R.anim.to_left,
                //                    R.anim.from_left, R.anim.to_right
                //            )
                //            .addToBackStack(null)
                //            .commit();

                //}
                //if (tabId == R.id.tab_food){
                //    getSupportFragmentManager().beginTransaction()
                //            .replace(R.id.contentContainer, ExerciseFragment.newInstance())
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
