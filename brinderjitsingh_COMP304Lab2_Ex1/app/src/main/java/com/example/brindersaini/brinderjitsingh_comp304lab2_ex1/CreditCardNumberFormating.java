package com.example.brindersaini.brinderjitsingh_comp304lab2_ex1;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by Brinder Saini on 29/09/2017.
 */

public class CreditCardNumberFormating implements TextWatcher {


    private boolean lock;

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void afterTextChanged(Editable s) {
        if (lock || s.length() > 16) {
            return;
        }
        lock = true;
        for (int i = 4; i < s.length(); i += 5) {
            if (s.toString().charAt(i) != ' ') {
                s.insert(i, " ");
            }
        }
        lock = false;
    }
}

