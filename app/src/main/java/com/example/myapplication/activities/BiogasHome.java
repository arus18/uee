package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.myapplication.R;

public class BiogasHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.biogas_home);
        CardView cardView = findViewById(R.id.energy);
        CardView garbage = findViewById(R.id.garbage);
        ImageView energyHistory = findViewById(R.id.energy_history_icon);
        ImageView garbageHistory = findViewById(R.id.garbage_history_icon);
        energyHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),History.class);
                startActivity(intent);
            }
        });
        garbageHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),GarbageHistory.class);
                startActivity(intent);
            }
        });
        garbage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BiogasHome.this,AddGarbage.class);
                startActivity(intent);
            }
        });
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BiogasHome.this,CalculateEnergy.class);
                startActivity(intent);
            }
        });
    }
}