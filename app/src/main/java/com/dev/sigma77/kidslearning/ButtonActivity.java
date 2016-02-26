package com.dev.sigma77.kidslearning;

import android.app.Activity;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class ButtonActivity extends Activity implements View.OnClickListener {


    SoundPool sp;
    Button check;
    boolean isEnd;
    int numofAnswers, correctAnswers,currentGamePoints= 0,correctSound, wrongSound, endSound,clickAnswerSound;
    ImageButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11,
            btn12, btn13, btn14, btn15, btn16;

    Map<Integer, ImageButton> buttonMap = new HashMap<>();
    Set<Integer> correctAnswersSet = new HashSet<>();
      static int game=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        btn1 = (ImageButton) findViewById(R.id.imageButton1);
        btn2 = (ImageButton) findViewById(R.id.imageButton2);
        btn3 = (ImageButton) findViewById(R.id.imageButton3);
        btn4 = (ImageButton) findViewById(R.id.imageButton4);
        check = (Button) findViewById(R.id.btnCheck);
        btn5 = (ImageButton) findViewById(R.id.imageButton5);
        btn6 = (ImageButton) findViewById(R.id.imageButton6);
        btn7 = (ImageButton) findViewById(R.id.imageButton7);
        btn8 = (ImageButton) findViewById(R.id.imageButton8);
        btn9 = (ImageButton) findViewById(R.id.imageButton9);
        btn10 = (ImageButton) findViewById(R.id.imageButton10);
        btn11 = (ImageButton) findViewById(R.id.imageButton11);
        btn12 = (ImageButton) findViewById(R.id.imageButton12);
        btn13 = (ImageButton) findViewById(R.id.imageButton13);
        btn14 = (ImageButton) findViewById(R.id.imageButton14);
        btn15 = (ImageButton) findViewById(R.id.imageButton15);
        btn16 = (ImageButton) findViewById(R.id.imageButton16);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn10.setOnClickListener(this);
        btn11.setOnClickListener(this);
        btn12.setOnClickListener(this);
        btn13.setOnClickListener(this);
        btn14.setOnClickListener(this);
        btn15.setOnClickListener(this);
        btn16.setOnClickListener(this);
        check.setOnClickListener(this);

        buttonMap.put(R.id.imageButton1, btn1);
        buttonMap.put(R.id.imageButton2, btn2);
        buttonMap.put(R.id.imageButton3, btn3);
        buttonMap.put(R.id.imageButton4, btn4);
        buttonMap.put(R.id.imageButton5, btn5);
        buttonMap.put(R.id.imageButton6, btn6);
        buttonMap.put(R.id.imageButton7, btn7);
        buttonMap.put(R.id.imageButton8, btn8);
        buttonMap.put(R.id.imageButton9, btn9);
        buttonMap.put(R.id.imageButton10, btn10);
        buttonMap.put(R.id.imageButton11, btn11);
        buttonMap.put(R.id.imageButton12, btn12);
        buttonMap.put(R.id.imageButton13, btn13);
        buttonMap.put(R.id.imageButton14, btn14);
        buttonMap.put(R.id.imageButton15, btn15);
        buttonMap.put(R.id.imageButton16, btn16);


        sp = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        correctSound = sp.load(this, R.raw.zvukpravilno, 1);
        wrongSound = sp.load(this, R.raw.zvukgreshka, 1);
        endSound = sp.load(this, R.raw.endmussic, 1);
        clickAnswerSound= sp.load(this, R.raw.sound, 1);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        if(game==1){
            correctAnswersSet.add(R.id.imageButton15);
            correctAnswersSet.add(R.id.imageButton9);
            correctAnswersSet.add(R.id.imageButton4);
        }
        if(game==2){
            correctAnswersSet.add(R.id.imageButton2);
            correctAnswersSet.add(R.id.imageButton8);
            correctAnswersSet.add(R.id.imageButton14);
            setGame2();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_button, menu);
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
    public void onClick(View v) {
        int selectedButtonId = v.getId();

        switch (selectedButtonId) {


//
            case R.id.btnCheck: {

                isEnd=true;
                if (correctAnswers == 3) {
                    currentGamePoints = 1;
                    sp.play(correctSound, 1, 1, 0, 0, 1);
                } else {
                    sp.play(wrongSound, 1, 1, 0, 0, 1);
                }
                setAnswerBgrColor();
                break;
            }

            default:{
                sp.play(clickAnswerSound, 1, 1, 0, 0, 1);
                ImageButton selectedButton = buttonMap.get(selectedButtonId);
                setBgrGrey(selectedButton);
                if(correctAnswersSet.contains(selectedButtonId)){
                    correctAnswers++;
                }
            }


        }

    }
    public void setGame2(){

        btn8.setImageResource(R.drawable.button2);
        btn4.setImageResource(R.drawable.button8);
        btn14.setImageResource(R.drawable.button2);
    }

    private void setAnswerBgrColor() {
        if (numofAnswers >= 3) {
            if (game==1){
                btn4.setBackgroundResource(R.drawable.shapes4);
                btn9.setBackgroundResource(R.drawable.shapes4);
                btn15.setBackgroundResource(R.drawable.shapes4);
            }
            else if(game==2){
                btn2.setBackgroundResource(R.drawable.shapes4);
                btn8.setBackgroundResource(R.drawable.shapes4);
                btn14.setBackgroundResource(R.drawable.shapes4);

            }

            new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                    }
                }, 4700);

            if(MainActivity.isTest == true){isEnd=true;
              ResultActivity.isLastTest=true;

            }else {
             //   new Handler().postDelayed(new RunnableShowAnswers(this,MainActivity.class), 4700);
            }
            //btn15.setBackgroundColor(getResources().getColor(R.color.green));
            new Handler().postDelayed(new ShowResults(this, correctAnswers,currentGamePoints,isEnd), 2000);
        }
    }

    public void setBgrGrey(ImageButton btn) {
        if (numofAnswers < 3) {
            numofAnswers++;
            //btn.setBackgroundColor(getResources().getColor(R.color.material_deep_teal_200));
            btn.setBackgroundResource(R.drawable.shapes2);
        }

    }
}
