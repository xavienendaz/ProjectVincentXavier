package com.example.xavier.projectvincentxavier;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ListView;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class UserAreaActivity extends AppCompatActivity {



    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    UserDbHelper userDbHelper;
    Cursor cursor;
    ListDataAdapter listDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);
        setTitle("Database");
        listView = (ListView)findViewById(R.id.listview_userarea);
        listDataAdapter = new ListDataAdapter(getApplicationContext(),R.id.row_layout);
        listView.setAdapter(listDataAdapter);
        userDbHelper =  new UserDbHelper(getApplicationContext());
        sqLiteDatabase = userDbHelper.getReadableDatabase();
        //get info from databse
        cursor =  userDbHelper.getInfo(sqLiteDatabase);
        if(cursor.moveToFirst())
        {
            do{
                String username,password;
                username =  cursor.getString(0);
                password = cursor.getString(1);

                DataProvider dataProvider = new DataProvider(username, password);
                listDataAdapter.add(dataProvider);

        }while(cursor.moveToNext());
        }


    }

}


