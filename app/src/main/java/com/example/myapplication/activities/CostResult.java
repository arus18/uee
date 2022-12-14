package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

import org.w3c.dom.Text;

public class CostResult extends AppCompatActivity {
    TextView t1;
    EditText t2;
    EditText t3;
//    int max = 5000;
//    int min = 1000;
//    // create instance of Random class
//    Random randomNum = new Random();
//    int showMe = min + randomNum.nextInt(max);
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_cost_result );
        TextView conTxt4 = findViewById ( R.id.textView26 );
        TextView conTxt5 = findViewById ( R.id.textView27 );
        t1 = (TextView) findViewById(R.id.textView23);
        t2=(EditText) findViewById ( R.id.editTextTextPersonName );
        t3=(EditText) findViewById ( R.id.editTextTextPersonName2 );

//        t1.setText(Integer.toString(showMe));


        Bundle bundle = getIntent().getExtras();

        float output = bundle.getFloat("output");
        float area = bundle.getFloat("area");
        float kg = bundle.getFloat("kg");

        t1.setText(String.valueOf(output));
        t2.setText ( String.valueOf (area));
        t3.setText ( String.valueOf (kg));



        conTxt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( CostResult.this, AddCostCalculation.class);
                startActivity(intent);
            }
        });
        conTxt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( CostResult.this, CostHistory.class);

                intent.putExtra("output",output);
                startActivity(intent);
            }
        });
    }
}