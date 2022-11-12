package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.myapplication.R;
import com.example.myapplication.adapters.GarbageAdapter;
import com.example.myapplication.database.EnergyCalculationResultDatabaseHelper;
import com.example.myapplication.model.CollectedGarbage;

import java.util.List;

public class GarbageHistory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.garbage_history);
        ListView listView = findViewById(R.id.garbage_history);
        EnergyCalculationResultDatabaseHelper db = new EnergyCalculationResultDatabaseHelper(this);
        List<CollectedGarbage> list = db.getAllGarbageResults();
        GarbageAdapter adapter = new GarbageAdapter(this,list);
        listView.setAdapter(adapter);
    }
}