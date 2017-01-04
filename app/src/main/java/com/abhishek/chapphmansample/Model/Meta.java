package com.abhishek.chapphmansample.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Abhishek on 30/12/16.
 */

public class Meta {

    @SerializedName("status")
    private int status;

    @SerializedName("message")
    private String message;

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

}
