package com.example.xavier.projectvincentxavier;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    Context context = this;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;
    EditText etUsername, etPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitle("Registration");

        etPassword = (EditText) findViewById(R.id.etPassword);
        etUsername = (EditText) findViewById(R.id.etUsername);





    }

    public void registerUser(View view){
        String verifyPassword = etPassword.getText().toString();
        if(TextUtils.isEmpty(verifyPassword)) {
            etPassword.setError("Error");
            return;
        }
        else{
            String username = etUsername.getText().toString();
            String password = etPassword.getText().toString();

            userDbHelper = new UserDbHelper(context);
            sqLiteDatabase = userDbHelper.getWritableDatabase();
            userDbHelper.addInfo(username,password,sqLiteDatabase);
            Toast.makeText(getBaseContext(),"User created",Toast.LENGTH_LONG).show();
            userDbHelper.close();
        }


        }






    }

