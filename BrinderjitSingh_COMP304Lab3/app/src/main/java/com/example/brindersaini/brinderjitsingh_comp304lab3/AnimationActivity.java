package com.example.brindersaini.brinderjitsingh_comp304lab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;



public class AnimationActivity extends AppCompatActivity {
        ImageView backgroundImageView;
        ImageView moonImageView,earthImageView;
        Animation an,spin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
            moonImageView = (ImageView)findViewById(R.id.ImageViewForTweening);
           earthImageView=(ImageView)findViewById(R.id.ImageViewEarth);
            an =  AnimationUtils.loadAnimation(this, R.anim.earthspin);
        spin =  AnimationUtils.loadAnimation(this, R.anim.spin);
        // Handle Move Button
        final Button moveButton = (Button) findViewById(R.id.ButtonTranslate);
        moveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                moonImageView.startAnimation(an);
                earthImageView.startAnimation(spin);

            }
        });

        // Handle Spin Button
        final Button spinButton = (Button) findViewById(R.id.ButtonStop);
        spinButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ImageView reusableImageViewMoon = (ImageView) findViewById(R.id.ImageViewForTweening);
               ImageView reusableImageViewEarth = (ImageView) findViewById(R.id.ImageViewEarth);
              reusableImageViewEarth.clearAnimation();
                reusableImageViewMoon.clearAnimation();
            }
        });

        // Handle All Button

    }

}
