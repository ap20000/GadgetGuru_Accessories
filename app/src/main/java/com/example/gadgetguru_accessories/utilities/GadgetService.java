package com.example.gadgetguru_accessories.utilities;

import com.example.gadgetguru_accessories.model.User;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface GadgetService {
    @POST("login")
    Call<User> login(@Query("user_name") String username, @Query("password") String password);
}
