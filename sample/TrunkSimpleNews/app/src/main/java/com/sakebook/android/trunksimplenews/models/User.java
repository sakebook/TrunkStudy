package com.sakebook.android.trunksimplenews.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by sakemotoshinya on 15/08/04.
 */
public class User implements Serializable {

    @SerializedName("profile_image_url")
    private String mImageUrl;

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }
}
