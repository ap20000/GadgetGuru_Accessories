package com.example.gadgetguru_accessories.utilities;

import com.example.gadgetguru_accessories.model.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("loginGet.php")
    Call<User> getlogin(@Query("user_name") String username, @Query("password") String password);
}


