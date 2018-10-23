package com.example.lenovo.newsreaderapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import com.example.lenovo.newsreaderapp.adapter.adapter;
import com.example.lenovo.newsreaderapp.model.Article;
import com.example.lenovo.newsreaderapp.model.News;
import com.example.lenovo.newsreaderapp.model.Source;
import com.example.lenovo.newsreaderapp.retrofit.MyApi;
import com.example.lenovo.newsreaderapp.retrofit.RetrofitBuilder;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public  class common  {

    static List<Source> articles = new ArrayList<>();







//    MyApi my_api;
//    static CompositeDisposable disposable = new CompositeDisposable();
//    ProgressDialog progressDialog;
//
//    ProgressDialog progressSetter() {
//       // ProgressDialog progressDialog = new ProgressDialog(this);
//        progressDialog.setMessage("Getting news");
//        progressDialog.setTitle("Please wait..");
//        return progressDialog;
//    }
//
//    Retrofit retrofit = RetrofitBuilder.getInstance();
//
//    void getData() {
//
//        disposable.add(my_api.getNews()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<News>() {
//                    @Override
//                    public void accept(News news) throws Exception {
//
//
//                    }
//                }));
//
//
//
//    }

}
