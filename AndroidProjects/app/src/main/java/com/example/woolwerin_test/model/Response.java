package com.example.woolwerin_test.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Response {
    @SerializedName("status_code")
    @Expose
    private String status_code;
    @SerializedName("status_message")
    @Expose
    private String status_message;
    @SerializedName("bride_details")
    @Expose
    private String bride_details;

    @Override
    public String toString() {
        return "Response{" +
                "status_code='" + status_code + '\'' +
                ", status_message='" + status_message + '\'' +
                ", bride_details='" + bride_details + '\'' +
                '}';
    }



    public String getStatus_code() {
        return status_code;
    }

    public void setStatus_code(String status_code) {
        this.status_code = status_code;
    }

    public String getStatus_message() {
        return status_message;
    }

    public void setStatus_message(String status_message) {
        this.status_message = status_message;
    }

    public String getBride_details() {
        return bride_details;
    }

    public void setBride_details(String bride_details) {
        this.bride_details = bride_details;
    }

}



