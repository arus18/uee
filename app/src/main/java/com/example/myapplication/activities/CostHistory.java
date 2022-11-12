package com.example.myapplication.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

public class CostHistory extends AppCompatActivity {
    TextView t1;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {

        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_cost_history );
        ImageButton button = findViewById ( R.id.imageButton3 );
        t1 = (TextView) findViewById(R.id.textView32);
        builder = new AlertDialog.Builder(this);
        Bundle bundle = getIntent().getExtras();

        float output = bundle.getFloat("output");


        t1.setText(String.valueOf("Rs:"+output));

        button.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick ( View view ) {
                builder.setMessage ( R.string.dialog_message ).setTitle ( R.string.dialog_title );

                //Setting message manually and performing action on button click
                builder.setMessage ( "Do you want to remove this calculation ?" )
                        .setCancelable ( false )
                        .setPositiveButton ( "Yes", new DialogInterface.OnClickListener () {
                            public void onClick ( DialogInterface dialog, int id ) {
                                Intent intent = new Intent( CostHistory.this, CostHistory2.class);
                                startActivity(intent);
                                finish ();
                                Toast.makeText ( getApplicationContext (), "Removing Successful!",
                                        Toast.LENGTH_SHORT ).show ();
                            }
                        } )
                        .setNegativeButton ( "No", new DialogInterface.OnClickListener () {
                            public void onClick ( DialogInterface dialog, int id ) {
                                //  Action for 'NO' Button
                                dialog.cancel ();
                                Toast.makeText ( getApplicationContext (), "Staying on the History Page",
                                        Toast.LENGTH_SHORT ).show ();
                            }
                        } );
                //Creating dialog box
                AlertDialog alert = builder.create ();
                //Setting the title manually
                alert.setTitle ( "Alert !!" );
                alert.show ();
            }
        } );
    }
}