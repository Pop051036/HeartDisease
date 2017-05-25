package com.example.nattapong.heartdisease.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.nattapong.heartdisease.R;

public class ShowformActivity extends AppCompatActivity {

    TextView name;
    Bundle num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showform);
        name = (TextView) findViewById(R.id.name);
        num = getIntent().getExtras();
        int sum = num.getInt("num");
        name.setText(sum+"");

        initInstsnces();
    }

    private void initInstsnces() {

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
