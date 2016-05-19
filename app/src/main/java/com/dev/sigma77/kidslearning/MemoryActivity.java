package com.dev.sigma77.kidslearning;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MemoryActivity extends Activity implements View.OnClickListener {
    ImageButton btn1,btn2,btn3,btn4, btn5,btn6,btn7,btn8,btn9,btn10,
            btn11,btn12,btn13,btn14, btn15,btn16,btn17,btn18,btn19,btn20,
            btn21,btn22,btn23,btn24, btn25,btn26,btn27,btn28,btn29,btn30;
    Map<Integer, Integer> intAllPicList = new HashMap<>();
    Map<Integer, Integer> buttonsWithSetPics = new HashMap<>();
    Map<Integer, Integer> correctAnswersPics = new HashMap<>();
    ImageButton[] buttonsList =new ImageButton[12];
    ImageButton[] allButtonsList =new ImageButton[30];
    TextView countAnswers;
    SoundPool sp;
    int correctSound, wrongSound, endSound,clickAnswerSound;
    public static int currentGamePoints = 0, correctAnswers = 0;
    int count=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);
        btn1 = (ImageButton) findViewById(R.id.imageButton1);
        btn2 = (ImageButton) findViewById(R.id.imageButton2);
        btn3 = (ImageButton) findViewById(R.id.imageButton3);
        btn4 = (ImageButton) findViewById(R.id.imageButton4);
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
        btn17 = (ImageButton) findViewById(R.id.imageButton17);
        btn18 = (ImageButton) findViewById(R.id.imageButton18);
        btn19 = (ImageButton) findViewById(R.id.imageButton19);
        btn20 = (ImageButton) findViewById(R.id.imageButton20);
        btn21 = (ImageButton) findViewById(R.id.imageButton21);
        btn22 = (ImageButton) findViewById(R.id.imageButton22);
        btn23 = (ImageButton) findViewById(R.id.imageButton23);
        btn24 = (ImageButton) findViewById(R.id.imageButton24);
        btn25 = (ImageButton) findViewById(R.id.imageButton25);
        btn26 = (ImageButton) findViewById(R.id.imageButton26);
        btn27 = (ImageButton) findViewById(R.id.imageButton27);
        btn28 = (ImageButton) findViewById(R.id.imageButton28);
        btn29 = (ImageButton) findViewById(R.id.imageButton29);
        btn30 = (ImageButton) findViewById(R.id.imageButton30);

        countAnswers = (TextView) findViewById(R.id.countAnswers);

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
        btn17.setOnClickListener(this);
        btn18.setOnClickListener(this);
        btn19.setOnClickListener(this);
        btn20.setOnClickListener(this);
        btn21.setOnClickListener(this);
        btn22.setOnClickListener(this);
        btn23.setOnClickListener(this);
        btn24.setOnClickListener(this);
        btn25.setOnClickListener(this);
        btn26.setOnClickListener(this);
        btn27.setOnClickListener(this);
        btn28.setOnClickListener(this);
        btn29.setOnClickListener(this);
        btn30.setOnClickListener(this);
        intAllPicList.put(1, R.drawable.zapomni1);
        intAllPicList.put(2, R.drawable.zapomni2);
        intAllPicList.put(3, R.drawable.zapomni3);
        intAllPicList.put(4, R.drawable.zapomni4);
        intAllPicList.put(5, R.drawable.zapomni5);
        intAllPicList.put(6, R.drawable.zapomni6);
        intAllPicList.put(7, R.drawable.zapomni7);
        intAllPicList.put(8, R.drawable.zapomni8);
        intAllPicList.put(9, R.drawable.zapomni9);
        intAllPicList.put(10, R.drawable.zapomni10);
        intAllPicList.put(11, R.drawable.zapomni11);
        intAllPicList.put(12,R.drawable.zapomni12);
        intAllPicList.put(13, R.drawable.zapomni13);
        intAllPicList.put(14, R.drawable.zapomni14);
        intAllPicList.put(15, R.drawable.zapomni15);
        intAllPicList.put(16,R.drawable.zapomni16);
        intAllPicList.put(17,R.drawable.zapomni17);
        intAllPicList.put(18, R.drawable.zapomni18);
        intAllPicList.put(19,R.drawable.zapomni19);
        intAllPicList.put(20,R.drawable.zapomni20);
        intAllPicList.put(21, R.drawable.zapomni21);
        intAllPicList.put(22,R.drawable.zapomni22);
        intAllPicList.put(23,R.drawable.zapomni23);
        intAllPicList.put(24,R.drawable.zapomni24);
        intAllPicList.put(25,R.drawable.zapomni25);
        intAllPicList.put(26,R.drawable.zapomni26);
        intAllPicList.put(27,R.drawable.zapomni27);
        intAllPicList.put(28,R.drawable.zapomni28);
        intAllPicList.put(29,R.drawable.zapomni29);
        intAllPicList.put(30, R.drawable.zapomni30);
        buttonsList[0]=btn7;
        buttonsList[1]=btn8;
        buttonsList[2]=btn9;
        buttonsList[3]=btn12;
        buttonsList[4]=btn13;
        buttonsList[5]=btn14;
        buttonsList[6]=btn17;
        buttonsList[7]=btn18;
        buttonsList[8]=btn19;
        buttonsList[9]=btn22;
        buttonsList[10]=btn23;
        buttonsList[11]=btn24;

        allButtonsList[0]=btn1;
        allButtonsList[1]=btn2;
        allButtonsList[2]=btn3;
        allButtonsList[3]=btn4;
        allButtonsList[4]=btn5;
        allButtonsList[5]=btn6;
        allButtonsList[6]=btn7;
        allButtonsList[7]=btn8;
        allButtonsList[8]=btn9;
        allButtonsList[9]=btn10;
        allButtonsList[10]=btn11;
        allButtonsList[11]=btn12;
        allButtonsList[12]=btn13;
        allButtonsList[13]=btn14;
        allButtonsList[14]=btn15;
        allButtonsList[15]=btn16;
        allButtonsList[16]=btn17;
        allButtonsList[17]=btn18;
        allButtonsList[18]=btn19;
        allButtonsList[19]=btn20;
        allButtonsList[20]=btn21;
        allButtonsList[21]=btn22;
        allButtonsList[22]=btn23;
        allButtonsList[23]=btn24;
        allButtonsList[24]=btn25;
        allButtonsList[25]=btn26;
        allButtonsList[26]=btn27;
        allButtonsList[27]=btn28;
        allButtonsList[28]=btn29;
        allButtonsList[29]=btn30;
        btn1. setEnabled(false);
        btn2. setEnabled(false);
        btn3. setEnabled(false);
        btn4. setEnabled(false);
        btn5. setEnabled(false);
        for(int i=0;i<30;i++){
            allButtonsList[i].setEnabled(false);
        }


        sp = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        correctSound = sp.load(this, R.raw.zvukpravilno, 1);
        wrongSound = sp.load(this, R.raw.zvukgreshka, 1);
        endSound = sp.load(this, R.raw.endmussic, 1);
        clickAnswerSound= sp.load(this, R.raw.sound, 1);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        generateCorrectAnswers();

