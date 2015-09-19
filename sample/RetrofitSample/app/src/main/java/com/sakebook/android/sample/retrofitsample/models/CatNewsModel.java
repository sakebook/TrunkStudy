package com.sakebook.android.sample.retrofitsample.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by sakemotoshinya on 15/08/27.
 */
public class CatNewsModel {

//    @SerializedName("image")
//    public CatImageModel mCatImageModel;

    @SerializedName("title")
    public String mTitle;

    @SerializedName("unescapedUrl")
    public String mUrl;

    @SerializedName("publishedDate")
    public Date mPublishDate;


//    public CatImageModel getCatImageModel() {
//        return mCatImageModel;
//    }
//
//    public String getCatImageUrl() {
//        if (getCatImageModel() != null) {
//            return this.getCatImageModel().mImageUrl;
//        } else {
//            return "";
//        }
//    }

    public String getTitle() {
        return mTitle;
    }

    public String getUrl() {
        return mUrl;
    }

    public Date getPublishDate() {
        return mPublishDate;
    }

    public class CatImageModel {

        @SerializedName("url")
        public String mImageUrl;
    }
}


