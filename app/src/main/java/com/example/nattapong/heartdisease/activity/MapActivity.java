package com.example.nattapong.heartdisease.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.nattapong.heartdisease.R;
import com.example.nattapong.heartdisease.dao.MapHospitalDataDao;
import com.example.nattapong.heartdisease.fragment.FragmentMap;
import com.google.android.gms.maps.MapFragment;

public class MapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        Bundle bundle = getIntent().getExtras();
        MapHospitalDataDao dataDao = bundle.getParcelable("data");
        Log.e("jijij",dataDao.getDbMapLat()+"");
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, FragmentMap.newInstance(dataDao))
                    .commit();
        }
    }
}
