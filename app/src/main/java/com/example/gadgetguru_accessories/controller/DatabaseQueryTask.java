package com.example.gadgetguru_accessories.controller;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DatabaseQueryTask extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... params) {
        String result = "";
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL("http://localhost/api/loginGet.php");
            urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            Log.d("BufferedReader","doInBackground: "+ urlConnection.getInputStream());
            String line;
            while ((line = reader.readLine()) != null) {
                result += line;
            }
        } catch (IOException e) {
            Log.e("DatabaseQueryTask", "Error: " + e.getMessage());
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
                Log.d("TAG", "disconnect");
            }
        }
        return result;
    }

    @Override
    protected void onPostExecute(String result) {
        // Process the result here

        Log.d("DatabaseQueryTask", "Result: " + result);
    }
}
