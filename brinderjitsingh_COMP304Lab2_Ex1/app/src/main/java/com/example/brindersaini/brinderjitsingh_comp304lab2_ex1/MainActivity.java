package com.example.brindersaini.brinderjitsingh_comp304lab2_ex1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    protected void onEnterClick(View view) {
        Intent intent = new Intent(this, CusineType.class);
        startActivity(intent);
    }
}
