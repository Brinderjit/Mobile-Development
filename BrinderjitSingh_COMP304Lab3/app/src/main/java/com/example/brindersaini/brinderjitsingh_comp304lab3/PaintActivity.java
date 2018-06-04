package com.example.brindersaini.brinderjitsingh_comp304lab3;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class PaintActivity extends AppCompatActivity {


    ImageView reusableImageView;
    TextView textView;
    Spinner thicknessSpinner;
    //
    int startx = 10;
    int starty = 10;
    int endx=10;
    int endy=10;
    //
    Paint paint;
    Bitmap bitmap;
    Canvas canvas;
    //
    Handler mHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(20);
        RadioGroup rGroup = (RadioGroup)findViewById(R.id.colorRdoGroup);
        rGroup = (RadioGroup) findViewById(R.id.colorRdoGroup);
        rGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
               RadioButton radioButton = (RadioButton) findViewById(checkedId);
               String selectedTxt=radioButton.getText().toString();
                switch (selectedTxt) {
                    case "Red":
                        paint.setColor(Color.RED);
                        break;
                    case "Yellow":
                        paint.setColor(Color.YELLOW);
                        break;
                    case "Cyan":
                        paint.setColor(Color.CYAN);
                        break;
                }
            }

        });

        thicknessSpinner =(Spinner) findViewById(R.id.thicknessSpinner);
        thicknessSpinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                        String item = parent.getItemAtPosition(pos).toString();
                        paint.setStrokeWidth(Float.parseFloat(item));

                    }
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
        //creating a bitmap as content view for the canvas
        bitmap = Bitmap.createBitmap((int) getWindowManager()
                .getDefaultDisplay().getWidth(), (int) getWindowManager()
                .getDefaultDisplay().getHeight(), Bitmap.Config.ARGB_4444);
        canvas = new Canvas(bitmap);
        canvas.drawColor(Color.WHITE);
        reusableImageView = (ImageView)findViewById(R.id.ImageViewForDrawing);
        //setting a bitmap as content view for the image
        reusableImageView.setImageBitmap(bitmap);
        //reusableImageView.setVisibility(View.VISIBLE);
        textView = (TextView) findViewById(R.id.textView1);
        textView.setText(String.valueOf(0));



    }// end of onCreate
    //
    public void clearCanvas(View v)
    {
        canvas.drawColor(Color.WHITE);
        textView.setText("clear");
    }
    //


    public void drawLine( Canvas canvas)
    {
        textView.setText(String.valueOf(endy));
        canvas.drawLine(startx, starty, endx, endy, paint);
        startx=endx;
        starty=endy;

    }

    public void onUpButtonClick(View v)
    {
        reusableImageView.setFocusable(true);
        reusableImageView.requestFocus();
        endy=endy-5;
        drawLine(canvas);
    }
    public void onDownButtonClick(View v)
    {
        reusableImageView.setFocusable(true);
        reusableImageView.requestFocus();
        endy=endy+5;
        drawLine(canvas);
        reusableImageView.invalidate();
    }
    public void onLeftButtonClick(View v)
    {
        reusableImageView.setFocusable(true);
        reusableImageView.requestFocus();
        endx=endx-5;
        drawLine(canvas);
        reusableImageView.invalidate();
    }
    public void onRightButtonClick(View v)
    {
        reusableImageView.setFocusable(true);
        reusableImageView.requestFocus();
        endx=endx+5;
        drawLine( canvas);
        reusableImageView.invalidate();
    }
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        switch(keyCode)
        {
            case KeyEvent.KEYCODE_DPAD_DOWN:

                endy=endy+5;
                drawLine(canvas);
                return true;

            case KeyEvent.KEYCODE_DPAD_UP:

                reusableImageView.setFocusable(true);
                reusableImageView.requestFocus();
                endy=endy-5;
                drawLine(canvas);
                reusableImageView.invalidate();

                return true;
            case KeyEvent.KEYCODE_DPAD_RIGHT:

                reusableImageView.setFocusable(true);
                reusableImageView.requestFocus();
                endx=endx+5;
                drawLine( canvas);
                reusableImageView.invalidate();
                return true;
            case KeyEvent.KEYCODE_DPAD_LEFT:

                reusableImageView.setFocusable(true);
                reusableImageView.requestFocus();
                endx=endx-5;
                drawLine( canvas);
                reusableImageView.invalidate();
                return true;

        }
        return false;
    }
}
