package com.example.xavier.projectvincentxavier;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class QuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        setTitle("Question");




       //share content to others apps
        final ImageButton ib  = (ImageButton) findViewById(R.id.ibShare);
        ib.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //redirect the user on loginActivity when he deleted his account
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                //sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                //send the content of the question
                sendIntent.putExtra(Intent.EXTRA_TEXT, R.id.tvText);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);

            }
        });



    }
}
