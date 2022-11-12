package com.example.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.database.SolarEnergyResultDBHelper;
import com.example.myapplication.network.BiogasEnergyAPICall;

public class summary extends AppCompatActivity {

    SolarEnergyResultDBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.summary_page);



        db = new SolarEnergyResultDBHelper(this);

        TextView T1=(TextView) findViewById(R.id.Sname);
        TextView T2=(TextView) findViewById(R.id.area);
        TextView T3=(TextView) findViewById(R.id.output);
        TextView T5=(TextView) findViewById(R.id.income);
        TextView T4=(TextView) findViewById(R.id.units);
        
        Bundle bundle = getIntent().getExtras();

        /*Bundle bundle = getIntent().getExtras();
        //float yourFloat = bundle.getFloat("key");

        String sname = intent.getStringExtra("Sname");
        float area = intent.getFloatExtra("area");
        Float output = intent.getFloatExtra("output");
        Float income = intent.getFloatExtra("income");
        Float units = intent.getFloatExtra("units");*/

        String sname = bundle.getString("Sname");
        float area = bundle.getFloat("area");
        float output = bundle.getFloat("output");
        float income = bundle.getFloat("income");
        float units = bundle.getFloat("units");

        T1.setText(sname);
        T2.setText(String.valueOf(area));
        T3.setText(String.valueOf(output));
        T4.setText(String.valueOf(units));
        T5.setText(String.valueOf(income));


        /*T2.setText((int) area);
        T3.setText((int) output);
        T4.setText((int) income);
        T5.setText((int) units);*/

        Button history= findViewById(R.id.history);
        Button recalc=findViewById(R.id.recalc);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(summary.this,solar_history.class);
                startActivity(intent);
            }
        });

        recalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(summary.this,calculate_solar_energy.class);
                startActivity(intent);
            }
        });
    }
}
