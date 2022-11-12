package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.R;

public class UserProfile extends AppCompatActivity {

    TextView tv_userDetails;
    TextView tv_cPwd;
    TextView tv_rPanel;
    TextView tv_logOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile);

        tv_userDetails = findViewById(R.id.tv_userDetails);
        tv_cPwd = findViewById(R.id.tv_cPwd);
        tv_rPanel = findViewById(R.id.tv_rPanel);
        tv_logOut = findViewById(R.id.tv_logOut);

        tv_userDetails.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openUserDetails();
            }
        });

        tv_cPwd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openChangePassword();
            }
        });

        tv_rPanel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openRequestPanel();
            }
        });

//        tv_logOut.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                openCreatePurchaseOder();
//            }
//        });







    }

    public void openUserDetails(){
        Intent intent = new Intent(this, UserDetails.class);
        startActivity(intent);
    }

    public void openChangePassword(){
        Intent intent = new Intent(this, ChangePwd.class);
        startActivity(intent);
    }

    public void openRequestPanel(){
        Intent intent = new Intent(this, CalculatePanelCost.class);
        startActivity(intent);
    }

//    public void openLogin(){
//        Intent intent = new Intent(this, Signin.class);
//        startActivity(intent);
//    }



}