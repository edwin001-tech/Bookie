package com.example.bookie;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private TextView register;
    private TextView loginAdmin;
    private Button login;
    private SQLiteDatabase db;
    private DatabaseHelper databaseHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
        db = databaseHelper.getReadableDatabase();

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register);
        loginAdmin = findViewById(R.id.loginAdmin);
        login = findViewById(R.id.login);


    }

    public void login(View view){
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        db = databaseHelper.getReadableDatabase();

    }
}