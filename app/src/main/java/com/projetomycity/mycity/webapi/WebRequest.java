package com.projetomycity.mycity.webapi;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by PEDRONI on 09/08/2017.
 */

public class WebRequest extends AsyncTask<String, Integer, String> {

    @Override
    public String doInBackground(String... urls) {
        try {
            URL url = new URL(urls[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String content = "", line;
            while ((line = rd.readLine()) != null) {
                content += line + "\n";
            }
            return content;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

}