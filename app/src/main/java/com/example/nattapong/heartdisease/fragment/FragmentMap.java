package com.example.nattapong.heartdisease.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nattapong.heartdisease.R;
import com.example.nattapong.heartdisease.dao.MapHospitalDataCollection;
import com.example.nattapong.heartdisease.dao.MapHospitalDataDao;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

import org.w3c.dom.Text;


/**
 * Created by nuuneoi on 11/16/2014.
 */
@SuppressWarnings("unused")
public class FragmentMap extends Fragment implements OnMapReadyCallback {
    private GoogleMap mMap;
    private MapHospitalDataDao data;
    private TextView addressHospital;
    private TextView descHospital;
    public FragmentMap() {
        super();
    }

    @SuppressWarnings("unused")
    public static FragmentMap newInstance(MapHospitalDataDao dataCollection) {
        FragmentMap fragment = new FragmentMap();
        Bundle args = new Bundle();
        args.putParcelable("data",dataCollection);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data = getArguments().getParcelable("data");
        init(savedInstanceState);

        if (savedInstanceState != null)
            onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_map, container, false);
        initInstances(rootView, savedInstanceState);
        return rootView;
    }

    private void init(Bundle savedInstanceState) {
        // Init Fragment level's variable(s) here
    }

    @SuppressWarnings("UnusedParameters")
    private void initInstances(View rootView, Bundle savedInstanceState) {
        // Init 'View' instance(s) with rootView.findViewById here
        descHospital = (TextView) rootView.findViewById(R.id.hospitalDescription);
        addressHospital = (TextView) rootView.findViewById(R.id.addressHospital);
        descHospital.setText(data.getDbMapDescription());
        addressHospital.setText(data.getDbMapAddress());
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng latLng = new LatLng(data.getDbMapLat(),data.getDbMapLng());
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,10));
    }
}
