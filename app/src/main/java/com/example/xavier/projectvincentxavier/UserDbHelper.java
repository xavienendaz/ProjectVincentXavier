package com.example.xavier.projectvincentxavier;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Vincent on 27.10.2016.
 */

public class UserDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "PROJECT.DB";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_QUERY =
            "CREATE TABLE "+ DB_Contract.NewUserInfo.TABLE_NAME+"("+ DB_Contract.NewUserInfo.USER_NAME+" TEXT,"+ DB_Contract.NewUserInfo.USER_PASSWORD+" TEXT);";

    public UserDbHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        Log.e("DATABASE OPERATIONS","Database created/opened.");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATIONS","Table created.");
    }

    public void addInfo(String username, String password, SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DB_Contract.NewUserInfo.USER_NAME,username);
        contentValues.put(DB_Contract.NewUserInfo.USER_PASSWORD,password);
        db.insert(DB_Contract.NewUserInfo.TABLE_NAME,null,contentValues);
        Log.e("DATABASE OPERATIONS", "One row inserted");
    }

    //read user info from database
    public Cursor getInfo(SQLiteDatabase db)
    {
        Cursor  cursor;
        String[] projections = {DB_Contract.NewUserInfo.USER_NAME, DB_Contract.NewUserInfo.USER_PASSWORD};
        cursor = db. query(DB_Contract.NewUserInfo.TABLE_NAME,projections,null,null,null,null,null);
        return cursor;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    //get user from database
    public Cursor getUser(String username, SQLiteDatabase sqLiteDatabase){
        String[] projections = {DB_Contract.NewUserInfo.USER_NAME, DB_Contract.NewUserInfo.USER_PASSWORD};
        String selection =  DB_Contract.NewUserInfo.USER_NAME+" LIKE ? ";
        String [] selectionArg = {username};
        Cursor cursor = sqLiteDatabase.query(DB_Contract.NewUserInfo.TABLE_NAME,projections,selection,selectionArg,null,null,null);
        return cursor;
    }



    //delete user from database
    public void deleteUser(String username, SQLiteDatabase sqLiteDatabase)
    {
        String selection =  DB_Contract.NewUserInfo.USER_NAME+" LIKE ? ";
        String [] selectionArg = {username};
        sqLiteDatabase.delete(DB_Contract.NewUserInfo.TABLE_NAME,selection,selectionArg);

    }




}
