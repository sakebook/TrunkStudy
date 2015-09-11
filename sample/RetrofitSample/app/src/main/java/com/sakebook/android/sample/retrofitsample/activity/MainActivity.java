package com.sakebook.android.sample.retrofitsample.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.sakebook.android.sample.retrofitsample.MyApplication;
import com.sakebook.android.sample.retrofitsample.R;
import com.sakebook.android.sample.retrofitsample.models.QiitaModel;
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

        QiitaApiClient.getModels("Android", new Callback<List<QiitaModel>>() {
            @Override
            public void success(List<QiitaModel> qiitaModels, Response response) {
                Log.d(MyApplication.TAG, "" + qiitaModels.size());
                Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
                for (QiitaModel model: qiitaModels) {
                    Log.d(MyApplication.TAG, "" + model.getTitle());
                }
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d(MyApplication.TAG, "" + error.getMessage());
                Toast.makeText(MainActivity.this, "error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
