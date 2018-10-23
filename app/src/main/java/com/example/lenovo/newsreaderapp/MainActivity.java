package com.example.lenovo.newsreaderapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.newsreaderapp.adapter.adapter;
import com.example.lenovo.newsreaderapp.model.News;
import com.example.lenovo.newsreaderapp.model.User;
import com.example.lenovo.newsreaderapp.retrofit.MyApi;
import com.example.lenovo.newsreaderapp.retrofit.RetrofitBuilder;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {


    RecyclerView rview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rview = findViewById(R.id.rview);


        rview.setLayoutManager(new LinearLayoutManager(this));
        adapter adpt = new adapter(common.articles, this);
        rview.setAdapter(adpt);

    }


 //    }
}
