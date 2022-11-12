package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

public class UserDetails extends AppCompatActivity {

    ImageView iv_profile;

    Button btn_save;
    Button btn_cancel;

   TextView tv_userName;
   TextView tv_email;

   EditText edt_userName;
   EditText edt_address;
   EditText edt_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.user_details);
        super.onCreate(savedInstanceState);

        tv_userName = findViewById(R.id.tv_userName);
        tv_email = findViewById(R.id.tv_email);
        edt_userName = findViewById(R.id.edt_userName);
        edt_address =findViewById(R.id.edt_address);
        edt_number = findViewById(R.id.edt_number);
        btn_save = findViewById(R.id.btn_save);
        btn_cancel = findViewById(R.id.btn_request);
        iv_profile = findViewById(R.id.iv_profile);


        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserDetails.this,UserProfile.class);
                startActivity(intent);
            }
        });


        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserDetails.this,UserProfile.class);
                startActivity(intent);
            }
        });



    }
}