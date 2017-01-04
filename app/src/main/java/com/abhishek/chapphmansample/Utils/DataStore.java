package com.abhishek.chapphmansample.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.abhishek.chapphmansample.Model.VerifyOtp;
import com.abhishek.chapphmansample.R;

/**
 * Created by Abhishek on 03/01/17.
 */

public class DataStore {
    static SharedPreferences sharedPref;
    static SharedPreferences.Editor editor;
    public void storeUserInfo(VerifyOtp otp, Context context) {
         sharedPref = context.getSharedPreferences(String.valueOf(R.string.com_example_myapp_PREFERENCE_FILE_KEY), Context.MODE_PRIVATE);
         editor = sharedPref.edit();
        editor.putString(String.valueOf(R.string.authToken), otp.getData().getAuthenticationToken().toString());
        editor.putString(String.valueOf(R.string.userName), otp.getData().getName());
        editor.putString(String.valueOf(R.string.profileImageUrl), otp.getData().getProfileImage());
        editor.commit();
    }

    public static String getAuthToken(Context context) {
        sharedPref = context.getSharedPreferences(String.valueOf(R.string.com_example_myapp_PREFERENCE_FILE_KEY), Context.MODE_PRIVATE);
        String authToken = sharedPref.getString(Integer.toString(R.string.authToken), null);
        return authToken;
    }

    public static String getUserName(Context context) {
        sharedPref = context.getSharedPreferences(String.valueOf(R.string.com_example_myapp_PREFERENCE_FILE_KEY), Context.MODE_PRIVATE);
        String userName = sharedPref.getString(Integer.toString(R.string.userName), null);
        return userName;
    }

    public static String getProfileImageUrl(Context context) {
        sharedPref = context.getSharedPreferences(String.valueOf(R.string.com_example_myapp_PREFERENCE_FILE_KEY), Context.MODE_PRIVATE);
        String profileImageUrl = sharedPref.getString(Integer.toString(R.string.profileImageUrl), null);
        return profileImageUrl;
    }

    public static void deleteAuthToken(Context context){
        sharedPref = context.getSharedPreferences(String.valueOf(R.string.com_example_myapp_PREFERENCE_FILE_KEY), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.clear();
        editor.apply();
    }

}
