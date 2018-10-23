package com.example.lenovo.newsreaderapp.retrofit;

import com.example.lenovo.newsreaderapp.model.HeadLines;
import com.example.lenovo.newsreaderapp.model.News;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MyApi {

    @GET("sources?apiKey=632040e6ff184ac19da403aa919a57f9")
    Observable<News> getNews();


    @GET("top-headlines")
    Observable<HeadLines> getHeadLines(@Query("sources") String source,
                                       @Query("apiKey") String apiKey);

}
