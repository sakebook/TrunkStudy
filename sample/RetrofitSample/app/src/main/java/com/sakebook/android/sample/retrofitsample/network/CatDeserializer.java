package com.sakebook.android.sample.retrofitsample.network;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.sakebook.android.sample.retrofitsample.MyApplication;
import com.sakebook.android.sample.retrofitsample.models.CatResultModel;

import java.lang.reflect.Type;

/**
 * Created by sakemotoshinya on 15/09/19.
 * reference: https://stackoverflow.com/questions/21815008/using-retrofit-to-access-json-arrays
 */
public class CatDeserializer implements JsonDeserializer {

    @Override
    public CatResultModel deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Log.d(MyApplication.TAG, "deserialize: " + json.toString());
        JsonElement content = json.getAsJsonObject().get("responseData");

//        Wed, 30 Sep 2015 23:56:15 -0700
        Gson gson = new GsonBuilder()
                .setDateFormat("EEE, dd MMM yyyy HH:mm:ss z")
                .create();
        return gson.fromJson(content, typeOfT);
    }
}
