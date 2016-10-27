package com.example.xavier.projectvincentxavier;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

public class QuestionsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_list);
        setTitle("Questions list");


        final String [] questionsList = getResources().getStringArray(R.array.questionsList_array);
        ListView list;


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.listview_layout, questionsList){

            // Call for every entry in the ArrayAdapter
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view;
                //If View doesn't exist create a new view
                if (convertView == null) {
                    // Create the Layout
                    LayoutInflater inflater = getLayoutInflater();
                    view = inflater.inflate(R.layout.listview_layout, parent, false);
                } else {
                    view = convertView;
                }

                //Add Text to the layout
                TextView textView1 = (TextView) view.findViewById(R.id.listview);
                textView1.setText(questionsList[position]);

                return view;
            }
        };

        //ListView
        list = (ListView) findViewById(R.id.main_listview);
        list.setAdapter(adapter);

        //ListeView handler
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent i = new Intent(QuestionsListActivity.this, QuestionActivity.class);
                QuestionsListActivity.this.startActivity(i);
            }
        });



        //adding a question
        final ImageButton ib = (ImageButton) findViewById(R.id.ibAddQuestion);
        ib.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(QuestionsListActivity.this, AddQuestionActivity.class);
                QuestionsListActivity.this.startActivity(i);

            }
        });

    }
}
