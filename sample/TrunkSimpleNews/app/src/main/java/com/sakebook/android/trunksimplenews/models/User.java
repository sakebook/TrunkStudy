package com.sakebook.android.trunksimplenews.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sakemotoshinya on 15/08/04.
 */
public class User {

    @SerializedName("profile_image_url")
    private String mImageUrl;

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }
}
