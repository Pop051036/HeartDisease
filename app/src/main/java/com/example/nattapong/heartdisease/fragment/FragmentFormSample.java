package com.example.nattapong.heartdisease.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nattapong.heartdisease.R;
import com.example.nattapong.heartdisease.adapter.SamplerAdapter;
import com.example.nattapong.heartdisease.dao.CommentCollDataDao;
import com.example.nattapong.heartdisease.dao.SampleDataCollection;
import com.example.nattapong.heartdisease.dao.SampleDataDao;
import com.example.nattapong.heartdisease.manager.HttpManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by nuuneoi on 11/16/2014.
 */
@SuppressWarnings("unused")
public class FragmentFormSample extends Fragment {

     private RecyclerView recyclerView;
    private SamplerAdapter samplerAdapter;

    public FragmentFormSample() {
        super();
    }

    @SuppressWarnings("unused")
    public static FragmentFormSample newInstance() {
        FragmentFormSample fragment = new FragmentFormSample();
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
        View rootView = inflater.inflate(R.layout.fragment_form_sample, container, false);
        initInstances(rootView, savedInstanceState);
        return rootView;
    }

    private void init(Bundle savedInstanceState) {
        // Init Fragment level's variable(s) here
        samplerAdapter = new SamplerAdapter(getContext());
    }

    @SuppressWarnings("UnusedParameters")
    private void initInstances(View rootView, Bundle savedInstanceState) {
        // Init 'View' instance(s) with rootView.findViewById here
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
       recyclerView.setAdapter(samplerAdapter);

        loadDataSample();

    }

    private void loadDataSample() {
        Call<SampleDataCollection> call = HttpManager.getInstance().getService()
                .loadSample();
        call.enqueue(new Callback<SampleDataCollection>() {
            @Override
            public void onResponse(Call<SampleDataCollection> call, Response<SampleDataCollection> response) {
                if(response.isSuccessful()){
                    samplerAdapter.setData(response.body());
                    samplerAdapter.notifyDataSetChanged();
                }else{
                    Log.e("error",response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<SampleDataCollection> call, Throwable t) {
                Log.e("error",t.toString());
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
