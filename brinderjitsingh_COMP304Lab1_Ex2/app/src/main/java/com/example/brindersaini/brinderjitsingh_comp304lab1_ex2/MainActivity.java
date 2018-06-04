package com.example.brindersaini.brinderjitsingh_comp304lab1_ex2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void displayDetails(View view)
    {
        Intent intent = new Intent(this, DisplayDetails.class);
        intent.putExtra("Fullname", getString(R.string.full_name));
        intent.putExtra("program", getString(R.string.program_name));
        intent.putExtra("semester",getString( R.string.semester));
        intent.putExtra("course", getString(R.string.course_name));
        startActivity(intent);
    }
}
