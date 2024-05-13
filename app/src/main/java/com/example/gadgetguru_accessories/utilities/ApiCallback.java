package com.example.gadgetguru_accessories.utilities;

import com.example.gadgetguru_accessories.model.Product;

import java.util.ArrayList;

public interface ApiCallback {
    void Success(ArrayList<Product> accessoriesList);
    void Failure(String message);
}
