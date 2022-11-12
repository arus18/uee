package com.example.myapplication.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.myapplication.R;
import com.example.myapplication.database.EnergyCalculationResultDatabaseHelper;
import com.example.myapplication.model.EnergyCalculationResult;
import com.example.myapplication.network.BiogasEnergyAPICall;

public class Result extends AppCompatActivity {

    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);
        EnergyCalculationResultDatabaseHelper db = new EnergyCalculationResultDatabaseHelper(this);
        TextView textView = findViewById(R.id.results);
        Intent intent = getIntent();
        String str = intent.getStringExtra("result");
        textView.setText(str+"m^3");
        Button button = findViewById(R.id.save);
        Button history = findViewById(R.id.history_b);
        builder = new AlertDialog.Builder(this);
        builder.setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert = builder.create();
        alert.setTitle("Saved successfully");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long l = db.addEnergyResult(new EnergyCalculationResult(BiogasEnergyAPICall.selectedGroup,BiogasEnergyAPICall.selectedType,Integer.parseInt(BiogasEnergyAPICall.QUANTITY),str));
                alert.show();
            }
        });
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(view.getContext(),History.class);
                startActivity(intent1);
            }
        });
    }
}