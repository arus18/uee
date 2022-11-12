package com.example.myapplication.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.example.myapplication.model.SolarEnergyResult;

public class SolarEnergyResultDBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "uee";
    private static final String TABLE_SOLAR_ENERGY_RESULT = "solar_energy_results";

    public static final String COL_1 = "SiteName";
    public static final String COL_2 = "Area";
    public static final String COL_3 = "Output";
    public static final String COL_4 = "Units";
    public static final String COL_5 = "Income";


    public SolarEnergyResultDBHelper(Context context) {
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

    /*public Cursor getResult(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from solar_energy_results", null);
        return cursor;
    }

    /*public List<SolarEnergyResult> getAllSolarResults() {

        List<SolarEnergyResult> SolarEnergyCalculationResults = new ArrayList<SolarEnergyResult>();
        String selectQuery = "SELECT  * FROM " + TABLE_SOLAR_ENERGY_RESULT;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                SolarEnergyResult SolarEnergyCalculationResult = new SolarEnergyResult();
                SolarEnergyCalculationResult.setSname(cursor.getString(0));
                SolarEnergyCalculationResult.setArea(Float.parseFloat(cursor.getString(1)));
                SolarEnergyCalculationResult.setOutput(Float.parseFloat(cursor.getString(2)));
                SolarEnergyCalculationResult.setUnits(Float.parseFloat(cursor.getString(3)));
                SolarEnergyCalculationResult.setIncome(Float.parseFloat(cursor.getString(4)));
                SolarEnergyCalculationResults.add(SolarEnergyCalculationResult);
            } while (cursor.moveToNext());
        }
        return SolarEnergyCalculationResults;
    }*/



    @SuppressLint("Range")
    public ArrayList<HashMap<String, String>> getAllSolarResults(){
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> calcList = new ArrayList<>();
        String query = "SELECT SiteName FROM "+ TABLE_SOLAR_ENERGY_RESULT;
        Cursor cursor = db.rawQuery(query,null);
        while (cursor.moveToNext()){
            HashMap<String,String> calc = new HashMap<>();
            calc.put("SiteName", cursor.getString(cursor.getColumnIndex(COL_1)));
            calcList.add(calc);
        }
        return  calcList;
    }
}
