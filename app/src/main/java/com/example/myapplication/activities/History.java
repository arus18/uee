package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication.R;
import com.example.myapplication.adapters.ResultAdapter;
import com.example.myapplication.database.EnergyCalculationResultDatabaseHelper;
import com.example.myapplication.model.EnergyCalculationResult;
import java.util.ArrayList;
import java.util.List;


public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);
        ListView listView = findViewById(R.id.history);
        EnergyCalculationResultDatabaseHelper db = new EnergyCalculationResultDatabaseHelper(this);
        List<EnergyCalculationResult> list = db.getAllEnergyCalculationResults();
        ResultAdapter adapter = new ResultAdapter(this,list);
        listView.setAdapter(adapter);
    }
}