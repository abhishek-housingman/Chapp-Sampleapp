package com.abhishek.chapphmansample.Model;

import android.content.Context;
import android.util.Log;

import com.abhishek.chapphmansample.API.APIInterface;
import com.abhishek.chapphmansample.API.ApiEndPoints;
import com.abhishek.chapphmansample.Activies.MainActivity;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Abhishek on 30/12/16.
 */

public class MobileVerification {

    @SerializedName("mobile")
    @Expose
    private String mobile;

    public String getMobile() {
        return mobile;
    }

    public MobileVerification(String number) {
        this.mobile = number;
    }

    @SerializedName("data")
    @Expose
    private Object data;

    @SerializedName("meta")
    @Expose
    private Meta meta;
    private ApiListener listener;
    public interface ApiListener {
        public void onCompletion();
    }

    public void setListener(ApiListener listener) {
        this.listener = listener;
    }

    public Object getData() {
        return data;
    }

    private void setData(Object data) {
        this.data = data;
    }

    private void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Meta getMeta() {
        return meta;
    }


    public MobileVerification verifyMobileNumber(final MobileVerification verification, Context context) {
            ApiEndPoints verifyNumberEndPoint = APIInterface.getInstance(context).create(ApiEndPoints.class);
            Call<MobileVerification> call = verifyNumberEndPoint.mobileVerification(verification);
            call.enqueue(new Callback<MobileVerification>() {
                @Override
                public void onResponse(Call<MobileVerification> call, Response<MobileVerification> response) {
                    Log.i(MainActivity.NETWORK_TAG, response.body().getMeta().getMessage());
                    Log.i(MainActivity.NETWORK_TAG, String.valueOf(response.body().getMeta().getStatus()));
                    verification.setData(response.body().getData());
                    verification.setMeta(response.body().getMeta());
                    listener.onCompletion();
                }
                @Override
                public void onFailure(Call<MobileVerification> call, Throwable t) {

                }
            });
        return verification;
    }
}
