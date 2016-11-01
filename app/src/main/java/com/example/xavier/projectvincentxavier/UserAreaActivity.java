package com.example.xavier.projectvincentxavier;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class UserAreaActivity extends AppCompatActivity {



    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    UserDbHelper userDbHelper;
    Cursor cursor;
    ListDataAdapterUser listDataAdapterUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);
        setTitle("Database");
        listView = (ListView)findViewById(R.id.listview_userarea);
        listDataAdapterUser = new ListDataAdapterUser(getApplicationContext(),R.id.row_layout);
        listView.setAdapter(listDataAdapterUser);
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

                DataProviderUser dataProviderUser = new DataProviderUser(username, password);
                listDataAdapterUser.add(dataProviderUser);

        }while(cursor.moveToNext());
        }


    }

}


