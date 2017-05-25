package com.example.nattapong.heartdisease.dao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Nattapong on 9/1/2560.
 */

public class UserDataLoginCollectionDao {
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("user")
    @Expose
    private List<UserDataLoginDao> user = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<UserDataLoginDao> getUser() {
        return user;
    }

    public void setUser(List<UserDataLoginDao> user) {
        this.user = user;
    }
}
