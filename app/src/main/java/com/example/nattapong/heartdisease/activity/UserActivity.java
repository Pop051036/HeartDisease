package com.example.nattapong.heartdisease.activity;

/**
 * Created by Nattapong on 27/12/2559.
 */

public class UserActivity {
    String name, username, password,repassword;

    public UserActivity (String name,String username,String password,String repassword){

        this.name = name;
        this.username = username;
        this.password = password;
        this.repassword = repassword;
    }

    public UserActivity(String username,String password){
        this.username = username;
        this.password = password;
        this.repassword = password;
        this.name = "";
    }
}
