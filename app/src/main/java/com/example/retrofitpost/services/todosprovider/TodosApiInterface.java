package com.example.retrofitpost.services.todosprovider;

import com.example.retrofitpost.models.Todos;
import com.example.retrofitpost.models.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface TodosApiInterface {
    @GET("todos/")
   Observable<List<Todos>> getvalue();

}