countAnswers.setText(Integer.toString(count));
    }

    public void generateCorrectAnswers(){
        for(int i=0;i<12;i++){
            Random rnd = new Random();
            int randomPicPos = rnd.nextInt(30) + 1;
            while (correctAnswersPics.containsValue(intAllPicList.get(randomPicPos))) {
                randomPicPos = rnd.nextInt(30) + 1;
            }

            correctAnswersPics.put(i, intAllPicList.get(randomPicPos));

        }
        setImagesToRemember();
    }
    public void setImagesToRemember(){
        for(int i=0; i<12; i++){

   buttonsList[i].setImageResource(correctAnswersPics.get(i));
            buttonsList[i].setTag(correctAnswersPics.get(i));

        }
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
//                Intent in=new Intent(MemoryActivity.this,MemoryActivity.class);
//                startActivity(in);
                setAllImages();
            }
        }, 30000);

    }
    public void setAllImages(){
        for(int i=0;i<30;i++){
            Random rnd = new Random();
            int randomPicPos = rnd.nextInt(30) + 1;
            while (buttonsWithSetPics.containsValue(intAllPicList.get(randomPicPos))) {
                randomPicPos = rnd.nextInt(30) + 1;
            }
            // int randomPic = intPicList.get(randomPicPos);
            buttonsWithSetPics.put(i, intAllPicList.get(randomPicPos));
            allButtonsList[i].setImageResource(intAllPicList.get(randomPicPos));
            allButtonsList[i].setTag(intAllPicList.get(randomPicPos));
            //allButtonsList[i].setClickable(true);
            allButtonsList[i].setEnabled(true);

        }


    }
    private void putExtraStartResultActivity() {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("GamePoints", currentGamePoints);
        intent.putExtra("CorrectAnswers", correctAnswers);
        startActivity(intent);
    }


    @Override
    public void onClick(View v) {





        if((correctAnswersPics.containsValue(v.getTag()))){

            v.setBackgroundColor(Color.GREEN);
            sp.play(correctSound, 1, 1, 0, 0, 1);
            correctAnswers++;

        }
        else {
            v.setBackgroundColor(Color.RED);
            sp.play(wrongSound, 1, 1, 0, 0, 1);
        }
       count++;
        int answersLeft=12-count;
        countAnswers.setText(Integer.toString(answersLeft));
        if(count>=12) {

            if (correctAnswers == 12) {
                currentGamePoints = 1;
            }
            putExtraStartResultActivity();
            finish();
        }

    }
}
