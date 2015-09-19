package com.sakebook.android.sample.retrofitsample.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sakemotoshinya on 15/09/18.
 */
public class CatResultModel {
    @SerializedName("results")
    List<CatNewsModel> mCatNewsModels;

    public List<CatNewsModel> getCatNewsModels() {
        return mCatNewsModels;
    }
}
