package com.dev.sigma77.kidslearning;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class HappyBirthday extends ActionBarActivity {
    FrameLayout fLayout;
    RelativeLayout rLayout;
    ImageView happyBirthday;
    boolean running=false;
    int color=1;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_happy_birthday);
      fLayout= (FrameLayout) findViewById(R.id.frameLayout);
        happyBirthday= (ImageView) findViewById(R.id.imgHappyBirthday);
        rLayout= (RelativeLayout) findViewById(R.id.relLaiout);
        mp = MediaPlayer.create(HappyBirthday.this, R.raw.intro_one);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        startTimer();
       changeColors();
        if (mp != null) {

            mp.release();
            mp = null;
        }
        mp = MediaPlayer.create(HappyBirthday.this, R.raw.happy_birthday_song);
        mp.start();
        rLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }



    public  void startTimer (){
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                running=true;

               finish();


            }
        },25000);

    }
    public void onBackPressed() {
        if (mp != null) {

            mp.release();
            mp = null;
           finish();
        }
    }
    @Override
    protected void onStop()
    {
        super.onStop();
        if (mp != null) {

            mp.release();
            mp = null;
            finish();

        }

    }
    public void changeColors(){

            if (color==1) {


                happyBirthday.setBackgroundResource(R.drawable.happy_birthday_green);
                color=2;


            } else {
                happyBirthday.setBackgroundResource(R.drawable.happy_birthday_red);

                color=1;

            }


            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {

                    changeColors();


                }
            }, 1000);



    }


}
