package com.example.brindersaini.brinderjitsingh_comp304lab2_ex1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class CustomerInfo extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private String cusineType;
    private String restaurantName;
    private ArrayList<String> selectedChkBx = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_info);
        Intent intent = getIntent();
        cusineType = intent.getStringExtra("SelectedCuisine");
        restaurantName = intent.getStringExtra("SelectedRestaurant");
        selectedChkBx = intent.getStringArrayListExtra("SelectedFood");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowCustomEnabled(true);
        }

        EditText creditCard = (EditText)findViewById(R.id.numberEditTxt);
        creditCard.addTextChangedListener(new CreditCardNumberFormating());

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    protected void onOrderClick(View view) {

        String regExpn = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
        String regExpnnumber = "(?:(?:\\+?1\\s*(?:[.-]\\s*)?)?(?:(\\s*([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9]\u200C\u200B)\\s*)|([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9]))\\s*(?:[.-]\\s*)?)([2-9]1[02-9]\u200C\u200B|[2-9][02-9]1|[2-9][02-9]{2})\\s*(?:[.-]\\s*)?([0-9]{4})\\s*(?:\\s*(?:#|x\\.?|ext\\.?|extension)\\s*(\\d+)\\s*)?$";
        String firstname;
        String lastname;
        String email;
        String number;
        String address;
        String PostelCode;
        String favouritecusine;
        String chef;

        try {
            radioGroup = (RadioGroup) findViewById(R.id.deliverRdoGrp);
            // get selected radio button from radioGroup
            int selectedId = radioGroup.getCheckedRadioButtonId();

            // find the radiobutton by returned id

            EditText firstedit = (EditText) findViewById(R.id.firstNameEditTxt);
            firstname = firstedit.getText().toString();
            EditText lastedit = (EditText) findViewById(R.id.lastNameEditTxt);
            lastname = lastedit.getText().toString();
            EditText emailedit = (EditText) findViewById(R.id.emailEditTxt);
            email = emailedit.getText().toString();
            EditText numberedit = (EditText) findViewById(R.id.numberEditTxt);
            number = numberedit.getText().toString();
            EditText addressedit = (EditText) findViewById(R.id.addressAutoComplete);
            address = addressedit.getText().toString();
            EditText pinedit = (EditText) findViewById(R.id.pinCodeAutoComplete);
            PostelCode = pinedit.getText().toString();
            EditText cusineedit = (EditText) findViewById(R.id.autoCompleteTextView3);
            favouritecusine = cusineedit.getText().toString();
            EditText chefedit = (EditText) findViewById(R.id.chefEditView);
            chef = chefedit.getText().toString();

            if (firstname.length() == 0) {
                firstedit.requestFocus();
                firstedit.setError("FIELD CANNOT BE EMPTY");

            } else if (lastedit.length() == 0) {
                lastedit.requestFocus();
                lastedit.setError("FIELD CANNOT BE EMPTY");
            } else if (!email.matches(regExpn)) {
                emailedit.requestFocus();
                emailedit.setError("ENTER VALID EMAIL");
            }
             else if((numberedit.length()<16))
            {
              numberedit.requestFocus();
              numberedit.setError("ENTER VALID NUMBER");
            }
            else if (addressedit.length() == 0) {
                addressedit.requestFocus();
                addressedit.setError("FIELD CANNOT BE EMPTY");
            } else if (cusineedit.length() == 0) {
                lastedit.requestFocus();
                lastedit.setError("FIELD CANNOT BE EMPTY");
            } else if (pinedit.length() == 0) {
                lastedit.requestFocus();
                lastedit.setError("FIELD CANNOT BE EMPTY");
            } else if (chefedit.length() == 0) {
                lastedit.requestFocus();
                lastedit.setError("FIELD CANNOT BE EMPTY");
            } else if (selectedId == -1) {
                radioGroup.requestFocus();
                radioButton = (RadioButton) findViewById(R.id.pickRdo);
                radioButton.setError("Select delivery type");
            } else {
                Intent intent1 = new Intent(this, OrderSummery.class);


                intent1.putExtra("firstname", firstname);


                intent1.putExtra("lastname", lastname);


                intent1.putExtra("email", email);


                intent1.putExtra("number", number);


                intent1.putExtra("address", address);


                intent1.putExtra("PostelCode", PostelCode);


                intent1.putExtra("favouritecusine", favouritecusine);


                intent1.putExtra("chef", chef);

                radioButton = (RadioButton) findViewById(selectedId);

                String selectedTxt = radioButton.getText().toString();
                intent1.putExtra("delivery", selectedTxt);
                intent1.putExtra("SelectedFood", selectedChkBx);
                intent1.putExtra("SelectedCuisine", cusineType);
                intent1.putExtra("SelectedRestaurant", restaurantName);
                startActivity(intent1);
            }
        } catch (Exception e) {

        }


    }
}
