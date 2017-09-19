package com.gmail.kovalenko.data.net;


import android.util.Log;

import com.gmail.kovalenko.data.entity.Data;
import com.gmail.kovalenko.data.entity.Root;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import java.util.concurrent.TimeUnit;
import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestService {

    private static final RestService instance = new RestService();
    private  RestAPI restAPI;

    private RestService(){
        init();
    }

    public static RestService getInstance(){
        return instance;
    }

    public  void init(){

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();

        Gson gson = new GsonBuilder().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.giphy.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient).build();

        restAPI = retrofit.create(RestAPI.class);
    }

    public Observable <Root> getImages(){
        return  restAPI.getImages();
    }

    public Observable <Root> search(String search){
        return  restAPI.search(search);
    }

}

