package com.example.nattapong.heartdisease.dao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Nattapong on 11/6/2560.
 */

public class SampleDataDao {

        @SerializedName("db_sample_id")
        @Expose
        private int dbSampleId;
        @SerializedName("db_sample_proposition")
        @Expose
        private String dbSampleProposition;
        @SerializedName("db_sample_check_one")
        @Expose
        private String dbSampleCheckOne;
        @SerializedName("db_sample_check_two")
        @Expose
        private String dbSampleCheckTwo;
        @SerializedName("db_sample_check_three")
        @Expose
        private String dbSampleCheckThree;
        @SerializedName("db_sample_check_four")
        @Expose
        private String dbSampleCheckFour;
        @SerializedName("db_sample_answer")
        @Expose
        private int dbSampleAnswer;

    public int getDbSampleId() {
        return dbSampleId;
    }

    public void setDbSampleId(int dbSampleId) {
        this.dbSampleId = dbSampleId;
    }

    public String getDbSampleProposition() {
        return dbSampleProposition;
    }

    public void setDbSampleProposition(String dbSampleProposition) {
        this.dbSampleProposition = dbSampleProposition;
    }

    public String getDbSampleCheckOne() {
        return dbSampleCheckOne;
    }

    public void setDbSampleCheckOne(String dbSampleCheckOne) {
        this.dbSampleCheckOne = dbSampleCheckOne;
    }

    public String getDbSampleCheckTwo() {
        return dbSampleCheckTwo;
    }

    public void setDbSampleCheckTwo(String dbSampleCheckTwo) {
        this.dbSampleCheckTwo = dbSampleCheckTwo;
    }

    public String getDbSampleCheckThree() {
        return dbSampleCheckThree;
    }

    public void setDbSampleCheckThree(String dbSampleCheckThree) {
        this.dbSampleCheckThree = dbSampleCheckThree;
    }

    public String getDbSampleCheckFour() {
        return dbSampleCheckFour;
    }

    public void setDbSampleCheckFour(String dbSampleCheckFour) {
        this.dbSampleCheckFour = dbSampleCheckFour;
    }

    public int getDbSampleAnswer() {
        return dbSampleAnswer;
    }

    public void setDbSampleAnswer(int dbSampleAnswer) {
        this.dbSampleAnswer = dbSampleAnswer;
    }
}
