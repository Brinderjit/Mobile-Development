package com.example.brindersaini.brinderjitsingh_comp304lab3;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FrameByFrameActivity extends AppCompatActivity {

    AnimationDrawable mframeAnimation = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_by_frame);
    }

    //
    public void onStartClick(View v) {
        startAnimation();
    }
    public void onStopClick(View v) {
        stopAnimation();
    }
    private void startAnimation()
    {

        ImageView img = (ImageView)findViewById(R.id.ImageView_Boy);

        BitmapDrawable frame1 = (BitmapDrawable)getResources().getDrawable(R.drawable.anim1);
        BitmapDrawable frame2 = (BitmapDrawable)getResources().getDrawable(R.drawable.anim2);
        BitmapDrawable frame3 = (BitmapDrawable)getResources().getDrawable(R.drawable.anim3);
        BitmapDrawable frame4 = (BitmapDrawable)getResources().getDrawable(R.drawable.anim4);
        BitmapDrawable frame5 = (BitmapDrawable)getResources().getDrawable(R.drawable.anim5);
        BitmapDrawable frame6 = (BitmapDrawable)getResources().getDrawable(R.drawable.anim6);
        BitmapDrawable frame7 = (BitmapDrawable)getResources().getDrawable(R.drawable.anim7);
        BitmapDrawable frame8 = (BitmapDrawable)getResources().getDrawable(R.drawable.anim8);
        BitmapDrawable frame9 = (BitmapDrawable)getResources().getDrawable(R.drawable.anim9);
        // Get the background, which has been compiled to an AnimationDrawable object.
        int reasonableDuration =170;
        mframeAnimation = new AnimationDrawable();
        mframeAnimation.setOneShot(false);	// loop continuously
        mframeAnimation.addFrame(frame1, reasonableDuration);
        mframeAnimation.addFrame(frame2, reasonableDuration);
        mframeAnimation.addFrame(frame3, reasonableDuration);
        mframeAnimation.addFrame(frame4, reasonableDuration);
        mframeAnimation.addFrame(frame5, reasonableDuration);
        mframeAnimation.addFrame(frame6, reasonableDuration);
        mframeAnimation.addFrame(frame7, reasonableDuration);
        mframeAnimation.addFrame(frame8, reasonableDuration);
        mframeAnimation.addFrame(frame9, reasonableDuration);
        img.setBackgroundDrawable(mframeAnimation);

        mframeAnimation.setVisible(true,true);
        mframeAnimation.start();
    }
    private void stopAnimation()
    {
        mframeAnimation.stop();
        mframeAnimation.setVisible(false,false);

    }

}
