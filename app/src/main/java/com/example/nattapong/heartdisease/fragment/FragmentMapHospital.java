package com.example.nattapong.heartdisease.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nattapong.heartdisease.R;
import com.example.nattapong.heartdisease.adapter.MapHospitalAdapter;
import com.example.nattapong.heartdisease.dao.MapHospitalDataCollection;
import com.example.nattapong.heartdisease.manager.HttpManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by nuuneoi on 11/16/2014.
 */
@SuppressWarnings("unused")
public class FragmentMapHospital extends Fragment {


    private MapHospitalAdapter mapHospitalAdapter;
    private RecyclerView recyclerView;


    public FragmentMapHospital() {
        super();
    }

    @SuppressWarnings("unused")
    public static FragmentMapHospital newInstance() {
        FragmentMapHospital fragment = new FragmentMapHospital();
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
        View rootView = inflater.inflate(R.layout.fragment_hospital_listview, container, false);
        initInstances(rootView, savedInstanceState);
        return rootView;
    }

    private void init(Bundle savedInstanceState) {
        // Init Fragment level's variable(s) here
        mapHospitalAdapter = new MapHospitalAdapter();
    }

    @SuppressWarnings("UnusedParameters")
    private void initInstances(View rootView, Bundle savedInstanceState) {
        // Init 'View' instance(s) with rootView.findViewById here
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mapHospitalAdapter);
        loadDataHospitalMap();
    }

    private void loadDataHospitalMap(){
        Call<MapHospitalDataCollection> call = HttpManager.getInstance()
                .getService()
                .loadMapHospital();
        call.enqueue(new Callback<MapHospitalDataCollection>() {
            @Override
            public void onResponse(Call<MapHospitalDataCollection> call, Response<MapHospitalDataCollection> response) {

                if (response.isSuccessful()) {
                    MapHospitalDataCollection dao = response.body();
                    if (dao.getData().size() > 0) {
                        Log.e("asdasd",""+dao.getData().get(0).getDbMapLat());
                        mapHospitalAdapter.setData(dao);
                        mapHospitalAdapter.notifyDataSetChanged();
                    }
                } else {
                    Log.e( " onResponse ELSE", response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<MapHospitalDataCollection> call, Throwable t) {

                Log.e(  " onFailure", t.toString());
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
