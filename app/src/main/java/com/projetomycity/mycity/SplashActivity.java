package com.projetomycity.mycity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.projetomycity.mycity.webapi.WebManager;

public class SplashActivity extends AppCompatActivity {

    private boolean toLogin = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        final SharedPreferences pref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

        if (pref.getString("email", "") != null && pref.getString("email", "") != "" && pref.getString("senha", "") != null && pref.getString("senha", "") != "") {
           new Thread(new Runnable() {
               @Override
               public void run() {
                   String email = pref.getString("email", "");
                   String senha = pref.getString("senha", "");
                   Manager.logged_user = new WebManager().login(email, senha);
                   toLogin = false;
               }
           }).start();
        }

        Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = null;
                if (toLogin) {
                    i = new Intent(SplashActivity.this, LoginActivity.class);
                } else {
                    i = new Intent(SplashActivity.this, HomeActivity.class);
                }
                startActivity(i);
                SplashActivity.this.finish();
            }
        }, 2500);


    }
}
