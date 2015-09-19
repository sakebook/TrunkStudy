package com.sakebook.android.sample.retrofitsample.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sakebook.android.sample.retrofitsample.models.CatNewsModel;
import com.sakebook.android.sample.retrofitsample.models.CatResultModel;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;

/**
 * Created by sakemotoshinya on 15/08/31.
 */
public class CatNewsClient {

    private final static String CAT_NEWS_API_HOST =
            "https://ajax.googleapis.com/";

    public static void getCatNews(String keyword, Callback<List<CatNewsModel>> callback) {

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(CAT_NEWS_API_HOST)
                .build();

        CatNewsService catNewsService =
                restAdapter.create(CatNewsService.class);
        catNewsService.results(keyword, callback);
    }


    


//    public static void getModels(String tagName, Callback<List<CatNewsModel>> callback) {
//        RestAdapter restAdapter = new RestAdapter.Builder()
//                .setEndpoint(CAT_NEWS_API_HOST)
//                .build();
//        CatNewsService qiitaService = restAdapter.create(CatNewsService.class);
//        qiitaService.tagArticles(tagName, callback);
//    }

}
