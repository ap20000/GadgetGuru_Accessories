package com.example.gadgetguru_accessories.utilities;

import com.example.gadgetguru_accessories.model.User;



import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GadgetWebService {
    private static final String BASE_URL = "http://your-web-service-url/";

    private static GadgetWebService INSTANCE;
    private final Retrofit retrofit;

    private GadgetWebService() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized GadgetWebService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GadgetWebService();
        }
        return INSTANCE;
    }

    public void login(String username, String password, Callback<User> callback) {
        GadgetService service = retrofit.create(GadgetService.class);
        Call<User> call = service.login(username, password);
        call.enqueue(callback);
    }
}


