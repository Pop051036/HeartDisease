package com.example.nattapong.heartdisease.fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.directions.route.AbstractRouting;
import com.directions.route.Route;
import com.directions.route.RouteException;
import com.directions.route.Routing;
import com.directions.route.RoutingListener;
import com.example.nattapong.heartdisease.R;
import com.example.nattapong.heartdisease.dao.MapHospitalDataCollection;
import com.example.nattapong.heartdisease.dao.MapHospitalDataDao;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;
import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;


/**
 * Created by nuuneoi on 11/16/2014.
 */
@SuppressWarnings("unused")
public class FragmentMap extends Fragment implements
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        OnMapReadyCallback ,LocationListener, RoutingListener {
    private static final int CODE_GET_CURRENT = 100;
    private GoogleMap mMap;
    private MapHospitalDataDao data;
    private TextView tvDistance;
    private TextView tvTime;

    private TextView addressHospital;
    private TextView descHospital;
    private GoogleApiClient googleApiClient;
    private double latitude;
    private double longitude;
    private LatLng latLng;

    private static final int[] COLORS = new int[]{R.color.colorPrimaryDark, R.color.colorPrimary, R.color.colorPrimary, R.color.colorPrimary, R.color.colorPrimary};

    private LatLng start;
    private LatLng waypoint;
    private LatLng end;

    private List<Polyline> polylines;

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
        Log.d(TAG, "onCreate: "+data.getDbMapLat());
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
        polylines = new ArrayList<>();
    }

    @SuppressWarnings("UnusedParameters")
    private void initInstances(View rootView, Bundle savedInstanceState) {
        // Init 'View' instance(s) with rootView.findViewById here
        tvTime = (TextView) rootView.findViewById(R.id.tvTime);
        tvDistance = (TextView) rootView.findViewById(R.id.tvDistance);
        descHospital = (TextView) rootView.findViewById(R.id.hospitalDescription);
        addressHospital = (TextView) rootView.findViewById(R.id.addressHospital);
        descHospital.setText(data.getDbMapDescription());
        addressHospital.setText(data.getDbMapAddress());
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        googleApiClient = new GoogleApiClient.Builder(getContext())
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();

    }

    private float calculateDistances() {
        float[] result = new float[3];
        Location.distanceBetween(start.latitude, start.longitude, end.latitude, end.longitude, result);
        Log.e("asdasd1",result[0]+"");
        Log.e("asdasd2",result[1]+"");
        Log.e("asdasd3",result[2]+"");
        return result[0] / 1000;
    }
    private void getRouting() {
        calculateDistances();
        Routing routing = new Routing.Builder()
                .travelMode(Routing.TravelMode.DRIVING)
                .withListener(this)
                .waypoints(start, end)
                .build();
        routing.execute();
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
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng latLng = new LatLng(data.getDbMapLat(),data.getDbMapLng());
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,10));
        mMap.addMarker(new MarkerOptions()
                .position(latLng)
                .title(data.getDbMapName()));
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setMapToolbarEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);



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
    public void onLocationChanged(Location location) {
        mMap.clear();
        latitude = location.getLatitude();
        longitude =  location.getLongitude();
        start = new LatLng(latitude,longitude);
        end = new LatLng(data.getDbMapLat(),data.getDbMapLng());

        getRouting();

    }


    private void animateCameraDirection() {
        LatLngBounds bounds = new LatLngBounds.Builder()
                .include(end)
                .include(start)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, 50));
        mMap.addMarker(new MarkerOptions()
                .position(end)
                .title(data.getDbMapName())
        );
        mMap.addMarker(new MarkerOptions()
                .position(start)
                .title("ตำแหน่งปัจจุบัน")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.po)));
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



    @Override
    public void onRoutingFailure(RouteException e) {

    }

    @Override
    public void onRoutingStart() {

    }

    @Override
    public void onRoutingSuccess(ArrayList<Route> route, int shortestRouteIndex) {

        mMap.clear();
//        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(start, 16));
        if (polylines.size() > 0) {
            for (Polyline poly : polylines) {
                poly.remove();
            }
        }

        polylines = new ArrayList<>();
        //add route(s) to the map.
        Log.e("lenght route",route.size()+"");
        for (int i = 0; i < route.size(); i++) {
            Log.e("duration "+i,route.get(i).getDurationText());
            Log.e("distances "+i,route.get(i).getDistanceText());

            tvDistance.setText(route.get(i).getDistanceText());
            tvTime.setText(route.get(i).getDurationText());
            //In case of more than 5 alternative routes
            int colorIndex = i % COLORS.length;

            PolylineOptions polyOptions = new PolylineOptions();
            polyOptions.color(ContextCompat.getColor(getContext(), COLORS[colorIndex]));
            polyOptions.width(10 + i * 3);
            polyOptions.addAll(route.get(i).getPoints());
            Polyline polyline = mMap.addPolyline(polyOptions);
            polylines.add(polyline);
        }
        animateCameraDirection();

    }

    @Override
    public void onRoutingCancelled() {

    }
}
