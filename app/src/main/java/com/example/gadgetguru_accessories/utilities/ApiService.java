package com.example.gadgetguru_accessories.utilities;

import com.example.gadgetguru_accessories.model.Contact;
import com.example.gadgetguru_accessories.model.LoginUser;
import com.example.gadgetguru_accessories.model.Product;
import com.example.gadgetguru_accessories.model.User;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface ApiService {
    @POST("user_login.php")
    Call<Object> loginGuruUser(@Body LoginUser password);


    @POST("register.php")
    Call<Object> UsereaddRegister(@Body User user);

    @POST("contact.php")
    Call<Object> Contact(@Body Contact contact);


    @GET("product.php")
    Call<List<Product>> getAccessories();

    @GET("user/{username}")
    Call<User> getUserDetails(@Path("username") String username);




//    Call<Object> contactu(com.example.gadgetguru_accessories.view.viewHolder.Contact contact);


//    Call<Object> contact(com.example.gadgetguru_accessories.view.viewHolder.Contact contact);
}


