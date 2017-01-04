package com.abhishek.chapphmansample.API;

import android.content.Context;
import android.util.Log;

import com.abhishek.chapphmansample.Activies.MainActivity;
import com.abhishek.chapphmansample.Utils.DataStore;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.R.string.ok;


/**
 * Created by Abhishek on 30/12/16.
 */
public class APIInterface {
    private static APIInterface apiInstance = new APIInterface();
    private static Retrofit retrofit;



    public static Retrofit getInstance(final Context context) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(Level.BASIC);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        // add your other interceptors …

        // add logging as last interceptor
        httpClient.addInterceptor(logging);
            httpClient.addInterceptor(new Interceptor() {

                @Override
                public Response intercept(Chain chain) throws IOException {
                    String token;
                    if(DataStore.getAuthToken(context) != null) {
                        token = DataStore.getAuthToken(context);
                    } else {
                        token = "";
                    }
                    Request original = chain.request();
                    Request request = original.newBuilder()
                            .header("Accept", "application/json")
                            .header("Content-Type", "application/json")
                            .header("token", ""+token+"")
                            .method(original.method(), original.body())
                            .build();
                    Log.i(MainActivity.NETWORK_TAG, "Auth Token SET, TOKEN:" + token);
                    return chain.proceed(request);
                }
            });
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://52.77.215.120/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }
        return APIInterface.retrofit;
    }
}
