package com.example.brindersaini.brinderjitsingh_comp304lab2_ex1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class CusineType extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button btnDisplay;
    private String selectedTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cusine_type);
        radioGroup = (RadioGroup) findViewById(R.id.rdoGroupCusine);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Intent intent = new Intent(CusineType.this, Restaurant.class);
               // radioGroup = (RadioGroup) findViewById(R.id.rdoGroupCusine);
                // get selected radio button from radioGroup
              //  int selectedId = radioGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioButton = (RadioButton) findViewById(checkedId);

                selectedTxt=radioButton.getText().toString();
                intent.putExtra("selectedCuisine", selectedTxt);
                startActivity(intent);
            }

        });

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

    }

    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    protected   void  onNextClick(View view)
    {

                Intent intent = new Intent(CusineType.this, Restaurant.class);
                radioGroup = (RadioGroup) findViewById(R.id.rdoGroupCusine);
                // get selected radio button from radioGroup
                int selectedId = radioGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioButton = (RadioButton) findViewById(selectedId);

                selectedTxt=radioButton.getText().toString();
                intent.putExtra("selectedCuisine", selectedTxt);
                startActivity(intent);



    }
}
