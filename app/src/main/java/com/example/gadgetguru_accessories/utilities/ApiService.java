package com.example.gadgetguru_accessories.utilities;

import com.example.gadgetguru_accessories.model.LoginUser;
import com.example.gadgetguru_accessories.model.User;


import retrofit2.Call;
import retrofit2.http.Body;

import retrofit2.http.POST;


public interface ApiService {
    @POST("user_login.php")
    Call<Object> loginUser(@Body LoginUser password);


    @POST("register.php")
    Call<Object> registerUser(@Body User user);


}


