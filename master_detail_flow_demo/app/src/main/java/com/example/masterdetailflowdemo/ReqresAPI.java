package com.example.masterdetailflowdemo;

import com.example.masterdetailflowdemo.dummy.Users;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ReqresAPI {
    String BASE_URL = "https://reqres.in/api/";

    @GET("users?page=1")
    Call<Users> getUsers();
}
