package com.example.retrofitpost.models;

import com.google.gson.annotations.SerializedName;

public class Todos {

    @SerializedName("userId")
    public String userId;
    @SerializedName("id")
    public String id;
    @SerializedName("title")
    public String title;
    @SerializedName("completed")
    public String completed;

    public Todos(String userId, String id, String title, String completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }
}
