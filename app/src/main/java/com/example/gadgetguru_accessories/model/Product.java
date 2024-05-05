package com.example.gadgetguru_accessories.model;

import com.google.gson.annotations.SerializedName;

public class Product {
    @SerializedName("product_name")
    private String productName;

    @SerializedName("price")
    private String productPrice;

    @SerializedName("image")
    private String image;

    public Product(String productName, String productPrice, String image) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.image = image;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}