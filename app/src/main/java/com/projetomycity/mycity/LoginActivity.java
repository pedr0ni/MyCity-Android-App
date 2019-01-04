package com.projetomycity.mycity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.projetomycity.mycity.modules.CityUser;
import com.projetomycity.mycity.webapi.WebManager;

public class LoginActivity extends AppCompatActivity {

    WebManager wmanager = new WebManager();

    Button btn_login;
    EditText edit_email;
    EditText edit_senha;
    CheckBox lembrar_me;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        final SharedPreferences pref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

        btn_login = (Button) findViewById(R.id.btn_login);
        edit_email = (EditText) findViewById(R.id.edit_email);
        edit_senha = (EditText) findViewById(R.id.edit_senha);
        lembrar_me = (CheckBox) findViewById(R.id.lembrar_me);

        if (pref.getString("email", "") != null && pref.getString("senha", "") != null) {
            edit_email.setText(pref.getString("email", ""));
            edit_senha.setText(pref.getString("senha", ""));
            lembrar_me.setChecked(true);
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                if (!wmanager.requestResponse()) {
                    btn_login.setEnabled(false);
                    Manager.showDialog2(LoginActivity.this, getResources().getString(R.string.erro_load), "TENTAR NOVAMENTE", "SAIR");
                }
            }
        }).start();

        btn_login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (edit_email.getText().toString() == "" || edit_senha.getText().toString() == "") {
                    Manager.showDialog(LoginActivity.this, getResources().getString(R.string.preencher_todos), "OK");
                    return;
                }

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        CityUser login_result = wmanager.login(edit_email.getText().toString(), edit_senha.getText().toString());
                        if (login_result == null) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Manager.showDialog(LoginActivity.this, getResources().getString(R.string.email_senha_incorretos), "OK");
                                }
                            });
                            return;
                        }
                        Manager.logged_user = login_result;
                        SharedPreferences.Editor editor = pref.edit();
                        if (lembrar_me.isChecked()) {
                            editor.putString("email", edit_email.getText().toString());
                            editor.putString("senha", edit_senha.getText().toString());

                        } else {
                            if (pref.getString("email", "") != null && pref.getString("senha", "") != null) {
                                editor.remove("email");
                                editor.remove("senha");
                            }
                        }
                        editor.apply();
                        Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(i);
                        LoginActivity.this.finish();
                    }
                }).start();

            }
        });

    }
}
