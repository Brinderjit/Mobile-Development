package com.example.brindersaini.brinderjitsingh_comp304lab3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView lvSettings=(ListView)findViewById(R.id.exerciseList);
        //handling list view event
        //handle the item click event
        lvSettings.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent=null;
                //capture the item name based on position
                String selectedExercise = (String)lvSettings.getItemAtPosition(position);
                //
                switch (position)
                {
                    case 0:
                        intent = new Intent(MainActivity.this,PaintActivity.class);
                        intent.putExtra("selectedSetting",selectedExercise);

                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this,FrameByFrameActivity.class);
                        intent.putExtra("selectedSetting",selectedExercise);

                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this,AnimationActivity.class);
                        intent.putExtra("selectedSetting",selectedExercise);

                        startActivity(intent);
                        break;
                }


            }
        });
    }
}
