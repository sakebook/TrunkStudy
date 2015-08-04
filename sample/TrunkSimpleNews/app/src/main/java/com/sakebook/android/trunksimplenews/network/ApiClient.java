package com.sakebook.android.trunksimplenews.network;

import com.sakebook.android.trunksimplenews.models.Article;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;

/**
 * Created by sakemotoshinya on 15/08/02.
 */
public class ApiClient {

    private final static String API_HOST = "https://qiita.com";

    public static void getArticles(Callback<List<Article>> callback) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API_HOST)
                .build();
        ApiService service = restAdapter.create(ApiService.class);
        service.getFeed("Android", callback);
    }
}
