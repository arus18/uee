package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;

public class ChangePwd extends AppCompatActivity {


    Button btn_save;
    Button btn_cancel;

    EditText etp_currentPwd;
    EditText etp_newPwd;
    EditText etp_rePwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.change_pwd);
        super.onCreate(savedInstanceState);

        etp_currentPwd = findViewById(R.id.etp_currentPwd);
        etp_newPwd = findViewById(R.id.etp_newPwd);
        etp_rePwd = findViewById(R.id.etp_rePwd);
        btn_save = findViewById(R.id.btn_save);
        btn_cancel = findViewById(R.id.btn_request);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChangePwd.this,UserProfile.class);
                startActivity(intent);
            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChangePwd.this,UserProfile.class);
                startActivity(intent);
            }
        });

    }
}