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

public class AddCostCalculation extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    EditText editText3;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView (R.layout.activity_add_cost_calculation);
        TextView conTxt = findViewById ( R.id.textView28 );
        Button button = findViewById ( R.id.Costbutton );
        editText1= findViewById ( R.id.editTextNumber );
        editText2 =findViewById ( R.id.editTextNumber2 );
        editText3=findViewById ( R.id.editTextNumber3 );




        conTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( AddCostCalculation.this, CostMoreDetails.class);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View view) {
                float output,area,kg;

                area=Float.parseFloat ( editText1.getText().toString() );
                kg=Float.parseFloat ( editText2.getText().toString() );
                output= (float) (area*4200.00);

                Intent intent = new Intent(AddCostCalculation.this, CostResult.class);


                intent.putExtra("output",output);
                intent.putExtra ( "area",area );
                intent.putExtra ( "kg",kg );


                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Cost Calculated",
                        Toast.LENGTH_SHORT).show();
        }
    });


    }

}