package com.sakebook.android.sample.retrofitsample.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.sakebook.android.sample.retrofitsample.MyApplication;
import com.sakebook.android.sample.retrofitsample.R;
import com.sakebook.android.sample.retrofitsample.models.CatNewsModel;
import com.sakebook.android.sample.retrofitsample.models.CatResultModel;
import com.sakebook.android.sample.retrofitsample.models.QiitaModel;
import com.sakebook.android.sample.retrofitsample.network.CatNewsClient;
import com.sakebook.android.sample.retrofitsample.network.QiitaApiClient;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_qiita).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchQiitaAPI();
            }
        });

        findViewById(R.id.button_google).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchGoogleSearchApi();
            }
        });

    }

    private void fetchQiitaAPI() {
        QiitaApiClient.getModels("Android", new Callback<List<QiitaModel>>() {
            @Override
            public void success(List<QiitaModel> qiitaModels, Response response) {
                Log.d(MyApplication.TAG, "" + qiitaModels.size());
                Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
                for (QiitaModel model : qiitaModels) {
                    Log.d(MyApplication.TAG, "" + model.getTitle());
                }
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d(MyApplication.TAG, "" + error.getMessage());
                Toast.makeText(MainActivity.this, "error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d(MyApplication.TAG, "failure url : " + error.getUrl());
            }
        });
    }


    private void fetchGoogleSearchApi() {
        CatNewsClient.getCatModels("猫", new Callback<CatResultModel>() {
            @Override
            public void success(CatResultModel catResultModel, Response response) {
                Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
                List<CatNewsModel> catNewsModels = catResultModel.getCatNewsModels();
                Log.d(MyApplication.TAG, "size: " + catNewsModels.size());
                for (CatNewsModel catNewsModel : catNewsModels) {
                    Log.d(MyApplication.TAG, catNewsModel.getTitle());
                    Log.d(MyApplication.TAG, catNewsModel.getCatImageUrl());
                }
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d(MyApplication.TAG, "failure url : " + error.getUrl());
            }
        });
    }

}
