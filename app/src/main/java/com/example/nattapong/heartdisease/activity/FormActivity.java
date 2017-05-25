package com.example.nattapong.heartdisease.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.nattapong.heartdisease.R;

public class FormActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioGroup g1;
    private RadioGroup g2;
    private RadioGroup g3;
    private RadioGroup g4;
    private RadioGroup g5;
    private RadioGroup g6;
    private RadioGroup g7;
    private RadioGroup g8;
    private RadioGroup g9;
    private RadioGroup g10;


    private Button btnform;
    private int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        g1 = (RadioGroup) findViewById(R.id.g1);
        g2 = (RadioGroup) findViewById(R.id.g2);
        g3 = (RadioGroup) findViewById(R.id.g3);
        g4 = (RadioGroup) findViewById(R.id.g4);
        g5 = (RadioGroup) findViewById(R.id.g5);
        g6 = (RadioGroup) findViewById(R.id.g6);
        g7 = (RadioGroup) findViewById(R.id.g7);
        g8 = (RadioGroup) findViewById(R.id.g8);
        g9 = (RadioGroup) findViewById(R.id.g9);
        g10 = (RadioGroup) findViewById(R.id.g10);

        btnform = (Button) findViewById(R.id.btnform);
        btnform.setOnClickListener(this);

        initInstances();
    }

    private void initInstances() {


    }

    public void onClick(View v) {

        if (v == btnform) {
            if (g1.getCheckedRadioButtonId() == R.id.y1) {
                num = num + 10;
                Log.e("FormActivity", num + " num");
            }
            if (g2.getCheckedRadioButtonId() == R.id.y2) {
                num = num + 10;
                Log.e("num", num + "");
            }
            if (g3.getCheckedRadioButtonId() == R.id.y3) {
                num = num + 10;
                Log.e("num", num + "");
            }
            if (g4.getCheckedRadioButtonId() == R.id.y4) {
                num = num + 10;
                Log.e("num", num + "");
            }
            if (g5.getCheckedRadioButtonId() == R.id.y5) {
                num = num + 10;
                Log.e("num", num + "");
            }
            if (g6.getCheckedRadioButtonId() == R.id.y6) {
                num = num + 10;
                Log.e("num", num + "");
            }
            if (g7.getCheckedRadioButtonId() == R.id.y7) {
                num = num + 10;
                Log.e("num", num + "");
            }
            if (g8.getCheckedRadioButtonId() == R.id.y8) {
                num = num + 10;
                Log.e("num", num + "");
            }
            if (g9.getCheckedRadioButtonId() == R.id.y9) {
                num = num + 10;
                Log.e("num", num + "");
            }
            if (g10.getCheckedRadioButtonId() == R.id.y10) {
                num = num + 10;
                Log.e("num", num + "");
            }


            Intent intent = new Intent(this, ShowformActivity.class);
            intent.putExtra("num", num);
            startActivity(intent);
            finish();
        }
        }
}
