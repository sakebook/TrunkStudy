package com.sakebook.android.sample.retrofitsample.network;

import android.support.annotation.NonNull;

import com.sakebook.android.sample.retrofitsample.models.QiitaModel;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by sakemotoshinya on 15/08/27.
 */
public interface QiitaService {

    @NonNull
    @GET("/api/v1/tags/{tagName}/items")
    void tagArticles(@Path("tagName") String tagName, Callback<List<QiitaModel>> callback);
}

