package com.example.yasina.langapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;



public class RegistrationActivity extends ActionBarActivity {

    private final int add_langs_conection = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ibAddLanguages:
                showDialog(add_langs_conection);
                break;
            case R.id.ibShowPassword:

                break;
            case R.id.btnSingIn:

                break;
            default:
                break;
        }
    }


    @Override
    protected Dialog onCreateDialog(int id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        switch (id) {

            case add_langs_conection:
                final boolean[] mCheckedItems = {false, true, false};
                final String[] checkLangsName = {"English", "Русский", "Francais","Espanol","Japanese","Arabian"};
                builder = new AlertDialog.Builder(this);
                builder.setTitle("Choose Languages")
                        .setCancelable(false)
                        .setMultiChoiceItems(checkLangsName, mCheckedItems,
                                new DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int which, boolean isChecked) {
                                        mCheckedItems[which] = isChecked;
                                    }
                                })
                        .setPositiveButton("Ok",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int id) {
                                        StringBuilder state = new StringBuilder();
                                        for (int i = 0; i < checkLangsName.length; i++) {
                                            state.append("" + checkLangsName[i]);
                                            if (mCheckedItems[i])
                                                state.append(" Choosed\n");
                                            //else
                                                //state.append(" не выбран\n");
                                        }
                                        Toast.makeText(getApplicationContext(),
                                                state.toString(), Toast.LENGTH_LONG)
                                                .show();
                                    }
                                })

                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int id) {
                                        dialog.cancel();

                                    }
                                });
                return builder.create();

            default:
                return null;
        }
    }

}
