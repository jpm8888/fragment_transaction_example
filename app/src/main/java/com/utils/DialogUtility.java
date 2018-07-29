package com.utils;


import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;


public class DialogUtility {


    public static void showDialog(String mTitle, String mDescription, Context context) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(mTitle);
        alertDialog.setMessage(mDescription);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}
