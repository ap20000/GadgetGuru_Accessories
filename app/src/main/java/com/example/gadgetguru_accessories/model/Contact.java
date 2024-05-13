package com.example.gadgetguru_accessories.model;

import com.google.gson.annotations.SerializedName;

public class Contact {
    @SerializedName("full_name")
    private String fullName;



    @SerializedName("email")
    private String email;

    @SerializedName("subject")
    private String subject;

    public Contact(String fullName, String email, String subject) {
        this.fullName = fullName;
        this.email = email;
        this.subject = subject;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
