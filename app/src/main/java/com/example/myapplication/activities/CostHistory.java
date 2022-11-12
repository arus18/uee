package com.example.myapplication.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.myapplication.R;

public class CostHistory extends AppCompatActivity {
    ImageButton alter;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_cost_history );
        alter=(ImageButton)findViewById ( R.id.imageButton2 );
//        ImageButton imgButton= findViewById ( R.id.imageButton2 );
        alter.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick ( View view ) {
                AlertDialog alertDialog = new AlertDialog.Builder ( CostHistory.this ).create ();
                alertDialog.setTitle ( "" );
                alertDialog.setMessage ( "" );
//                alertDialog.setButton ( AlertDialog.BUTTON_NEUTRAL,"Ok" );
                  new DialogInterface.OnClickListener (){
                      @Override
                      public void onClick ( DialogInterface dialog, int which ) {
                          dialog.dismiss();
                      }
                  };
            }
        } );
    }
}