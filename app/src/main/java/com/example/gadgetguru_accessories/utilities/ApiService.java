package com.example.gadgetguru_accessories.utilities;

import com.example.gadgetguru_accessories.model.User;
import com.example.gadgetguru_accessories.model.loginUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @GET("user_login.php")
    Call<Void> loginUser(loginUser user);

    @POST("register.php")
    Call<User> registerUser(@Body User user);


}


