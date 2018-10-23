package com.example.lenovo.newsreaderapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.example.lenovo.newsreaderapp.adapter.adapter;
import com.example.lenovo.newsreaderapp.model.News;
import com.example.lenovo.newsreaderapp.retrofit.MyApi;
import com.example.lenovo.newsreaderapp.retrofit.RetrofitBuilder;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class Splash extends AppCompatActivity {


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
        setContentView(R.layout.activity_splash);

//        Thread mythread= new Thread(){
//
//            public void run(){
//                try {
//                    sleep(1000);
//
//                }catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        };mythread.start();



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


        disposable.add(my_api.getNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<News>() {
                    @Override
                    public void accept(News news) throws Exception {

                        progressDialog.dismiss();
                        common.articles= news.getSources();

                        Log.e("size", String.valueOf(news.getSources().size()));

                        Intent intent = new Intent(Splash.this,MainActivity.class);
                        startActivity(intent);
                        finish();

                    }
                }));


    }
      @Override
    protected void onStop() {
        super.onStop();
        disposable.dispose();
}
}
