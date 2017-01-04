package com.abhishek.chapphmansample.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Abhishek on 30/12/16.
 */

public class MobileVerificationResponse {
    @SerializedName("data")
    @Expose
    private Object data;
    @SerializedName("meta")
    @Expose
    private Meta meta;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
