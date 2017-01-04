package com.abhishek.chapphmansample.API;

import com.abhishek.chapphmansample.Model.MobileVerification;
import com.abhishek.chapphmansample.Model.MobileVerificationResponse;
import com.abhishek.chapphmansample.Model.Project;
import com.abhishek.chapphmansample.Model.VerifyOtp;
import com.abhishek.chapphmansample.Utils.DataStore;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Abhishek on 30/12/16.
 */

public interface ApiEndPoints {

    @Headers("Accept: application/json, Content-Type: application/json")
    @POST("verify_mobile")
    Call<MobileVerification> mobileVerification(@Body MobileVerification number);

    @Headers("Accept: application/json, Content-Type: application/json")
    @POST("verify_otp")
    Call<VerifyOtp> verifyOtp(@Body VerifyOtp otp);



    @Headers("Accept: application/json, Content-Type: application/json")
    @POST("projects/search")
    Call<Project> searchProject(@Body Project project);

}
