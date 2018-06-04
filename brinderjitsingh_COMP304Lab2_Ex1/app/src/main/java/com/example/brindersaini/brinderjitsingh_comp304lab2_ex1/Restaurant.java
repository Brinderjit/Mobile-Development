package com.example.brindersaini.brinderjitsingh_comp304lab2_ex1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class Restaurant extends AppCompatActivity {
    private Intent intent;
    private String cusineType;
    private String restaurantName;
    private int id = 1001;
    private ArrayList<String> selectedChkBx = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        intent = getIntent();
        cusineType = intent.getStringExtra("selectedCuisine");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // Capture the layout's TextView and set the string as its text


    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.clear();

        String[] restaurant = new String[6];
        restaurant = getRestaurantArray();

        for (int i = 0; i < restaurant.length; i++) {

            menu.add(i, i, i, restaurant[i]);
        }

        // this.getMenuInflater().inflate(R.menu.restaurantmenu, menu);

        return true;
    }

    public String[] getRestaurantArray() {
        String[] restaurant = new String[6];

        switch (cusineType) {
            case "American":
                restaurant = getResources().getStringArray(R.array.american_restaurants);

                break;
            case "Indian":
                restaurant = getResources().getStringArray(R.array.indian_restaurants);
                break;
            case "Canadian":
                restaurant = getResources().getStringArray(R.array.canadian_restaurants);
                break;
            case "Chinese":
                restaurant = getResources().getStringArray(R.array.chinese_restaurants);
                break;
            case "Italian":
                restaurant = getResources().getStringArray(R.array.italain_restaurants);
                break;
            case "Others":
                restaurant = getResources().getStringArray(R.array.others_restaurants);
                break;
            case "Russian":
                restaurant = getResources().getStringArray(R.array.russian_restaurants);
                break;
        }
        return restaurant;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        if (item.getItemId() == android.R.id.home) {
            finish();

            return super.onOptionsItemSelected(item);
        }

        String[] food = new String[6];
        //ScrollView sv = new ScrollView(this);
        LinearLayout layout = (LinearLayout) findViewById(R.id.menuCotainer);

        // layout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        layout.setOrientation(LinearLayout.VERTICAL);


        // sv.addView(layout);
        //check selected menu item


        if (item.getItemId() == 0) {
            restaurantName = item.getTitle().toString();
            layout.removeAllViews();
            food = getResources().getStringArray(R.array.food_list1);
            for (int i = 0; i < food.length; i++) {
                CheckBox ck = new CheckBox(getApplicationContext());
                ck.setText(food[i]);
                ck.setId(id);
                RelativeLayout.LayoutParams chkBoxParams = new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

                ck.setLayoutParams(chkBoxParams);
                ck.setTextColor(Color.WHITE);
                ck.setTextSize(18);
                ck.setPadding(2, 2, 2, 20);
                layout.addView(ck);
                id++;
            }


        }
        if (item.getItemId() == 1) {
            restaurantName = item.getTitle().toString();
            layout.removeAllViews();
            food = getResources().getStringArray(R.array.food_list2);
            for (int i = 0; i < food.length; i++) {
                CheckBox ck = new CheckBox(getApplicationContext());
                ck.setText(food[i]);
                ck.setId(id);
                RelativeLayout.LayoutParams chkBoxParams = new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

                ck.setLayoutParams(chkBoxParams);
                ck.setTextColor(Color.WHITE);
                ck.setTextSize(18);
                ck.setPadding(2, 2, 2, 20);
                layout.addView(ck);
                id++;
            }


        }
        if (item.getItemId() == 2) {
            restaurantName = item.getTitle().toString();
            layout.removeAllViews();
            food = getResources().getStringArray(R.array.food_list3);
            for (int i = 0; i < food.length; i++) {
                CheckBox ck = new CheckBox(this);
                ck.setText(food[i]);
                ck.setId(id);
                RelativeLayout.LayoutParams chkBoxParams = new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

                ck.setLayoutParams(chkBoxParams);
                ck.setTextColor(Color.WHITE);
                ck.setTextSize(18);
                ck.setPadding(2, 2, 2, 20);
                layout.addView(ck);
                id++;
            }


        }
        if (item.getItemId() == 3) {
            restaurantName = item.getTitle().toString();
            layout.removeAllViews();
            food = getResources().getStringArray(R.array.food_list4);
            for (int i = 0; i < food.length; i++) {
                CheckBox ck = new CheckBox(this);
                ck.setText(food[i]);
                ck.setId(id);
                RelativeLayout.LayoutParams chkBoxParams = new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

                ck.setLayoutParams(chkBoxParams);
                ck.setTextColor(Color.WHITE);
                ck.setTextSize(18);
                ck.setPadding(2, 2, 2, 20);
                layout.addView(ck);
                id++;
            }


        }
        if (item.getItemId() == 4) {
            layout.removeAllViews();
            food = getResources().getStringArray(R.array.food_list5);
            for (int i = 0; i < food.length; i++) {
                CheckBox ck = new CheckBox(this);
                ck.setText(food[i]);
                ck.setId(id);
                RelativeLayout.LayoutParams chkBoxParams = new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

                ck.setLayoutParams(chkBoxParams);
                ck.setTextColor(Color.WHITE);
                ck.setTextSize(18);
                ck.setPadding(2, 2, 2, 20);
                layout.addView(ck);
                id++;
            }


        }
        if (item.getItemId() == 5) {
            layout.removeAllViews();
            food = getResources().getStringArray(R.array.food_list6);
            for (int i = 0; i < food.length; i++) {
                CheckBox ck = new CheckBox(this);
                ck.setText(food[i]);
                ck.setId(id);
                RelativeLayout.LayoutParams chkBoxParams = new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

                ck.setLayoutParams(chkBoxParams);
                ck.setTextColor(Color.WHITE);
                ck.setTextSize(18);
                ck.setPadding(2, 2, 2, 20);
                layout.addView(ck);
                id++;
            }


        }
        return true;
    }

    protected void onNextClick(View view) {
        for (int i = 1001; i < id; i++) {
            CheckBox bx = (CheckBox) findViewById(i);
            if (bx.isChecked()) {
                selectedChkBx.add(bx.getText().toString());
            }

        }
        Intent intent1 = new Intent(this, CustomerInfo.class);
        intent1.putExtra("SelectedFood", selectedChkBx);
        intent1.putExtra("SelectedCuisine", cusineType);
        intent1.putExtra("SelectedRestaurant", restaurantName);
        startActivity(intent1);
    }


}
