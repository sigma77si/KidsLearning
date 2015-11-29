package com.dev.sigma77.kidslearning;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener {
    Button game1, game2, game3, game4, game5, game6, game7, game8;
    SoundPool sp;
    MediaPlayer mp;
    int introSound,bipSound,clickAnswerSound;
    public static boolean ifTest=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game1 = (Button) findViewById(R.id.btnGame1);
        game2 = (Button) findViewById(R.id.btnGame2);
        game3 = (Button) findViewById(R.id.btnGame3);
        game4 = (Button) findViewById(R.id.btnGame4);
        game5 = (Button) findViewById(R.id.btnGame5);
        game6 = (Button) findViewById(R.id.btnGame6);
        game7 = (Button) findViewById(R.id.btnGame7);
        game8 = (Button) findViewById(R.id.btnGame8);
        game1.setOnClickListener(this);
        game2.setOnClickListener(this);
        game3.setOnClickListener(this);
        game4.setOnClickListener(this);
        game5.setOnClickListener(this);
        game6.setOnClickListener(this);
        game7.setOnClickListener(this);
        game8.setOnClickListener(this);
        sp = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        introSound = sp.load(this, R.raw.intro_one, 1);
        bipSound = sp.load(this, R.raw.blub, 1);
        clickAnswerSound = sp.load(this, R.raw.sound, 1);
        mp = MediaPlayer.create(MainActivity.this, R.raw.intro_one);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onPause() {
        super.onPause();
        ResultActivity.result=-1;
//        getPreferences(MODE_PRIVATE).edit().putInt("Result",0).commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {


            case R.id.btnGame1: {

               sp.play(bipSound,1, 1, 0, 0, 1);
                Intent in = new Intent(this, IntroTextForAllActivity.class);
                in.putExtra("IntroText", R.string.Intro1Text1);
                in.putExtra("ImageToLoad", R.drawable.count_on_fingers_05);
                in.putExtra("TestNum", 1);
                in.putExtra("IntroReading", R.raw.intro_one);
                startActivity(in);


                break;
            }
            case R.id.btnGame2: {

                sp.play(bipSound,1, 1, 0, 0, 1);
                Intent in = new Intent(this, IntroTextForAllActivity.class);
                in.putExtra("IntroText", R.string.Intro1Text2);
                in.putExtra("ImageToLoad", R.drawable.test2_intro_pic);
                in.putExtra("TestNum", 2);
                in.putExtra("IntroReading", R.raw.zvukpravilno);
                startActivity(in);


                break;
            }
            case R.id.btnGame3: {
                sp.play(bipSound,1, 1, 0, 0, 1);
                Intent in = new Intent(this, IntroTextForAllActivity.class);
                in.putExtra("IntroText", (R.string.Intro1Text3));
                in.putExtra("ImageToLoad", R.drawable.a_example);
                in.putExtra("TestNum", 3);
                in.putExtra("IntroReading", R.raw.zvukpravilno);
                startActivity(in);
            }

            break;
            case R.id.btnGame4: {
                sp.play(bipSound,1, 1, 0, 0, 1);
                Intent in = new Intent(this, IntroTextForAllActivity.class);
                in.putExtra("IntroText", (R.string.Intro1Text4));
                in.putExtra("TestNum", 4);
                in.putExtra("ImageToLoad", R.drawable.buttons_example);
                in.putExtra("IntroReading", R.raw.zvukpravilno);
                startActivity(in);


                break;
            }
            case R.id.btnGame5: {
                sp.play(bipSound,1, 1, 0, 0, 1);
                Intent in = new Intent(this, IntroTextForAllActivity.class);
                in.putExtra("IntroText", (R.string.Intro1Text5));
                in.putExtra("TestNum", 5);
                in.putExtra("ImageToLoad", R.drawable.pear_main);
                in.putExtra("IntroReading", R.raw.zvukpravilno);
                startActivity(in);


                break;
            }
            case R.id.btnGame6: {
                sp.play(bipSound,1, 1, 0, 0, 1);
                Intent in = new Intent(this, IntroTextForAllActivity.class);
                in.putExtra("IntroText", (R.string.Intro1Text3));
                in.putExtra("TestNum", 3);
                in.putExtra("IntroReading", R.raw.zvukpravilno);
                startActivity(in);



                break;
            }
            case R.id.btnGame7: {

            ifTest=true;

                Intent in = new Intent(this, IntroTextForAllActivity.class);
                in.putExtra("IntroText", (R.string.Intro1Text3));
                in.putExtra("ImageToLoad", R.drawable.a_example);
                in.putExtra("TestNum", 3);
                in.putExtra("IntroReading", R.raw.zvukpravilno);
                startActivity(in);

                break;
            }
        }
    }
}
