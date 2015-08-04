package com.sakebook.android.trunksimplenews.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sakemotoshinya on 15/07/31.
 */
public class Article {

    @SerializedName("title")
    private String mTitle;
    @SerializedName("url")
    private String mUrl;
    @SerializedName("user:profile_image_url")
    private String mImageUrl;
    @SerializedName("body")
    private String mDescription;
    @SerializedName("user")
    private User mUser;

    public void setUser(User user) {
        mUser = user;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public User getUser() {
        return mUser;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getUrl() {
        return mUrl;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public String getDescription() {
        return mDescription;
    }
}
