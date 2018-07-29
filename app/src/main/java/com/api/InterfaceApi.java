package com.api;


import com.models.ModelProducts;

import retrofit2.Call;
import retrofit2.http.GET;

public interface InterfaceApi {


    //whole url : https://api.myjson.com/bins/nbixm

    @GET("/bins/nbixm")
    Call<ModelProducts> getProducts();


}