package com.example.myapplication.database;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.myapplication.model.CollectedGarbage;
import com.example.myapplication.model.EnergyCalculationResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EnergyCalculationResultDatabaseHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "uee";
    private static final String TABLE_ENERGY_CALCULATION_RESULTS = "cost_calculation_results";
    private static final String KEY_ID = "id";
    private static final String KEY_GROUP = "group_g";
    private static final String KEY_TYPE = "phone_number";
    private static final String KEY_QUANTITY = "quantity";
    private static final String KEY_RESULT = "result";
    private static final String TABLE_GARBAGE_RESULTS = "garbage_collection";
    private static final String KEY_START_DATE = "start_date";
    private static final String KEY_END_DATE = "end_date";
    private static final String COLLECTED_GARBAGE = "collected_garbage";
    private static final String TABLE_SOLAR_ENERGY_RESULT = "solar_energy_results";

    public static final String COL_1 = "SiteName";

    public EnergyCalculationResultDatabaseHelper(@Nullable Context context) {
        super(context,DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_ENERGY_CALCULATION_RESULTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_GROUP + " TEXT,"
                + KEY_TYPE + " TEXT," + KEY_QUANTITY + " INTEGER," + KEY_RESULT + " TEXT" +")";
        String CREATE_GARBAGE_TABLE = "CREATE TABLE " + TABLE_GARBAGE_RESULTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_START_DATE + " TEXT,"
                + KEY_END_DATE + " TEXT," + COLLECTED_GARBAGE + " INTEGER" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
        db.execSQL(CREATE_GARBAGE_TABLE);
        db.execSQL("CREATE TABLE solar_energy_results(SiteName TEXT, Area REAL, Output REAL,Units REAL,Income REAL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ENERGY_CALCULATION_RESULTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GARBAGE_RESULTS);
        db.execSQL("drop Table if exists solar_energy_results");
    }


    public long addEnergyResult(EnergyCalculationResult result) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_GROUP, result.getGroup()); // Contact Name
        values.put(KEY_TYPE, result.getType()); // Contact Phone
        values.put(KEY_QUANTITY,result.getQuantity());
        values.put(KEY_RESULT,result.getResult());
        long l = db.insert(TABLE_ENERGY_CALCULATION_RESULTS, null, values);
        db.close();
        return l;
    }


    public List<EnergyCalculationResult> getAllEnergyCalculationResults() {

        List<EnergyCalculationResult> energyCalculationResults = new ArrayList<EnergyCalculationResult>();
        String selectQuery = "SELECT  * FROM " + TABLE_ENERGY_CALCULATION_RESULTS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                EnergyCalculationResult energyCalculationResult = new EnergyCalculationResult();
                energyCalculationResult.setId(Integer.parseInt(cursor.getString(0)));
                energyCalculationResult.setGroup(cursor.getString(1));
                energyCalculationResult.setType(cursor.getString(2));
                energyCalculationResult.setResult(cursor.getString(3));
                energyCalculationResults.add(energyCalculationResult);
            } while (cursor.moveToNext());
        }
        return energyCalculationResults;
    }


    public void deleteResult(EnergyCalculationResult result) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ENERGY_CALCULATION_RESULTS, KEY_ID + " = ?",
                new String[] { String.valueOf(result.getId()) });
        db.close();
    }
    public long addGarbage(CollectedGarbage garbage) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_START_DATE, garbage.getStartDate()); // Contact Name
        values.put(KEY_END_DATE,garbage.getEndDate()); // Contact Phone
        values.put(COLLECTED_GARBAGE,garbage.getSize());
        long l = db.insert(TABLE_GARBAGE_RESULTS, null, values);
        db.close();
        return l;
    }


    public List<CollectedGarbage> getAllGarbageResults() {

        List<CollectedGarbage> collectedGarbages = new ArrayList<CollectedGarbage>();
        String selectQuery = "SELECT  * FROM " + TABLE_GARBAGE_RESULTS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                CollectedGarbage collectedGarbage = new CollectedGarbage();
                collectedGarbage.setId(Integer.parseInt(cursor.getString(0)));
                collectedGarbage.setStartDate(cursor.getString(1));
                collectedGarbage.setEndDate(cursor.getString(2));
                collectedGarbage.setSize(cursor.getInt(3));
                collectedGarbages.add(collectedGarbage);
            } while (cursor.moveToNext());
        }
        return collectedGarbages;
    }


    public void deleteResult(CollectedGarbage garbage) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_GARBAGE_RESULTS, KEY_ID + " = ?",
                new String[] { String.valueOf(garbage.getId()) });
        db.close();
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
