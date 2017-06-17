package com.example.nattapong.heartdisease.fragment;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nattapong.heartdisease.R;
import com.example.nattapong.heartdisease.adapter.MapHospitalAdapter;
import com.example.nattapong.heartdisease.dao.MapHospitalDataCollection;
import com.example.nattapong.heartdisease.manager.HttpManager;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.google.android.gms.internal.zzt.TAG;


/**
 * Created by nuuneoi on 11/16/2014.
 */
@SuppressWarnings("unused")
public class FragmentMapHospital extends Fragment implements
        GoogleApiClient.ConnectionCallbacks
        , GoogleApiClient.OnConnectionFailedListener,
        LocationListener {


    private static final int CODE_GET_CURRENT = 555;
    private MapHospitalAdapter mapHospitalAdapter;
    private RecyclerView recyclerView;
    private EditText tv_search;
    private GoogleApiClient googleApiClient;
    private double latitude;
    private double longitude;


    private ProgressDialog progressDialog;
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
        setHasOptionsMenu(true);
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
        progressDialog = new ProgressDialog(getContext());
    }

    @SuppressWarnings("UnusedParameters")
    private void initInstances(View rootView, Bundle savedInstanceState) {
        // Init 'View' instance(s) with rootView.findViewById here
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mapHospitalAdapter);

        progressDialog.setMessage("กำลังโหลดข้อมูล...");
        progressDialog.show();
        googleApiClient = new GoogleApiClient.Builder(getContext())
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();
        loadDataHospitalMap(0.0,0.0);
    }

    private void loadDataHospitalMap(double lat,double lng){
        Log.e("onLocationChanged",""+lat+ " " +lng);
        Call<MapHospitalDataCollection> call = HttpManager.getInstance()
                .getService()
                .getHospitalShort(String.valueOf(lat),String.valueOf(lng));
        call.enqueue(new Callback<MapHospitalDataCollection>() {
            @Override
            public void onResponse(Call<MapHospitalDataCollection> call, Response<MapHospitalDataCollection> response) {

                if (response.isSuccessful()) {

                    MapHospitalDataCollection dao = response.body();
                    if (dao.getData()!= null && dao.getData().size() > 0) {
                        mapHospitalAdapter.setDataHospital(dao);
                        mapHospitalAdapter.notifyDataSetChanged();
                        progressDialog.dismiss();
                    }else{
                        progressDialog.dismiss();
                        Log.e( " onResponse ELSE","asdadasd");
                    }
                } else {
                    progressDialog.dismiss();
                    Log.e( " onResponse ELSE", response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<MapHospitalDataCollection> call, Throwable t) {
                progressDialog.dismiss();
                Log.e(  " onFailure", t.toString());
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_search, menu);

        MenuItem search = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(search);
        search(searchView);
    }

    private void search(SearchView searchView) {

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                mapHospitalAdapter.getFilter().filter(newText);
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();
        googleApiClient.connect();
    }

    @Override
    public void onStop() {
        super.onStop();
        if (googleApiClient != null && googleApiClient.isConnected()) {
            googleApiClient.disconnect();
        }
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

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        getCurrentLocation();
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {
        latitude = location.getLatitude();
        longitude =  location.getLongitude();
        Log.d(TAG, "onLocationChanged: "+latitude+ " "+longitude);
        if (latitude != 0 && longitude != 0 ) {
            loadDataHospitalMap(latitude,longitude);
        }
    }

    public void getCurrentLocation() {
        if (ContextCompat.checkSelfPermission(getContext(),
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    CODE_GET_CURRENT);
            return;
        }

        LocationAvailability locationAvailability = LocationServices.FusedLocationApi.getLocationAvailability(googleApiClient);
        if (locationAvailability.isLocationAvailable()) {
            LocationRequest locationRequest = new LocationRequest()
                    .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
            LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, this);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {

            case CODE_GET_CURRENT:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getCurrentLocation();
                } else {
                    Toast.makeText(getContext(), "ACCESS_FINE_LOCATION Denied", Toast.LENGTH_SHORT).show();
                }
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
}
