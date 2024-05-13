package com.example.gadgetguru_accessories.view.viewHolder;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.gadgetguru_accessories.R;
import com.example.gadgetguru_accessories.model.Contact;
import com.example.gadgetguru_accessories.utilities.ApiClient;

import org.checkerframework.checker.units.qual.C;

public class ContactFragment extends Fragment {
    private EditText nameEditText;
    private EditText emailEditText;
    private EditText messageEditText;
    private Button sendButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        nameEditText = view.findViewById(R.id.txtName);
        emailEditText = view.findViewById(R.id.txtemail);
        messageEditText = view.findViewById(R.id.txtmessage);
        sendButton = view.findViewById(R.id.SendButton);

        sendButton.setOnClickListener(v -> {
            String fullName = nameEditText.getText().toString();
            String email = emailEditText.getText().toString();
            String message = messageEditText.getText().toString();

            Log.d("ContactFragment", "Full Name: " + fullName);
            Log.d("ContactFragment", "Email: " + email);
            Log.d("ContactFragment", "Message: " + message);
            if (fullName.isEmpty() || email.isEmpty() || message.isEmpty()) {
                Toast.makeText(getActivity(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
            } else {
                Contact contact = new Contact(fullName, email, message);
                Log.d("ContactFra", "Full Name: " + fullName);
                Log.d("ContactFragment", "Email: " + email);
                Log.d("ContactFragment", "Message: " + message);
                contactDetails(contact);
            }
        });

        return view;
    }

    private void contactDetails(Contact contact) {
        ApiClient.contactDetails(contact,getContext());
    }


}