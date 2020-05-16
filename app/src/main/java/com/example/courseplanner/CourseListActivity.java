package com.example.courseplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class CourseListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
    }
}
