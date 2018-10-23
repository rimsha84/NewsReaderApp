package com.example.lenovo.newsreaderapp.model;

public class Source {
    public String id;
    public String name;
    public String description;
    public String cateogry;


    public Source() {
    }

    public Source(String id, String name, String description, String cateogry) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cateogry = cateogry;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCateogry() {
        return cateogry;
    }

    public void setCateogry(String cateogry) {
        this.cateogry = cateogry;
    }
}

