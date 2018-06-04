package com.example.brindersaini.brinderjitsingh_comp304finallabtest_002;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import database.manager.StockManager;
import dto.Stock;

public class MainActivity extends AppCompatActivity {
    StockManager cm;
    String stockStr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        String tablename="StockInfo";
        String tablecreatestring="create table IF NOT EXISTS StockInfo(stockSymbol TEXT PRIMARY KEY"
                + ",companyName TEXT,"
                + "stockQuote INTEGER"
                +");";
        cm=new StockManager(this);
        cm.dbInitialize(tablename,tablecreatestring);


    }
    public void onDisplayStockClick(View V)
    {
        String stocksymble=null;
        try {
            RadioButton google=(RadioButton)findViewById(R.id.stock1Rdo);
            RadioButton amazon=(RadioButton)findViewById(R.id.stock2Rdo);
            RadioButton samsung=(RadioButton)findViewById(R.id.stock3Rdo);
            if(google.isChecked())
            {
                stocksymble=google.getText().toString();
            }
            else if(amazon.isChecked()){
                stocksymble=amazon.getText().toString();
            }
            else if( samsung.isChecked())
            {
                stocksymble=samsung.getText().toString();

            }
            if (stocksymble != null)
            {
                Stock s=cm.getStockById(stocksymble,"stockSymbol");
                if(s!=null){


                StringBuilder strbd=new StringBuilder();
                strbd.append("Company Name: ");
                strbd.append(s.getCompanyName());
                strbd.append(System.getProperty("line.separator"));

                strbd.append("Stock Quote: ");
                strbd.append(s.getStockQuote());
                TextView t=(TextView)findViewById(R.id.displayStockTxt);
                stockStr= strbd.toString();
                t.setText(stockStr);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Intent i= new Intent(this, services.MyService.class);
        i.putExtra("stockinfo", stockStr);
        startService(i);
    }
    public void onInsertStockClick(View V)
    {
        try {

            ContentValues contentValues = new ContentValues();
            contentValues.put("stockSymbol","GOOGL");
            contentValues.put("companyName","Google");
            contentValues.put("stockQuote",990);
            boolean flag1=cm.addRow(contentValues);
            contentValues = new ContentValues();
            contentValues.put("stockSymbol","AMZN");
            contentValues.put("companyName","Amazon");
            contentValues.put("stockQuote",1000);
            boolean flag2= cm.addRow(contentValues);
            contentValues = new ContentValues();
            contentValues.put("stockSymbol","SSNLF");
            contentValues.put("companyName","Samsung Electronics Co Ltd");
            contentValues.put("stockQuote",800);
            boolean flag3= cm.addRow(contentValues);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
