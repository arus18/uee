package com.example.myapplication.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

public class RequestPanel extends AppCompatActivity {

    Button btn_cancel;
    Button btn_request;

    EditText edt_height;
    EditText edt_width;
    TextView tv_cCost;

    AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.request_panel);
        super.onCreate(savedInstanceState);

        edt_height = findViewById(R.id.edt_height);
        edt_width = findViewById(R.id.edt_width);
        tv_cCost = findViewById(R.id.tv_cCost);
        btn_request = findViewById(R.id.btn_request);
        btn_cancel = findViewById(R.id.btn_cancel);
        builder = new AlertDialog.Builder(this);


      Bundle bundle = getIntent().getExtras();

      int output =bundle.getInt("output");
      int height =bundle.getInt("height");
      int width =bundle.getInt("width");


      tv_cCost.setText(String.valueOf(output));
      edt_height.setText(String.valueOf(height));
      edt_width.setText(String.valueOf(width));



        btn_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RequestPanel.this,PanelRequest.class);
                startActivity(intent);
            }
        });


        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setMessage(R.string.dialog_message).setTitle(R.string.dialog_title);

                //Setting message manually and performing action on button click
                builder.setMessage("Do you want to cancel the request ?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(RequestPanel.this,UserProfile.class);
                                startActivity(intent);
                                finish();
                                Toast.makeText(getApplicationContext(), " Requesting cancelled ! ",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(), "Staying on the Request Panel Page",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                //Creating dialog box
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("Thank you for Requesting");
                alert.show();

            }
        });



    }



}