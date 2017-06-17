package com.example.nattapong.heartdisease.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.nattapong.heartdisease.R;
import com.example.nattapong.heartdisease.fragment.FragmentFormSample;
import com.example.nattapong.heartdisease.fragment.HomeFragment;

public class SampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        if (savedInstanceState == null){

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, FragmentFormSample.newInstance())
                    .commit();
        }
    }
}
