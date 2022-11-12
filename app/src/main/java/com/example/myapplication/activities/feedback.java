package com.example.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class feedback extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback);

        EditText e1=(EditText) findViewById(R.id.enterFeed);
        Button button = findViewById(R.id.submitFeed);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(feedback.this,thank.class);
                startActivity(intent);
            }
        });

        RatingBar RatingBar = (RatingBar) findViewById(R.id.rating);
        Float ratingNumber = RatingBar.getRating();
    }

}
