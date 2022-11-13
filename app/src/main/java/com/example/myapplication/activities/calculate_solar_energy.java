package com.example.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.database.EnergyCalculationResultDatabaseHelper;


public class calculate_solar_energy extends AppCompatActivity{
    EnergyCalculationResultDatabaseHelper db;
    EditText SiteName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        db=new EnergyCalculationResultDatabaseHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculate_solar_energy);
        Button button = findViewById(R.id.btncalc);
        SiteName = findViewById(R.id.Sname);
        EditText e1=(EditText) findViewById(R.id.length);
        EditText e2=(EditText) findViewById(R.id.breadth);
        Spinner spinnerType = findViewById(R.id.area_type);
        Spinner spinnerMessure = findViewById(R.id.measure_type);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String SName=SiteName.getText().toString();
                //String SType=spinnerType.getText().toString();
                //calcEnergy();

                float len,width,output,income,units,area;

                len = Float.parseFloat(e1.getText().toString());
                width = Float.parseFloat(e2.getText().toString());

                area=len*width;

                output= (float) (area*2.14);
                units=100*(area/8);
                income=units*22;

                boolean b=db.addResult(SName,area,output,units,income);
                System.out.println(b);


                Intent intent = new Intent(calculate_solar_energy.this, summary.class);
                intent.putExtra("Sname",SName);
                intent.putExtra("area",area);
                intent.putExtra("output",output);
                intent.putExtra("units",units);
                intent.putExtra("income",income);



                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Energy Calculated",
                        Toast.LENGTH_SHORT).show();

            }
        });


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerType.setAdapter(adapter);



        ArrayAdapter<CharSequence> adapterM = ArrayAdapter.createFromResource(this, R.array.messure, android.R.layout.simple_spinner_item);
        adapterM.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMessure.setAdapter(adapterM);
    }
}

