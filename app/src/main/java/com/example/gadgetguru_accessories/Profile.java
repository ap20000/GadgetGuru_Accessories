package com.example.gadgetguru_accessories;

import static com.example.gadgetguru_accessories.utilities.ApiClient.createApiService;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gadgetguru_accessories.model.User;
import com.example.gadgetguru_accessories.utilities.ApiService;

import java.text.BreakIterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Profile extends Fragment {

    private TextView textViewHeading;
    private TextView textViewStudy;
    private ImageView imageViewProfile;

    public Profile() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Initialize views
        textViewHeading = view.findViewById(R.id.textViewHeading);
//        textViewStudy = view.findViewById(R.id.textView2);
//        imageViewProfile = view.findViewById(R.id.imageprofile);

        // Fetch user details and populate UI
        fetchUserDetails("username_here");

        return view;
    }

    private void fetchUserDetails(String username) {
        // Assuming you have an ApiService to fetch user details based on the username
        ApiService apiService = createApiService();

        apiService.getUserDetails(username).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    User user = response.body();
                    // Populate UI with user details

                    textViewHeading.setText(user.getFullName());
//                    textViewStudy.setText(user.getEmail());
                } else {
                    // Handle unsuccessful response
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                // Handle failure
            }
        });
    }

}
