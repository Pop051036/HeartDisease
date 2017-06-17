package com.example.nattapong.heartdisease.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.nattapong.heartdisease.R;
import com.example.nattapong.heartdisease.activity.ArrhythmiasActivity;
import com.example.nattapong.heartdisease.activity.AtherosclerosisActivity;
import com.example.nattapong.heartdisease.activity.CongenitalActivity;
import com.example.nattapong.heartdisease.activity.FormActivity;
import com.example.nattapong.heartdisease.activity.MuscleActivity;
import com.example.nattapong.heartdisease.activity.PericardiumActivity;
import com.example.nattapong.heartdisease.activity.SampleActivity;
import com.example.nattapong.heartdisease.activity.ValveActivity;

/**
 * Created by nuuneoi on 11/16/2014.
 */
@SuppressWarnings("unused")
public class FragmentHomeHeart extends Fragment {

    private CardView atherosclerosis;
    private CardView muscle;
    private CardView valve;
    private CardView pericardium;
    private CardView congenital;
    private CardView arrhythmias;
    private CardView form;
    public FragmentHomeHeart() {
        super();
    }

    @SuppressWarnings("unused")
    public static FragmentHomeHeart newInstance() {
        FragmentHomeHeart fragment = new FragmentHomeHeart();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(savedInstanceState);

        if (savedInstanceState != null)
            onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home_heart, container, false);
        initInstances(rootView, savedInstanceState);
        return rootView;
    }

    private void init(Bundle savedInstanceState) {
        // Init Fragment level's variable(s) here
    }

    @SuppressWarnings("UnusedParameters")
    private void initInstances(View rootView, Bundle savedInstanceState) {
        // Init 'View' instance(s) with rootView.rootView.findViewById here
        atherosclerosis = (CardView) rootView.findViewById(R.id.atherosclerosis);
        atherosclerosis.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), AtherosclerosisActivity.class));
            }

        });
        muscle = (CardView) rootView.findViewById(R.id.muscle);
        muscle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), MuscleActivity.class));
            }
        });
        valve = (CardView) rootView.findViewById(R.id.valve);
        valve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ValveActivity.class));
            }
        });
        congenital = (CardView) rootView.findViewById(R.id.congenital);
        congenital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), CongenitalActivity.class));
            }
        });
        arrhythmias = (CardView) rootView.findViewById(R.id.arrhythmias);
        arrhythmias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ArrhythmiasActivity.class));
            }
        });
        form = (CardView) rootView.findViewById(R.id.form);
        form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), SampleActivity.class));
            }
        });


    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    /*
     * Save Instance State Here
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save Instance State here
    }

    /*
     * Restore Instance State Here
     */
    @SuppressWarnings("UnusedParameters")
    private void onRestoreInstanceState(Bundle savedInstanceState) {
        // Restore Instance State here
    }

}
