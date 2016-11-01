package com.example.xavier.projectvincentxavier;

import android.provider.BaseColumns;

/**
 * Created by Vincent on 27.10.2016.
 */

public class DB_Contract {

    public static abstract class NewUserInfo implements BaseColumns
    {
        public static final String TABLE_NAME = "user_info";
        public static final String USER_NAME = "user_name";
        public static final String USER_PASSWORD = "user_password";
    }


    public static abstract class NewQuestion implements BaseColumns
    {
        public static final String TABLE_NAME = "question";
        public static final String TOPIC = "topic";
        public static final String TITLE = "title";
        public static final String CONTENT = "content";
        public static final String USERNAME = "content";
    }



}
