package com.abhishek.chapphmansample.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Abhishek on 02/01/17.
 */

public class LocalityInfo {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }


}
