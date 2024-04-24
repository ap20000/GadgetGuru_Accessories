package com.example.gadgetguru_accessories.model;

import com.google.gson.annotations.SerializedName;

public class loginUser {



    @SerializedName("user_name")
    private String userName;

    @SerializedName("password")
    private String password;

    public loginUser(String userName, String password) {

        this.userName = userName;
        this.password = password;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
