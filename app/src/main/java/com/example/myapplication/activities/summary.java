package com.example.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.database.SolarEnergyResult;

public class summary extends AppCompatActivity {

    SolarEnergyResult db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.summary_page);

        db = new SolarEnergyResult(this);

        TextView T1=(TextView) findViewById(R.id.Sname);
        TextView T2=(TextView) findViewById(R.id.area);
        TextView T3=(TextView) findViewById(R.id.output);
        TextView T4=(TextView) findViewById(R.id.income);
        TextView T5=(TextView) findViewById(R.id.units);
        Intent intent = getIntent();

        String sname = intent.getStringExtra("Sname");
        Float area = intent.getFloatExtra("area");
        Float output = intent.getFloatExtra("output");
        Float income = intent.getFloatExtra("income");
        Float units = intent.getFloatExtra("units");

        T1.setText(sname);
        T2.setText.(area);
        T3.setText(output);
        T4.setText(income);
        T5.setText(units);
    }
}
