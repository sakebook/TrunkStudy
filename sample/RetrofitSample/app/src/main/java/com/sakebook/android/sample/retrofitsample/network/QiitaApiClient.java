package com.sakebook.android.sample.retrofitsample.network;

import com.sakebook.android.sample.retrofitsample.models.QiitaModel;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;

/**
 * Created by sakemotoshinya on 15/08/31.
 */
public class QiitaApiClient {

    private final static String QIITA_API_HOST = "https://qiita.com/";

    public static void getModels(String tagName, Callback<List<QiitaModel>> callback) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(QIITA_API_HOST)
                .build();
        QiitaService qiitaService = restAdapter.create(QiitaService.class);
        qiitaService.tagArticles(tagName, callback);
    }

}
