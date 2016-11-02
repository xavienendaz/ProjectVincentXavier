package com.example.xavier.projectvincentxavier;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Context context = this;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;
    EditText etUsername, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Create variables
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        final Button bLogin = (Button) findViewById(R.id.bLogin);
        final TextView registerLink = (TextView) findViewById(R.id.tvRegister);

        registerLink.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //open the registerActivity when user click on registerLink
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);

            }
        });

        //see the database
        final TextView tv = (TextView) findViewById(R.id.tvUserArea);
        tv.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //open the registerActivity when user click on registerLink
                Intent i = new Intent(LoginActivity.this, UserAreaActivity.class);
                LoginActivity.this.startActivity(i);
            }
        });






    }

    /* When the user click on Login button */
    public void buttonLogin(View view) {

        String verifyPassword = etPassword.getText().toString();
        String verifyUsername = etUsername.getText().toString();
        userDbHelper = new UserDbHelper(context);
        sqLiteDatabase = userDbHelper.getWritableDatabase();

        /* the method verifyUserLogin verify if the user write username and password correctly */
        if(userDbHelper.verifyUserLogin(verifyUsername, verifyPassword) == true){
            Intent i = new Intent(LoginActivity.this, HomePageActivity.class);
            LoginActivity.this.startActivity(i);
            Toast.makeText(LoginActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getBaseContext(), "User Name or Password does not match", Toast.LENGTH_SHORT).show();
        }
    }
}
