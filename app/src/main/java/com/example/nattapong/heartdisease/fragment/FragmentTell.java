package com.example.nattapong.heartdisease.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.nattapong.heartdisease.R;
import com.example.nattapong.heartdisease.activity.AtherFoodActivity;
import com.example.nattapong.heartdisease.activity.AtherosclerosisActivity;
import com.example.nattapong.heartdisease.activity.FormActivity;
import com.example.nattapong.heartdisease.activity.MuscleActivity;
import com.example.nattapong.heartdisease.activity.PericardiumActivity;
import com.example.nattapong.heartdisease.activity.ShowformActivity;


/**
 * Created by nuuneoi on 11/16/2014.
 */
@SuppressWarnings("unused")
public class FragmentTell extends Fragment {

    private CardView food;
    private CardView exercise;


    public FragmentTell() {
        super();
    }

    @SuppressWarnings("unused")
    public static FragmentTell newInstance() {
        FragmentTell fragment = new FragmentTell();
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
        View rootView = inflater.inflate(R.layout.fragment_tell, container, false);
        initInstances(rootView, savedInstanceState);
        return rootView;
    }

    private void init(Bundle savedInstanceState) {
        // Init Fragment level's variable(s) here
    }

    @SuppressWarnings("UnusedParameters")
    private void initInstances(View rootView, Bundle savedInstanceState) {
        // Init 'View' instance(s) with rootView.findViewById here
        food = (CardView) rootView.findViewById(R.id.food);
        food.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), AtherFoodActivity.class));
            }

        });
        exercise = (CardView) rootView.findViewById(R.id.exercise);
        exercise.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), PericardiumActivity.class));
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
