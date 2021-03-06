package com.example.xavier.projectvincentxavier;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Vincent on 27.10.2016.
 */

public class UserDbHelper extends SQLiteOpenHelper {

    public SQLiteDatabase db;

    private static final String DATABASE_NAME = "PROJECT.DB";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_QUERY_TBL_USER =
            "CREATE TABLE "+ DB_Contract.NewUserInfo.TABLE_NAME+"("+ DB_Contract.NewUserInfo.USER_NAME+" TEXT,"
                    + DB_Contract.NewUserInfo.USER_PASSWORD+" TEXT);";

    private static final String CREATE_QUERY_TBL_QUESTIONS =
            "CREATE TABLE "+ DB_Contract.NewQuestion.TABLE_NAME+"("+ DB_Contract.NewQuestion.TOPIC+" TEXT,"
                    + DB_Contract.NewQuestion.TITLE+" TEXT,"
                    + DB_Contract.NewQuestion.CONTENT+" TEXT,"
                    + DB_Contract.NewQuestion.USERNAME+" TEXT);";


    public UserDbHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        Log.e("DATABASE OPERATIONS","Database created/opened.");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY_TBL_USER);
//        db.execSQL(CREATE_QUERY_TBL_QUESTIONS);
        Log.e("DATABASE OPERATIONS","Tables created.");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



    /**************** USERS PART ****************/


    //add User
    public void addInfo(String username, String password, SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DB_Contract.NewUserInfo.USER_NAME,username);
        contentValues.put(DB_Contract.NewUserInfo.USER_PASSWORD,password);
        db.insert(DB_Contract.NewUserInfo.TABLE_NAME,null,contentValues);
        Log.e("DATABASE OPERATIONS", "One User inserted");
    }


    //delete user from database
    public void deleteUser(String username, SQLiteDatabase sqLiteDatabase)
    {
        String selection =  DB_Contract.NewUserInfo.USER_NAME+" LIKE ? ";
        String [] selectionArg = {username};
        sqLiteDatabase.delete(DB_Contract.NewUserInfo.TABLE_NAME,selection,selectionArg);

    }


    //read User info from database
    public Cursor getInfo(SQLiteDatabase db)
    {
        Cursor  cursor;
        String[] projections = {DB_Contract.NewUserInfo.USER_NAME, DB_Contract.NewUserInfo.USER_PASSWORD};
        cursor = db.query(DB_Contract.NewUserInfo.TABLE_NAME,projections,null,null,null,null,null);
        return cursor;
    }


    /* verify if the user write username and password correctly */
    public boolean verifyUserLogin(String username, String password) {

        String query = "Select * FROM " + DB_Contract.NewUserInfo.TABLE_NAME + " WHERE "
                + DB_Contract.NewUserInfo.USER_NAME + " =  \"" + username + "\""
                + " AND " + DB_Contract.NewUserInfo.USER_PASSWORD + " =  \"" + password + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        DataProviderUser user = new DataProviderUser();

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            user.setUsername(cursor.getString(0));
            user.setPassword(cursor.getString(1));
            cursor.close();
        } else {
            return false;
        }
        db.close();
        return true;
    }


    /* When a user register, verify that the username is not in database */
    public boolean verifyRegisterUsername(String username) {

        String query = "Select * FROM " + DB_Contract.NewUserInfo.TABLE_NAME + " WHERE "
                + DB_Contract.NewUserInfo.USER_NAME + " =  '" + username + "'";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        DataProviderUser user = new DataProviderUser();

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            user.setUsername(cursor.getString(0));
            cursor.close();
        } else {
            //if the username is not in database
            db.close();
            return false;
        }
        db.close();
        //if the username is already in database
        return true;
    }


    //get user from database
    public Cursor getUser(String username, SQLiteDatabase sqLiteDatabase){
        String[] projections = {DB_Contract.NewUserInfo.USER_NAME, DB_Contract.NewUserInfo.USER_PASSWORD};
        String selection =  DB_Contract.NewUserInfo.USER_NAME+" LIKE ? ";
        String [] selectionArg = {username};
        Cursor cursor = sqLiteDatabase.query(DB_Contract.NewUserInfo.TABLE_NAME,projections,selection,selectionArg,null,null,null);
        return cursor;
    }


    //find one User
    public DataProviderUser findOneUser(String username) {
        String query = "Select * FROM " + DB_Contract.NewUserInfo.TABLE_NAME + " WHERE "
                + DB_Contract.NewUserInfo.USER_NAME + " =  \"" + username + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        DataProviderUser user = new DataProviderUser();

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            //user.setID(Integer.parseInt(cursor.getString(0)));
            user.setUsername(cursor.getString(0));
            user.setPassword(cursor.getString(1));
            cursor.close();
        } else {
            user = null;
        }
        db.close();
        return user;
    }


    /**************** QUESTIONS PART ****************/


    //add question
    public void addQuestion(String topic, String title, String content, String username, SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DB_Contract.NewQuestion.TOPIC,topic);
        contentValues.put(DB_Contract.NewQuestion.TITLE,title);
        contentValues.put(DB_Contract.NewQuestion.CONTENT,content);
        contentValues.put(DB_Contract.NewQuestion.USERNAME,username);
        db.insert(DB_Contract.NewQuestion.TABLE_NAME,null,contentValues);
        Log.e("DATABASE OPERATIONS", "One Question inserted");
    }



}
