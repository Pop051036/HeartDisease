package com.example.nattapong.heartdisease.manager;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.nattapong.heartdisease.dao.UserDataLoginCollectionDao;
import com.google.gson.Gson;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

/**
 * Created by Nattapong on 9/1/2560.
 */

public class UserDataLoginManager {
    private SharedPreferences pref;

    // Editor for Shared preferences
    private SharedPreferences.Editor editor;

    // Shared pref mode
    private int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "swiftmove_user";
    private Context mContext;
    private UserDataLoginCollectionDao user;

    public UserDataLoginManager() {
        mContext = Contextor.getInstance().getContext();
        pref = mContext.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
        loadCache();
    }

    public UserDataLoginCollectionDao getUser() {
        return user;
    }

    public void setUser(UserDataLoginCollectionDao user) {
        this.user = user;
        saveCache();
    }


    private void saveCache() {

        UserDataLoginCollectionDao cacheDao = new UserDataLoginCollectionDao();
        if (user != null && user.getUser() != null)
            cacheDao.setUser(user.getUser());
        String json = new Gson().toJson(cacheDao);
        editor.putString("user", json);
        editor.apply();
    }

    private void loadCache() {
        String json = pref.getString("user", null);
        if (json == null)
            return;
        user = new Gson().fromJson(json, UserDataLoginCollectionDao.class);
    }

    public void clear() {
        editor.clear();
        editor.commit();

    }
}
