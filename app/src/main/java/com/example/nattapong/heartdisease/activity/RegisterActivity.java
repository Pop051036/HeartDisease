package com.example.nattapong.heartdisease.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nattapong.heartdisease.R;
import com.example.nattapong.heartdisease.dao.UserDataLoginCollectionDao;
import com.example.nattapong.heartdisease.manager.HttpManager;
import com.example.nattapong.heartdisease.manager.UserDataLoginManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private UserDataLoginManager manager;
    private UserDataLoginCollectionDao dao;
    Button bRegister;
    EditText etName, etEmail, etPassword, rePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        manager = new UserDataLoginManager();
        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        rePassword = (EditText) findViewById(R.id.rePassword);

        bRegister = (Button) findViewById(R.id.bRegister);

        bRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bRegister:


                register();

                break;
        }
    }

    private void register() {
        String name = etName.getText().toString();
        String Email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        String repassword = rePassword.getText().toString();
        if (password.equals(repassword)) {
            Call<UserDataLoginCollectionDao> call = HttpManager.getInstance()
                    .getService()
                    .registerUser(name, Email, password);
            Log.e("asdas",name+" "+Email+" "+password);
            call.enqueue(new Callback<UserDataLoginCollectionDao>() {
                @Override
                public void onResponse(Call<UserDataLoginCollectionDao> call, Response<UserDataLoginCollectionDao> response) {

                    if (response.isSuccessful()) {
                        dao = response.body();
                        manager.setUser(dao);
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        finish();
                    } else {
                        Log.e("Register", response.errorBody().toString());
                    }
                }

                @Override
                public void onFailure(Call<UserDataLoginCollectionDao> call, Throwable t) {
                    Log.e("Register", t.toString());
                }
            });
        } else {
            Toast.makeText(this, "รหัสผ่านไม่ตรงกัน", Toast.LENGTH_LONG).show();
        }

    }
}
