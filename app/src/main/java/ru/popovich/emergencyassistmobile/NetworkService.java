package ru.popovich.emergencyassistmobile;

import android.util.Log;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    private static NetworkService mInstance;
    private static final String BASE_URL = "http://86.102.102.165:8999/";
//    private static final String BASE_URL = "http://192.168.74.16:8999/";
    private Retrofit mRetrofit;

//    private int connectTimeout;
//    private int readTimeout;
//    private int writeTimeout;

    private static RestApiService restApiService;

    //    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

    OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
//            .connectTimeout(connectTimeout, TimeUnit.SECONDS)
//            .readTimeout(readTimeout, TimeUnit.SECONDS)
//            .writeTimeout(writeTimeout, TimeUnit.SECONDS)
            .build();

    private NetworkService() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        restApiService = mRetrofit.create(RestApiService.class);
    }

    public static NetworkService getInstance() {
        if (mInstance == null) {
            mInstance = new NetworkService();
        }
        return mInstance;
    }

    public RestApiService getRestApi(){
        return restApiService;
    }
}