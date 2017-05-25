package com.example.nattapong.heartdisease.dao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Nattapong on 8/1/2560.
 */

public class UserDataCollectionDao {
    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("data")
    @Expose
    private List<UserDataDao> data = null;

    public UserDataCollectionDao() {
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public List<UserDataDao> getData() {
        return data;
    }

    public void setData(List<UserDataDao> data) {
        this.data = data;
    }
}
