package com.example.myapplication.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class CostCalculationDBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "uee";
    private static final String TABLE_COST_CALCULATION_RESULTS = "energy_calculation_results";
    private static final String KEY_ID = "id";
    private static final String KEY_TYPE = "phone_number";
    private static final String KEY_QUANTITY = "quantity";
    private static final String KEY_RESULT = "result";

    public CostCalculationDBHelper ( @Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version ) {
        super ( context, name, factory, version );
    }

    @Override
    public void onCreate ( SQLiteDatabase sqLiteDatabase ) {

    }

    @Override
    public void onUpgrade ( SQLiteDatabase sqLiteDatabase, int i, int i1 ) {

    }
}

