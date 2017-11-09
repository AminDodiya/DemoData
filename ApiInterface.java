package com.example.brevity.retropostdemo.utils;

import com.example.brevity.retropostdemo.been.LoginHandler.LoginRes;

import okhttp3.RequestBody;
import okhttp3.internal.http.RequestException;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ApiInterface {

    @Headers({"Content-Type: application/json",
            "Authorization: 3F30nkizWK9pOcFblhTiIyySdfQK7gAiCm49M1UVBKs=",
            "USERNAME: 0T3zN/X+zPNW6HxNrBLmgw==",
            "PASSWORD: 0T3zN/X+zPNW6HxNrBLmgw=="})
    @POST
    Call<LoginRes>getLoginResCall(@Url String url,@Body RequestBody requestBody);

}