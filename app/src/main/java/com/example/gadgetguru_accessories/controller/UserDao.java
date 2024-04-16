package com.example.gadgetguru_accessories.controller;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.gadgetguru_accessories.model.User;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user WHERE user_name = :userName")
    User getUserByUsername(String userName);

    @Query("SELECT * FROM user WHERE email = :email")
    User getUserByEmail(String email);

    @Insert
    void insert(User user);


    @Query("SELECT * FROM user WHERE user_name = :username AND password = :password")
    User getUser(String username, String password);
}
