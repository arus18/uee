package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.myapplication.R;
import com.example.myapplication.network.BiogasEnergyAPICall;

public class CalculateEnergy extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculate_energy);
        Button button = findViewById(R.id.history_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CalculateEnergy.this,History.class);
                startActivity(intent);
            }
        });
        Spinner spinner = findViewById(R.id.group_Spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.group,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemClickListener((AdapterView.OnItemClickListener) new GroupSpinner());
    }
    public class GroupSpinner implements AdapterView.OnItemSelectedListener {


        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            String item = adapterView.getItemAtPosition(i).toString();
            BiogasEnergyAPICall.selectedGroup = item;
            Spinner spinner = findViewById(R.id.type_spinner);
            ArrayAdapter<CharSequence> adapter = null;
            if(item.equals("Vegetables")){
                adapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.Vegetables,android.R.layout.simple_spinner_item);
            }
            if(item.equals("Fat,oil")){
                adapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.Fat_oil,android.R.layout.simple_spinner_item);
            }
            if(item.equals("Animal residues")){
                adapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.Animal_residues,android.R.layout.simple_spinner_item);
            }
            if(item.equals("Food-industry waste")){
                adapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.Food_industry_waste,android.R.layout.simple_spinner_item);
            }
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
            spinner.setOnItemClickListener((AdapterView.OnItemClickListener) new TypeSpinner());
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }

    public class TypeSpinner implements AdapterView.OnItemSelectedListener {


        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            String item = adapterView.getItemAtPosition(i).toString();
            BiogasEnergyAPICall.selectedType = item;
            System.out.println(BiogasEnergyAPICall.selectedGroup);
            System.out.println(BiogasEnergyAPICall.selectedType);
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }
}