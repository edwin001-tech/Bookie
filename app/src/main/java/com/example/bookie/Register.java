package com.example.bookie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.bookie.Database.USERS.TABLE_NAME;

public class Register extends AppCompatActivity {
    private EditText name;
    private EditText phone;
    private EditText email;
    private EditText password;
    private Button register;
    private TextView login;
    public SQLiteDatabase db;
    public DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

         register = findViewById(R.id.idRegister);
         login = findViewById(R.id.idLogin);

         databaseHelper = new DatabaseHelper(this);


         login.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                 startActivity(intent);
             }
         });

    }

    public void InsertData(View view) {

        db = databaseHelper.getReadableDatabase();

        name = findViewById(R.id.idName);
        phone = findViewById(R.id.idPhone);
        email = findViewById(R.id.idEmail);
        password = findViewById(R.id.idPassword);

        //get input from the EditText views
        String valueName = name.getText().toString();
        String valuePhone = phone.getText().toString();
        String valueEmail = email.getText().toString();
        String valuePassword = password.getText().toString();

        //insert values into the db

        ContentValues values = new ContentValues();
        values.put(Database.USERS.NAME, valueName);
        values.put(Database.USERS.PHONE, valuePhone);
        values.put(Database.USERS.EMAIL, valueEmail);
        values.put(Database.USERS.PASSWORD, valuePassword);

        long newRowId = db.insert(TABLE_NAME, null, values);
        if (newRowId > 0) {
            Toast.makeText(this, "New Record Inserted: ", Toast.LENGTH_SHORT).show();
        }
        db.close();


    }
}