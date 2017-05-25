package com.example.nattapong.heartdisease.activity;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Nattapong on 27/12/2559.
 */

public class UserLocalActivity {

    public static final String SP_NAME="userDetails";
    SharedPreferences userLocalDatabase;

    public UserLocalActivity(Context context){
        userLocalDatabase = context.getSharedPreferences(SP_NAME, 0);
    }
    public void storeUserData(UserActivity user){

        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putString("name", user.name);
        spEditor.putString("username", user.username);
        spEditor.putString("password", user.password);
        spEditor.putString("repassword", user.repassword);
        spEditor.commit();
    }

    public UserActivity getLoggedInUser(){
        String name = userLocalDatabase.getString("name","");
        String username = userLocalDatabase.getString("username","");
        String password = userLocalDatabase.getString("password","");
        String repassword = userLocalDatabase.getString("repassword","");

        UserActivity storedUser = new UserActivity(name,username,password,repassword);
        return storedUser;
    }

    public void setUserLoggedIn(boolean loggedIn){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putBoolean("loggedIn", loggedIn);
        spEditor.commit();
    }
    public boolean getUserLoggedIn(){
        if (userLocalDatabase.getBoolean("LoggedIn", false) == true){
            return true;
        }else {
            return false;
        }
    }
    public void clearUserData(){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.clear();
        spEditor.commit();
    }
}
