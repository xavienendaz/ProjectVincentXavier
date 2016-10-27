package com.example.xavier.projectvincentxavier;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddQuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);
        setTitle("New question");


        //redirect on questionlist and saving data
        final Button b = (Button) findViewById(R.id.btSave);
        b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(AddQuestionActivity.this, QuestionsListActivity.class);
                AddQuestionActivity.this.startActivity(i);

            }
        });
    }
}
