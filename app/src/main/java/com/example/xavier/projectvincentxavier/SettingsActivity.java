package com.example.xavier.projectvincentxavier;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        setTitle("Settings");








        //delete an account
        final Button btDeleteAccount  = (Button) findViewById(R.id.btDeleteAccount);
        btDeleteAccount.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //redirect the user on loginActivity when he deleted his account
                Intent goLogin = new Intent(SettingsActivity.this, LoginActivity.class);
                SettingsActivity.this.startActivity(goLogin);

            }
        });


    }
}
