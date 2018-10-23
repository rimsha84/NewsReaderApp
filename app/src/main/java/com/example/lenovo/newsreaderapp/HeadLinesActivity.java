package com.example.lenovo.newsreaderapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.lenovo.newsreaderapp.adapter.NewsAdapter;
import com.example.lenovo.newsreaderapp.adapter.adapter;
import com.example.lenovo.newsreaderapp.model.Article;
import com.example.lenovo.newsreaderapp.model.HeadLines;
import com.example.lenovo.newsreaderapp.model.News;
import com.example.lenovo.newsreaderapp.retrofit.MyApi;
import com.example.lenovo.newsreaderapp.retrofit.RetrofitBuilder;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class HeadLinesActivity extends AppCompatActivity {
    RecyclerView rview;
    NewsAdapter newsAdapter;
    Toolbar toolbar;


    String source;


    CompositeDisposable disposable = new CompositeDisposable();
    MyApi my_api;

    ProgressDialog progressDialog;

    ProgressDialog progressSetter() {
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Getting news");
        progressDialog.setTitle("Please wait..");
        return progressDialog;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head_lines);

        toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String sourcename= getIntent().getExtras().getString("name");
        toolbar.setTitle(sourcename);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HeadLinesActivity.this,MainActivity.class);
                finish();
            }
        });

        rview = findViewById(R.id.recyclerview);




        progressDialog = progressSetter();
        progressDialog.show();


        //creating retrofit object

        Retrofit retrofit = RetrofitBuilder.getInstance();

        //now saying retrofit to implement myapi class


        my_api = retrofit.create(MyApi.class);

        try {
            getData();
        } catch (Exception e) {
            Log.e("ExceptionFromServer", e.getMessage());
        }


    }

    private void getData() {
        String source_id = getIntent().getExtras().getString("source");

        disposable.add(my_api.getHeadLines(source_id, getString(R.string.api_key))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HeadLines>() {
                    @Override
                    public void accept(HeadLines news) throws Exception {

                        progressDialog.dismiss();

                        Log.e("size", String.valueOf(news.getArticles().size()));
                        rview.setLayoutManager(new LinearLayoutManager(HeadLinesActivity.this));
                        newsAdapter = new NewsAdapter(news.getArticles(), HeadLinesActivity.this);
                        rview.setAdapter(newsAdapter);

                    }
                }));

    }
    @Override
    protected void onStop() {
        super.onStop();
        disposable.dispose();
    }
}