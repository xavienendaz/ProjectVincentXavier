package com.example.xavier.projectvincentxavier;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        setTitle("Home");




    }

    //redirect the user on different pages
    public void goAddquestion(View view) {
        Intent i = new Intent(HomePageActivity.this, AddQuestionActivity.class);
        HomePageActivity.this.startActivity(i);
    }

    public void goTopics(View view) {
        Intent i = new Intent(HomePageActivity.this, TopicsActivity.class);
        HomePageActivity.this.startActivity(i);
    }

    public void goProfile(View view) {
        Intent i = new Intent(HomePageActivity.this, UserProfileActivity.class);
        HomePageActivity.this.startActivity(i);
    }

    public void goSettings(View view) {
        Intent i = new Intent(HomePageActivity.this, SettingsActivity.class);
        HomePageActivity.this.startActivity(i);
    }
}
