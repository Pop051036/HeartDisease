package com.example.nattapong.heartdisease.dao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Nattapong on 12/1/2560.
 */

public class CommentCollDataDao {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private List<CommentDataDao> data = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<CommentDataDao> getData() {
        return data;
    }

    public void setData(List<CommentDataDao> data) {
        this.data = data;
    }
}
