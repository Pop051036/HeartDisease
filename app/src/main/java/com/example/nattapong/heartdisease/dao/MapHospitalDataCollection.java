package com.example.nattapong.heartdisease.dao;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Nattapong on 23/5/2560.
 */

public class MapHospitalDataCollection implements Parcelable {
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private List<MapHospitalDataDao> data = null;

    public MapHospitalDataCollection(){

    }

    protected MapHospitalDataCollection(Parcel in) {
        data = in.createTypedArrayList(MapHospitalDataDao.CREATOR);
    }

    public static final Creator<MapHospitalDataCollection> CREATOR = new Creator<MapHospitalDataCollection>() {
        @Override
        public MapHospitalDataCollection createFromParcel(Parcel in) {
            return new MapHospitalDataCollection(in);
        }

        @Override
        public MapHospitalDataCollection[] newArray(int size) {
            return new MapHospitalDataCollection[size];
        }
    };

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<MapHospitalDataDao> getData() {
        return data;
    }

    public void setData(List<MapHospitalDataDao> data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(data);
    }
}
