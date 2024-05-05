package com.example.gadgetguru_accessories.utilities;

import com.example.gadgetguru_accessories.model.Product;

import java.util.ArrayList;

public interface ApiCallback {
    void onSuccess(ArrayList<Product> productList);
    void onFailure(String message);
}
