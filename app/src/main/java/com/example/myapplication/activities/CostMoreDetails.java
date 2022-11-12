package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

public class CostMoreDetails extends AppCompatActivity {

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_cost_more_details );
        Button button = findViewById ( R.id.ConButton );
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( CostMoreDetails.this, AddCostCalculation.class);
                startActivity(intent);
            }
        });
    }
}