package com.example.gadgetguru_accessories.utilities;

import android.content.Context;

public interface LoginApiCallback {
    void onSuccess(Object response, Context context);
    void onFailure(String message, Context context);
}
