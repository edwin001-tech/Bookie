package com.example.bookie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminSignIn extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private Button button;
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_sign_in);

        email = findViewById(R.id.emailAdmin);
        password = findViewById(R.id.idPassword);
    }

    public void adminLogin(View view) {

        String Email = email.getText().toString();
        String Password = password.getText().toString();
        if (Email.length()>0 && Password.length()>0){
            if (Email.equalsIgnoreCase("edwinAdmin@gmail.com")){
                if (Password.equalsIgnoreCase("edwin")){

                    Toast.makeText(getApplicationContext(), "logged in as admin", Toast.LENGTH_SHORT).show();

//                    Intent intent = new Intent(getApplicationContext(), com.example.our_bus.booking_TBL_display.class);
//                    startActivity(intent);
                }
                else
                    Toast.makeText(getApplicationContext(), "Invalid details", Toast.LENGTH_SHORT).show();

            }
        }
    }
}