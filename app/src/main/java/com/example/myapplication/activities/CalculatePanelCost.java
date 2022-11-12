package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

public class CalculatePanelCost extends AppCompatActivity {

    EditText edt_height;
    EditText edt_width;
    TextView tv_cCost;

    Button btn_calculate;
    Button btn_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculate_panel_cost);

        edt_height = findViewById(R.id.edt_height);
        edt_width = findViewById(R.id.edt_width);
        Button button = findViewById(R.id.btn_enter);
        btn_cancel = findViewById(R.id.btn_request);


        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CalculatePanelCost.this, UserProfile.class);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view){
                int output, height, width;

                height = Integer.parseInt(edt_height.getText().toString());
                width = Integer.parseInt(edt_width.getText().toString());
                output = (int) (height * width * 10000);

                Intent intent = new Intent(CalculatePanelCost.this, RequestPanel.class);


                intent.putExtra("height", height);
                intent.putExtra("width", width);
                intent.putExtra("output", output);


                startActivity(intent);

                Toast.makeText(getApplicationContext(),"Panel Cost Calculated!",Toast.LENGTH_SHORT).show();
            }
        });

    }



}

