package com.example.bookie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

        loginAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdminSignIn.class);
                startActivity(intent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Register.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = findViewById(R.id.email);
                password = findViewById(R.id.password);

                db = databaseHelper.getReadableDatabase();

                final String[] columns = {Database.USERS.USER_NAME, Database.USERS.EMAIL, Database.USERS.PASSWORD, Database.USERS.PHONE};
                Cursor c = db.query(Database.USERS.TABLE_NAME, null, null, null, null, null, null);
                while (c.moveToNext()) ;
                {
                    String user_id = c.getString(c.getColumnIndex(Database.USERS.ID));
                    String user_name = c.getString(c.getColumnIndex(Database.USERS.USER_NAME));

                    String user_email = c.getString(1);
                    String user_password = c.getString(2);
                    if (user_email.equalsIgnoreCase(email.getText().toString()) && user_password.equalsIgnoreCase(password.getText().toString())) {

                        Toast.makeText(getApplicationContext(), "logged in", Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(getApplicationContext(), Details.class);
                        intent.putExtra("USER ID", user_id);
                        intent.putExtra("USER NAME", user_name);
                        startActivity(intent);
                    } else
                        Toast.makeText(getApplicationContext(), "Wrong Email or Password", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }



//    public void login(View view) {
//        email = findViewById(R.id.email);
//        password = findViewById(R.id.password);
//
//        db = databaseHelper.getReadableDatabase();
//
//        final String[] columns = {Database.USERS.USER_NAME, Database.USERS.EMAIL, Database.USERS.PASSWORD, Database.USERS.PHONE};
//        Cursor c = db.query(Database.USERS.TABLE_NAME, null, null, null, null, null, null);
//        while (c.moveToNext()) ;
//        {
//            String user_id = c.getString(c.getColumnIndex(Database.USERS.ID));
//            String user_name = c.getString(c.getColumnIndex(Database.USERS.USER_NAME));
//            String user_email = c.getString(2);
//            String user_password = c.getString(3);
//            if (user_email.equalsIgnoreCase(email.getText().toString()) && user_password.equalsIgnoreCase(password.getText().toString())) {
//
//                Toast.makeText(getApplicationContext(), "logged in", Toast.LENGTH_LONG).show();
//
//                Intent intent = new Intent(getApplicationContext(), Details.class);
//                intent.putExtra("USER ID", user_id);
//                intent.putExtra("USER NAME", user_name);
//                startActivity(intent);
//            } else
//                Toast.makeText(getApplicationContext(), "Wrong Email or Password", Toast.LENGTH_SHORT).show();
//        }
//    }
    }
