package com.sakebook.android.trunksimplenews.models;

/**
 * Created by sakemotoshinya on 15/07/31.
 */
public class Article {


    private String mTitle;
    private String mUrl;
    private String mImageUrl;
    private String mDescription;

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
