package com.abhishek.chapphmansample.Model;

import android.content.Context;
import android.media.MediaActionSound;
import android.util.Log;

import com.abhishek.chapphmansample.API.APIInterface;
import com.abhishek.chapphmansample.API.ApiEndPoints;
import com.abhishek.chapphmansample.Activies.MainActivity;
import com.google.gson.annotations.SerializedName;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.os.Build.VERSION_CODES.M;

/**
 * Created by Abhishek on 31/12/16.
 */

public class VerifyOtp {
    @SerializedName("mobile")
    private String mobile;

    @SerializedName("otp")
    private String otp;

    @SerializedName("data")
    private Data data;

    @SerializedName("meta")
    private Meta meta;

    private ResponseListener listener;
    public interface ResponseListener{
        public void onCompletion();
    }

    public void setListener(ResponseListener listener){
        this.listener = listener;
    }

    public VerifyOtp responseData;

    private void setResponse(VerifyOtp otpResponse) {
        this.responseData = otpResponse;
    }

    public String getMobile() {
        return mobile;
    }

    public String getOtp() {
        return otp;
    }

    public Data getData() {
        return data;
    }

    public Meta getMeta() {
        return meta;
    }

    public VerifyOtp(String mobile, String otp) {
        this.mobile = mobile;
        this.otp = otp;
    }

    public void verifyOtpCall(final VerifyOtp otp, Context context) {
        ApiEndPoints endPoint = APIInterface.getInstance(context).create(ApiEndPoints.class);
        VerifyOtp responseObj;
        Call<VerifyOtp> call = endPoint.verifyOtp(otp);

        call.enqueue(new Callback<VerifyOtp>() {
            @Override
            public void onResponse(Call<VerifyOtp> call, Response<VerifyOtp> response) {
                Log.i(MainActivity.NETWORK_TAG, String.valueOf(response.body().getMeta().getStatus()));
                Log.i(MainActivity.NETWORK_TAG, response.body().getData().getName().toString());
                Log.i(MainActivity.NETWORK_TAG, response.body().getData().getEmail().toString());
                Log.i(MainActivity.NETWORK_TAG, response.body().getData().getAuthenticationToken());
                setResponse(response.body());
                listener.onCompletion();
            }

            @Override
            public void onFailure(Call<VerifyOtp> call, Throwable t) {

            }
        });

    }
}
