package com.example.nattapong.heartdisease.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.nattapong.heartdisease.R;
import com.example.nattapong.heartdisease.manager.UserDataLoginManager;

public class CommentActivity extends AppCompatActivity {
    private UserDataLoginManager manager;
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        manager = new UserDataLoginManager();
        name = (TextView) findViewById(R.id.name);
        name.setText(manager.getUser().getUser().get(0).getUserName());

    }
}
