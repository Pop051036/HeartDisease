package com.example.nattapong.heartdisease.dao;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Nattapong on 23/5/2560.
 */

public class MapHospitalDataDao  implements Parcelable{


        @SerializedName("db_map_id")
        @Expose
        private int dbMapId;
        @SerializedName("db_map_name")
        @Expose
        private String dbMapName;
        @SerializedName("db_map_address")
        @Expose
        private String dbMapAddress;
        @SerializedName("db_map_lat")
        @Expose
        private double dbMapLat;
        @SerializedName("db_map_lng")
        @Expose
        private double dbMapLng;
        @SerializedName("db_map_type")
        @Expose
        private String dbMapType;
        @SerializedName("db_map_description")
        @Expose
        private String dbMapDescription;

         @SerializedName("db_map_distance")
        @Expose
        private int dbMapDistance;

    protected MapHospitalDataDao(Parcel in) {
        dbMapId = in.readInt();
        dbMapName = in.readString();
        dbMapAddress = in.readString();
        dbMapLat = in.readDouble();
        dbMapLng = in.readDouble();
        dbMapType = in.readString();
        dbMapDescription = in.readString();
        dbMapDistance = in.readInt();
    }

    public static final Creator<MapHospitalDataDao> CREATOR = new Creator<MapHospitalDataDao>() {
        @Override
        public MapHospitalDataDao createFromParcel(Parcel in) {
            return new MapHospitalDataDao(in);
        }

        @Override
        public MapHospitalDataDao[] newArray(int size) {
            return new MapHospitalDataDao[size];
        }
    };

    public int getDbMapDistance() {
        return dbMapDistance;
    }

    public void setDbMapDistance(int dbMapDistance) {
        this.dbMapDistance = dbMapDistance;
    }

    public String getDbMapDescription() {
        return dbMapDescription;
    }

    public void setDbMapDescription(String dbMapDescription) {
        this.dbMapDescription = dbMapDescription;
    }

    public int getDbMapId() {
            return dbMapId;
        }

        public void setDbMapId(int dbMapId) {
            this.dbMapId = dbMapId;
        }

        public String getDbMapName() {
            return dbMapName;
        }

        public void setDbMapName(String dbMapName) {
            this.dbMapName = dbMapName;
        }

        public String getDbMapAddress() {
            return dbMapAddress;
        }

        public void setDbMapAddress(String dbMapAddress) {
            this.dbMapAddress = dbMapAddress;
        }

        public double getDbMapLat() {
            return dbMapLat;
        }

        public void setDbMapLat(double dbMapLat) {
            this.dbMapLat = dbMapLat;
        }

        public double getDbMapLng() {
            return dbMapLng;
        }

        public void setDbMapLng(double dbMapLng) {
            this.dbMapLng = dbMapLng;
        }

        public String getDbMapType() {
            return dbMapType;
        }

        public void setDbMapType(String dbMapType) {
            this.dbMapType = dbMapType;
        }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(dbMapId);
        dest.writeString(dbMapName);
        dest.writeString(dbMapAddress);
        dest.writeDouble(dbMapLat);
        dest.writeDouble(dbMapLng);
        dest.writeString(dbMapType);
        dest.writeString(dbMapDescription);
        dest.writeInt(dbMapDistance);
    }
}
