package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.R;

public class Home extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.home);
        super.onCreate(savedInstanceState);
        CardView cardView = findViewById(R.id.biogas);
        TextView tv_setting = findViewById(R.id.tv_setting);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this,BiogasHome.class);
                startActivity(intent);
            }
        });

        tv_setting.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openUserProfile();
            }
        });



    }

    public void openUserProfile(){
        Intent intent = new Intent(this, UserProfile.class);
        startActivity(intent);
    }
}