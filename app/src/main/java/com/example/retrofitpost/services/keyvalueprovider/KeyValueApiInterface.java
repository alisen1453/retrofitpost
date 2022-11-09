package com.example.retrofitpost.services.keyvalueprovider;

import com.example.retrofitpost.MainActivity;
import com.example.retrofitpost.models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface KeyValueApiInterface {
   // @FormUrlEncoded
    @POST("/keyValues")
    Call<User> getdata(@Body User user);

}
