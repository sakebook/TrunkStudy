package com.sakebook.android.sample.retrofitsample.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sakemotoshinya on 15/08/27.
 */
public class QiitaModel {

    @SerializedName("user")
    public QiitaUser mUser;

    public class QiitaUser {

        @SerializedName("url_name")
        public String mName;
        @SerializedName("profile_image_url")
        public String mImageUrl;
    }


}
