package com.example.lenovo.newsreaderapp.model;

import java.util.List;

public class HeadLines {

    List<Article> articles;
    String status;

    public HeadLines() {
    }

    public HeadLines(List<Article> articles, String status) {
        this.articles = articles;
        this.status = status;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
