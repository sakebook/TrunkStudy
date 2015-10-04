package com.sakebook.android.sample.retrofitsample.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sakebook.android.sample.retrofitsample.models.CatResultModel;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by sakemotoshinya on 15/08/31.
 */
public class CatNewsClient {

    private final static String CAT_NEWS_API_HOST =
            "https://ajax.googleapis.com/";

    public static void getResultModel(String keyword, Callback<CatResultModel> callback) {

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(CatResultModel.class, new CatDeserializer())
                .create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(CAT_NEWS_API_HOST)
                .setConverter(new GsonConverter(gson))
                .build();

        CatNewsService catNewsService =
                restAdapter.create(CatNewsService.class);
        catNewsService.results(keyword, callback);
    }
}
