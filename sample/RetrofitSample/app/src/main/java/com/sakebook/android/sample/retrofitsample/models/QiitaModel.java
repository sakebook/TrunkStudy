package com.sakebook.android.sample.retrofitsample.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sakemotoshinya on 15/08/27.
 */
public class QiitaModel {

    @SerializedName("user")
    public QiitaUser mUser;

    @SerializedName("title")
    public String mTitle;

    public QiitaUser getUser() {
        return mUser;
    }

    public String getTitle() {
        return mTitle;
    }

    public class QiitaUser {

        @SerializedName("url_name")
        public String mName;
        @SerializedName("profile_image_url")
        public String mImageUrl;

        public String getName() {
            return mName;
        }

        public String getImageUrl() {
            return mImageUrl;
        }
    }


}
