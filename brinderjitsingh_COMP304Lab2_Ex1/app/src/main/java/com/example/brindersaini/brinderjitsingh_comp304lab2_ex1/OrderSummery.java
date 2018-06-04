package com.example.brindersaini.brinderjitsingh_comp304lab2_ex1;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderSummery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summery);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        Intent intent1 = getIntent();
        try {


            TextView edit = (TextView) findViewById(R.id.firstNameValuetxt);
            edit.setText(intent1.getStringExtra("firstname"));

            edit = (TextView) findViewById(R.id.lastNameValueTxt);
            edit.setText(intent1.getStringExtra("lastname"));

            edit = (TextView) findViewById(R.id.emailValueTxt);
            edit.setText(intent1.getStringExtra("email"));

            edit = (TextView) findViewById(R.id.numberValueTxt);
            edit.setText(intent1.getStringExtra("number"));

            edit = (TextView) findViewById(R.id.addressValueTxt);
            edit.setText(intent1.getStringExtra("address"));

            edit = (TextView) findViewById(R.id.postalValueTxt);
            edit.setText(intent1.getStringExtra("PostelCode"));

            edit = (TextView) findViewById(R.id.favouriteCuisineTxtValue);
            edit.setText(intent1.getStringExtra("favouritecusine"));

            edit = (TextView) findViewById(R.id.favouriteChefTxtValue);
            edit.setText(intent1.getStringExtra("chef"));

            edit = (TextView) findViewById(R.id.deliveryValueTxt);
            edit.setText(intent1.getStringExtra("delivery"));

            edit = (TextView) findViewById(R.id.cusineTxtValue);
            edit.setText(intent1.getStringExtra("SelectedCuisine"));

            edit = (TextView) findViewById(R.id.restaurantValue);
            edit.setText(intent1.getStringExtra("SelectedRestaurant"));

            ArrayList<String> foodlist = new ArrayList<String>();
            foodlist = intent1.getStringArrayListExtra("SelectedFood");
           // ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.list, foodlist);
           // ListView listView = (ListView) findViewById(R.id.foodList);
           // listView.setAdapter(adapter);
            int i=0;
            LinearLayout layout =(LinearLayout) findViewById(R.id.selectedFoodContainer);
            for (String s: foodlist) {
                TextView ck=new TextView(getApplicationContext());
                ck.setText(s);
                ck.setId(i);
                RelativeLayout.LayoutParams chkBoxParams = new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

                ck.setLayoutParams(chkBoxParams);

                ck.setTextSize(18);
                i++;
                layout.addView(ck);

            }
        }
        catch (Exception e)
        {

        }



    }

    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
