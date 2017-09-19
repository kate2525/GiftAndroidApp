package com.gmail.kovalenko.data.net;


import com.gmail.kovalenko.data.entity.Root;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface RestAPI {

    @GET("v1/gifs/trending")
    @Headers("api_key: VqCNdWMugyqh9tdT1XKaURs312xOlZFx")
    Observable<Root> getImages();

    @GET("v1/gifs/search")
    @Headers("api_key: VqCNdWMugyqh9tdT1XKaURs312xOlZFx")
    Observable<Root> search(@Query("q") String search);
}