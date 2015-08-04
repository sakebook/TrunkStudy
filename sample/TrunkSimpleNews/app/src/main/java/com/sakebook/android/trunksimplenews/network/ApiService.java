package com.sakebook.android.trunksimplenews.network;

import com.sakebook.android.trunksimplenews.models.Article;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by sakemotoshinya on 15/08/02.
 */
public interface ApiService {
    @GET("/api/v1/tags/{tagName}/items")
    List<Article> listTagArticles(
            @Path("tagName") String tagName);
    //https://qiita.com/api/v1/tags/Android/items

    @GET("/api/v1/tags/{tagName}/items")
    void getFeed(@Path("tagName") String tagName, Callback<List<Article>> response);
}
