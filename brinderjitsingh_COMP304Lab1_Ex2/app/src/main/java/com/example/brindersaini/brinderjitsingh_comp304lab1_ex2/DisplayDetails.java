package com.example.brindersaini.brinderjitsingh_comp304lab1_ex2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_details);
        Intent intent = getIntent();
        // Capture the layout's TextView and set the string as its text
        TextView fullname = (TextView) findViewById(R.id.fullname);
        fullname.setText(intent.getStringExtra("Fullname"));
        TextView program= (TextView) findViewById(R.id.program);
        program.setText(intent.getStringExtra("program"));
        TextView semester = (TextView) findViewById(R.id.semester);
        semester.setText(intent.getStringExtra("semester"));
        TextView course = (TextView) findViewById(R.id.course);
        course.setText(intent.getStringExtra("course"));
    }
}
