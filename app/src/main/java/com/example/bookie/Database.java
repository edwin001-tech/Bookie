package com.example.bookie;

import android.provider.BaseColumns;

public class Database {

    public Database() {
    }
    public static abstract class USERS implements BaseColumns{
        public static final String TABLE_NAME="USERS";
        public static final String ID="USER_ID";
        public static final String NAME="NAME";
        public static final String EMAIL="EMAIL";
        public static final String PHONE="PHONE";
        public static final String PASSWORD="PASSWORD";
    }

    public static abstract class APPOINTMENT implements BaseColumns{
        public static final String TABLE_NAME="APPOINTMENT";
        public static final String APPOINTMENT_ID="APPOINTMENT_ID";
        public static final String USER_ID_FK="USER_NAME_FK";
        public static final String TOPIC_NAME="TOPIC_NAME_FK";
        public static final String COUNSELOR_NAME="COUNSELOR_NAME";
        public static final String TIME="TIME";
    }

    public static abstract class TOPIC implements BaseColumns{
        public static final String TABLE_NAME="TOPIC";
        public static final String TOPIC_NAME="TOPIC_NAME";
    }


}
