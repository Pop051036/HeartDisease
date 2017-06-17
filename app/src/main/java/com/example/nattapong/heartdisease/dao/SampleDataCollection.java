package com.example.nattapong.heartdisease.dao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Nattapong on 11/6/2560.
 */

public class SampleDataCollection {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private List<SampleDataDao> data = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<SampleDataDao> getData() {
        return data;
    }

    public void setData(List<SampleDataDao> data) {
        this.data = data;
    }
}
