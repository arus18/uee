package com.example.myapplication.database;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.myapplication.model.EnergyCalculationResult;

import java.util.ArrayList;
import java.util.List;

public class EnergyCalculationResultDatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "uee";
    private static final String TABLE_ENERGY_CALCULATION_RESULTS = "energy_calculation_results";
    private static final String KEY_ID = "id";
    private static final String KEY_GROUP = "group_g";
    private static final String KEY_TYPE = "phone_number";
    private static final String KEY_QUANTITY = "quantity";
    private static final String KEY_RESULT = "result";

    public EnergyCalculationResultDatabaseHelper(@Nullable Context context) {
        super(context,DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_ENERGY_CALCULATION_RESULTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_GROUP + " TEXT,"
                + KEY_TYPE + " TEXT," + KEY_QUANTITY + " INTEGER," + KEY_RESULT + " TEXT" +")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ENERGY_CALCULATION_RESULTS);
        onCreate(db);
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
                System.out.println(cursor.getString(1));
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


}
