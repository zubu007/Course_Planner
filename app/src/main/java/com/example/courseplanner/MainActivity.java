package com.example.courseplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public Button signupbtn;
    public EditText name, ID;
    public String StudentName;
    public Integer IDNo;
    public Spinner department;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signupbtn = findViewById(R.id.signupbtn);
        name = findViewById(R.id.nameText);
        ID = findViewById(R.id.IdText);
        department = findViewById(R.id.department);

//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.department, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        department.setAdapter(adapter);



        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, CourseListActivity.class);

                if(ID.getText().toString().isEmpty() || name.getText().toString().isEmpty()){
                    Toast toast = Toast.makeText(MainActivity.this, "Please enter ID and Name", Toast.LENGTH_LONG);
                    toast.show();

                }else{
                    StudentName = name.getText().toString();
                    IDNo = Integer.parseInt(ID.getText().toString());
                    startActivity(intent);
                }

            }
        });
    }
}


