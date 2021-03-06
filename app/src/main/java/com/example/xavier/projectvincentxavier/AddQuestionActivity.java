package com.example.xavier.projectvincentxavier;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class AddQuestionActivity extends AppCompatActivity {

    Context context = this;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;
    EditText etTitle, etContent;
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);
        setTitle("New question");


        etTitle = (EditText) findViewById(R.id.etTitle);
        etContent = (EditText) findViewById(R.id.etContent);



        // topic spinner part
        spinner = (Spinner) findViewById(R.id.spinnerTopics);
        // Spinner click listener
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.topics_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                // On selecting a spinner item
                String topic = adapter.getItemAtPosition(position).toString();
                // Showing selected spinner item
                Toast.makeText(getApplicationContext(),
                        "Topic selected: " + topic, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });



    }


    //redirect on questionlist and saving data
    public void saveQuestion(View view) {
        String verifyTitle = etTitle.getText().toString();
        String verifyContent = etContent.getText().toString();

        /***************
         * we need to verify if a topic is selected
       *********************/


        //set error if the user let one field empty
        if (TextUtils.isEmpty(verifyTitle) || TextUtils.isEmpty(verifyContent)) {
            if (TextUtils.isEmpty(verifyTitle) && TextUtils.isEmpty(verifyContent)) {
                etTitle.setError("Enter a title");
                etContent.setError("Enter a content");
                return;
            } else if (TextUtils.isEmpty(verifyContent)) {
                etContent.setError("Enter a content");
                return;
            } else if (TextUtils.isEmpty(verifyTitle)) {
                etTitle.setError("Enter a title");
                return;
            }
        } else {

            //il y a encore des erreurs pour ajouter une question

            //insert question into database
            String topic = spinner.getSelectedItem().toString();
          //                String.valueOf(mySpinner.getSelectedItem());
            //String topic = "SWD";
            String title = etTitle.getText().toString();
            String content = etContent.getText().toString();
            String username = "salut"; //trouver le moyen de savoir le username depuis login


            userDbHelper = new UserDbHelper(context);
            sqLiteDatabase = userDbHelper.getWritableDatabase();
            userDbHelper.addQuestion(topic, title, content, "salut", sqLiteDatabase);
            Toast.makeText(getBaseContext(), "Question created", Toast.LENGTH_LONG).show();
            userDbHelper.close();



            //redirect to questionList
            Intent i = new Intent(AddQuestionActivity.this, QuestionsListActivity.class);
            AddQuestionActivity.this.startActivity(i);

        }
    }

}
