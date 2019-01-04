package com.projetomycity.mycity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;

import com.projetomycity.mycity.modules.CityUser;

/**
 * Created by PEDRONI on 13/08/2017.
 */

public class Manager extends AppCompatActivity {

    public static CityUser logged_user;

    public static AlertDialog showDialog(Context c, String message, String positive) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(c);
        builder1.setMessage(message);
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                positive,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();

        return alert11;
    }

    public static AlertDialog showDialog2(Context c, String message, String positive, String negative) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(c);
        builder1.setMessage(message);
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                positive,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        builder1.setNegativeButton(
                negative,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();

        return alert11;
    }



}
