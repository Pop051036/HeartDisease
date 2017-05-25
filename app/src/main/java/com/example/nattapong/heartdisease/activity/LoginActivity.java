package com.example.nattapong.heartdisease.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.example.nattapong.heartdisease.R;
import com.example.nattapong.heartdisease.dao.UserDataCollectionDao;
import com.example.nattapong.heartdisease.dao.UserDataLoginCollectionDao;
import com.example.nattapong.heartdisease.fragment.HomeFragment;
import com.example.nattapong.heartdisease.manager.HttpManager;
import com.example.nattapong.heartdisease.manager.UserDataLoginManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener

{

    Button bLogin;
    EditText etEmail, etPassword;
    TextView tvRegisterLink;
    UserLocalActivity userLocalActivity;
    private UserDataLoginCollectionDao dao;
    private UserDataLoginManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        manager = new UserDataLoginManager();
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bLogin = (Button) findViewById(R.id.bLogin);
        tvRegisterLink = (TextView) findViewById(R.id.tvRegisterLink);

        bLogin.setOnClickListener(this);
        tvRegisterLink.setOnClickListener(this);
        userLocalActivity = new UserLocalActivity(this);

    }


    @Override
    public void onClick(View v) {

        if (v == bLogin ){
            login();

        }
        if (v == tvRegisterLink){
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        }

    }

    private void login() {
        Call<UserDataLoginCollectionDao> call = HttpManager.getInstance()
                .getService()
                .loginUser(etEmail.getText().toString(),etPassword.getText().toString());
        call.enqueue(new Callback<UserDataLoginCollectionDao>() {
            @Override
            public void onResponse(Call<UserDataLoginCollectionDao> call, Response<UserDataLoginCollectionDao> response) {
                if (response.isSuccessful()){

                    dao = response.body();
                    if(dao.getSuccess()){

                    manager.setUser(dao);
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();}
                }else {
                    Log.e("error", response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<UserDataLoginCollectionDao> call, Throwable t) {
                Log.e("error", t.toString());
            }
        });

    }
}
