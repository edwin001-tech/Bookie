package com.example.bookie;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "bookie";

    public static final String CREATE_TABLE_USERS = "CREATE TABLE "
            + Database.USERS.TABLE_NAME + " ("
            + Database.USERS.ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + Database.USERS.USER_NAME + " TEXT NOT NULL,"
            + Database.USERS.EMAIL + " TEXT NOT NULL,"
            + Database.USERS.PHONE + " TEXT NOT NULL,"
            + Database.USERS.PASSWORD + " TEXT NOT NULL)";

    public static final String CREATE_TABLE_APPOINTMENT = "CREATE TABLE "
            + Database.APPOINTMENT.TABLE_NAME + " ("
            + Database.APPOINTMENT.APPOINTMENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + Database.APPOINTMENT.COUNSELOR_NAME + " TEXT NOT NULL,"
            + Database.APPOINTMENT.TIME + " TEXT NOT NULL,"
            + Database.APPOINTMENT.USER_NAME_FK + " TEXT NOT NULL,"
            + Database.APPOINTMENT.TOPIC_NAME_FK + " TEXT NOT NULL,"
            + "FOREIGN KEY(" + Database.APPOINTMENT.USER_NAME_FK + ") REFERENCES USERS(USER_NAME),"
            + "FOREIGN KEY(" +Database.APPOINTMENT.TOPIC_NAME_FK + ") REFERENCES TOPIC(TOPIC_NAME)"
            + ")";

    public static final String CREATE_TABLE_TOPIC = "CREATE TABLE "
            + Database.TOPIC.TABLE_NAME + "( "
            + Database.TOPIC.TOPIC_NAME + " TEXT NOT NULL)";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USERS);
        db.execSQL(CREATE_TABLE_APPOINTMENT);
        db.execSQL(CREATE_TABLE_TOPIC);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
