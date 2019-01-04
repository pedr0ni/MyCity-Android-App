package com.projetomycity.mycity.webapi;

import com.projetomycity.mycity.Manager;
import com.projetomycity.mycity.modules.CityUser;
import com.projetomycity.mycity.modules.PostModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by PEDRONI on 09/08/2017.
 */

public class WebManager {

    public boolean requestResponse() {
        String response = new WebRequest().doInBackground(new String[] {WebApp.INIT_URL});
        boolean res = false;
        try {
            JSONObject obj = new JSONObject(response);
            res = obj.getBoolean("result");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return res;

    }

    public CityUser login(String email, String senha) {

        String response = new WebRequest().doInBackground(new String[] {WebApp.getURL("login?email="+email+"&senha="+senha)});
        try {
            JSONObject obj = new JSONObject(response);
            if (!obj.getBoolean("result")) {
                return null;
            }
            return new CityUser(obj.getInt("id"), obj.getString("user"), obj.getString("email"), obj.getString("nome"), obj.getString("bio"),
                    obj.getString("cidade"), obj.getInt("nascimento"), obj.getString("telefone"), obj.getString("twitter"), obj.getString("facebook"),
                    obj.getString("grupo"), obj.getInt("verified"), obj.getString("icon"), obj.getInt("lastupdate"));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;

    }

    public JSONObject loadProfile(int user_id) {
        String response = new WebRequest().doInBackground(new String[] {WebApp.getURL("profile?uid="+user_id)});
        try {
            return new JSONObject(response);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<PostModel> getPosts() {
        ArrayList<PostModel> res = new ArrayList<>();
        String response = new WebRequest().doInBackground(new String[] {WebApp.getURL("posts?ssid=1")});
        try {
            JSONObject obj = new JSONObject(response);
            JSONArray posts = obj.getJSONArray("posts");
            for (int i = 0; i < posts.length(); i++) {
                JSONObject post = posts.getJSONObject(i);
                res.add(new PostModel(post.getString("username"), post.getString("userurl"), post.getString("content"), post.getString("time"), post.getString("usericon")));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return res;
    }


}
