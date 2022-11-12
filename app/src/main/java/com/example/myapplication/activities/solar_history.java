package com.example.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.database.SolarEnergyResultDBHelper;
import com.example.myapplication.model.EnergyCalculationResult;
import com.example.myapplication.model.SolarEnergyResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class solar_history extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.solar_history);

        /*SolarEnergyResultDBHelper db = new SolarEnergyResultDBHelper(this);
        List<SolarEnergyResult> list = db.getAllSolarResults();
        List<String> resultList = new ArrayList<>();
        for(SolarEnergyResult result:list){
            resultList.add(result.getResult());
        }
        ArrayAdapter<String> arr = new ArrayAdapter<String>(
                this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,resultList
        );
        listView.setAdapter(arr);*/

        SolarEnergyResultDBHelper db = new SolarEnergyResultDBHelper(this);

        ArrayList<HashMap<String, String>> calcList = db.getAllSolarResults();
        ListView listView = findViewById(R.id.solar_history_list);
        ListAdapter adapter = new SimpleAdapter(solar_history.this, calcList, R.layout.calc_list,new String[]{"SiteName"}, new int[]{R.id.Sname});
        listView.setAdapter(adapter);

        Button recalc = (Button)findViewById(R.id.recalc);
        Button feedback = (Button)findViewById(R.id.feedback);
        Button clear = (Button)findViewById(R.id.clear);
        recalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(solar_history.this,calculate_solar_energy.class);
                startActivity(intent);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listView.setAdapter(null);
            }
        });

        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(solar_history.this,feedback.class);
                startActivity(intent);
            }
        });



    }
}
