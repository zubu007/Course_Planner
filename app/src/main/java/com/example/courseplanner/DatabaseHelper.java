package com.example.courseplanner;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Course_Planner_Database";
    private static final String EEE_Table = "EEE_Courses";
    private static final String CSE_Table = "CSE_Courses";
    private static final String BBA_Table = "BBA_Courses";
    private static final String ARC_Table = "ARC_Courses";

    private Context context;

    public DatabaseHelper(@Nullable Context context) {

        super(context, DATABASE_NAME, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //creating tables
        try {
            Toast.makeText(context, "OnCreate method is run.", Toast.LENGTH_LONG).show();
            String EEEtable = "CREATE TABLE "+EEE_Table+" (id INTEGER PRIMARY KEY, Course_name TEXT, Credit REAL, Type TEXT);";
            String CSEtable = "CREATE TABLE "+CSE_Table+" (id INTEGER PRIMARY KEY, Course_name TEXT, Credit REAL, Type TEXT);";
            String BBAtable = "CREATE TABLE "+BBA_Table+" (id INTEGER PRIMARY KEY, Course_name TEXT, Credit REAL, Type TEXT);";
            String ARCtable = "CREATE TABLE "+ARC_Table+" (id INTEGER PRIMARY KEY, Course_name TEXT, Credit REAL, Type TEXT);";
            db.execSQL(EEEtable);
            db.execSQL(CSEtable);
            db.execSQL(BBAtable);
            db.execSQL(ARCtable);
        }catch (Exception e){
            Toast.makeText(context, "Exception: "+ e, Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //drop existing table
        try {
            Toast.makeText(context, "OnUngrade method is called", Toast.LENGTH_LONG).show();
            db.execSQL("DROP TABLE IF EXISTS "+ EEE_Table);
            db.execSQL("DROP TABLE IF EXISTS "+ CSE_Table);
            db.execSQL("DROP TABLE IF EXISTS "+ BBA_Table);
            db.execSQL("DROP TABLE IF EXISTS "+ ARC_Table);
            onCreate(db);
        }catch (Exception e){
            Toast.makeText(context, "Exception: "+ e, Toast.LENGTH_LONG).show();
        }

    }
}
