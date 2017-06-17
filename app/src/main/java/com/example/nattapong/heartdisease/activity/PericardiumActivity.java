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
