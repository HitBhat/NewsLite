package com.example.woolwerin_test.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Request {
    @SerializedName("ayanamsa")
    @Expose
    private String ayanamsa;
    @SerializedName("bride_dob")
    @Expose
    private String bride_dob;
    @SerializedName("bridegroom_dob")
    @Expose
    private String bridegroom_dob;
    @SerializedName("bride_coordinates")
    @Expose
    private String bride_coordinates;
    @SerializedName("bridegroom_coordinates")
    @Expose
    private String bridegroom_coordinates;
    @SerializedName("userid")
    @Expose
    private String userid;

    public String getAyanamsa() {
        return ayanamsa;
    }

    @Override
    public String toString() {
        return "Response{" +
                "ayanamsa='" + ayanamsa + '\'' +
                ", bride_dob='" + bride_dob + '\'' +
                ", bridegroom_dob='" + bridegroom_dob + '\'' +
                ", bride_coordinates='" + bride_coordinates + '\'' +
                ", bridegroom_coordinates='" + bridegroom_coordinates + '\'' +
                ", userid='" + userid + '\'' +
                '}';
    }

    public void setAyanamsa(String ayanamsa) {
        this.ayanamsa = ayanamsa;
    }

    public String getBride_dob() {
        return bride_dob;
    }

    public void setBride_dob(String bride_dob) {
        this.bride_dob = bride_dob;
    }

    public String getBridegroom_dob() {
        return bridegroom_dob;
    }

    public void setBridegroom_dob(String bridegroom_dob) {
        this.bridegroom_dob = bridegroom_dob;
    }

    public String getBride_coordinates() {
        return bride_coordinates;
    }

    public void setBride_coordinates(String bride_coordinates) {
        this.bride_coordinates = bride_coordinates;
    }

    public String getBridegroom_coordinates() {
        return bridegroom_coordinates;
    }

    public void setBridegroom_coordinates(String bridegroom_coordinates) {
        this.bridegroom_coordinates = bridegroom_coordinates;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
