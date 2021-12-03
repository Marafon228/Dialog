package com.example.dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCloseButtonClick(View view) {

        String[] mIngrediends = {"Томаты" , "Курица", "Шампиньоны" , "Маслины"};

        final boolean[] mSelectedIngrediends = {false, false, false, false};
        
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Выберите ингридиенты для своей пиццы")
                .setIcon(R.drawable.ic_launcher_foreground)

                .setCancelable(false)
                .setMultiChoiceItems(mIngrediends, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        mSelectedIngrediends[which] = isChecked;
                    }
                })
                .setPositiveButton("ОК",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        }
                )
                .setNegativeButton("Отмена",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        }
                );
        AlertDialog alert = builder.create();
        alert.show();
    }
}