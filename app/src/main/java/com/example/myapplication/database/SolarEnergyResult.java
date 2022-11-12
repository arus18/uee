package com.example.myapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.myapplication.model.EnergyCalculationResult;

public class SolarEnergyResult extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "uee";
    private static final String TABLE_SOLAR_ENERGY_RESULT = "solar_energy_results";

    public static final String COL_1 = "SiteName";
    public static final String COL_2 = "Area";
    public static final String COL_3 = "Output";
    public static final String COL_4 = "Units";
    public static final String COL_5 = "Income";


    public SolarEnergyResult(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table solar_energy_results(SiteName TEXT, Area REAL, Output REAL,Units REAL,Income REAL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop Table if exists solar_energy_results");
    }

    public boolean addResult(String SiteName,Float Area,Float Output,Float Units,Float Income) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("SiteName",SiteName);
        values.put("Area",Area);
        values.put("Output",Output);
        values.put("Units",Units);
        values.put("Income",Income);
        long result=db.insert("solar_energy_results",null,values);
        if(result==-1){
            return false;
        }else {
            return true;
        }
    }

    public Cursor getResult(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from solar_energy_results", null);
        return cursor;
    }
}
