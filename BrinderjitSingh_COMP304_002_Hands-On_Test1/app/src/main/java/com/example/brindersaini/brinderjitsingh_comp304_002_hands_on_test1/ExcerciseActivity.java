package com.example.brindersaini.brinderjitsingh_comp304_002_hands_on_test1;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Interpolator;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ExcerciseActivity extends AppCompatActivity {
    private ArrayList<String> selectedChkBx = new ArrayList<String>();
    String[] exerciseList;
    private int id = 1001;
    ImageView reusableImageView;
    Spinner thicknessSpinner;
    Paint paint;
    Bitmap bitmap;
    Canvas canvas;
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercise);
        LinearLayout chkBxContainer=(LinearLayout)findViewById(R.id.chkBxContainer);
        exerciseList= getResources().getStringArray(R.array.exerciselist);

        for (int i = 0; i < exerciseList.length; i++) {
            CheckBox ck = new CheckBox(this);

            ck.setId(id);
            ck.setTextColor(Color.BLACK);
            ck.setTextSize(18);
            ck.setPadding(2, 2, 2, 20);
            chkBxContainer.addView(ck);
            LinearLayout.LayoutParams chkBoxParams = new LinearLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            ck.setLayoutParams(chkBoxParams);
            ck.setText(exerciseList[i]);
            id++;

        }
        reusableImageView = (ImageView)findViewById(R.id.imageLine);
        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(50);

        bitmap = Bitmap.createBitmap(4000, (int) getWindowManager()
                .getDefaultDisplay().getHeight(), Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        canvas.drawColor(Color.BLUE);
       String[] yList= getResources().getStringArray(R.array.memoryCycle);
        int startx=0;
        int starty= 600;
       for (int i=0;i<yList.length;i++) {
           int endx=startx+500;
           int endy=Integer.parseInt(yList[i])*5;
           canvas.drawLine(startx, starty, endx, endy, paint);
           startx = endx ;
           starty = endy ;
       }

        //setting a bitmap as content view for the image
        reusableImageView.setImageBitmap(bitmap);
        Button nextBtn=(Button)findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String exercises="";
                for (int i =1001; i <id; i++) {
                    CheckBox bx = (CheckBox) findViewById(i);
                    if (bx.isChecked()) {
                        exercises +=bx.getText().toString() + System.lineSeparator();
                        selectedChkBx.add(bx.getText().toString());
                    }

                }
                if(exercises.equals(""))
                {
                    exercises="Please select a exercise";
                }
                Toast.makeText(getApplicationContext(), exercises,
                        Toast.LENGTH_LONG).show();
            }
        });

    }


}
