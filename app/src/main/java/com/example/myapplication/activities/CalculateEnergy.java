package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.network.BiogasEnergyAPICall;

import org.w3c.dom.Text;

public class CalculateEnergy extends AppCompatActivity{

    ArrayAdapter<CharSequence> typeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculate_energy);
        Button calculate = findViewById(R.id.calculate_button);
        EditText text = findViewById(R.id.input_k);
        ProgressBar progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                BiogasEnergyAPICall.energyResult(text.getText().toString(),view.getContext(),progressBar);
            }
        });
        Spinner spinner = findViewById(R.id.group_Spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.group,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        Spinner typeSpinner = findViewById(R.id.type_spinner);
        typeAdapter = ArrayAdapter.createFromResource(this,R.array.Vegetables,android.R.layout.simple_spinner_item);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(typeAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                BiogasEnergyAPICall.selectedGroup = item;
                if(item.equals("Vegetables")){
                    typeAdapter = ArrayAdapter.createFromResource(view.getContext(),R.array.Vegetables,android.R.layout.simple_spinner_item);
                }
                if(item.equals("Fat,oil")){
                    typeAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.Fat_oil,android.R.layout.simple_spinner_item);
                }
                if(item.equals("Animal residues")){
                    typeAdapter = ArrayAdapter.createFromResource(view.getContext(),R.array.Animal_residues,android.R.layout.simple_spinner_item);
                }
                if(item.equals("Food-industry waste")){
                    typeAdapter = ArrayAdapter.createFromResource(view.getContext(),R.array.Food_industry_waste,android.R.layout.simple_spinner_item);
                }
                typeSpinner.setAdapter(typeAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                BiogasEnergyAPICall.selectedType = item;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}