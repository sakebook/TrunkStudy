package com.sakebook.android.sample.retrofitsample.network;

import android.support.annotation.NonNull;

import com.sakebook.android.sample.retrofitsample.models.CatNewsModel;
import com.sakebook.android.sample.retrofitsample.models.CatResultModel;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by sakemotoshinya on 15/08/27.
 */
public interface CatNewsService {


//    https://ajax.googleapis.com
// /ajax/services/search/news?v=1.0&q=%E3%82%A2%E3%82%A4%E3%82%B9


    @GET("/ajax/services/search/news?v=1.0")
    void results(@Query("q") String keyword,
                 Callback<List<CatNewsModel>> callback);



//    @NonNull
//    @GET("/api/v1/tags/{tagName}/items")
//    void tagArticles(@Path("tagName") String tagName, Callback<List<CatNewsModel>> callback);



}

