package com.dev.sigma77.kidslearning;

import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.dev.sigma77.kidslearning.util.Transition;
import com.dev.sigma77.kidslearning.util.TransitionParams;

import java.util.Arrays;

public class SimilarityActivity extends AppCompatActivity implements View.OnClickListener{
    ImageButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16;
    int numAnswers,sceneNum=1,correctSound,wrongSound,endSound;
    ImageButton[] correctAnswersBtns =new ImageButton[4];
    ImageButton[] allButtons=new ImageButton[16];
    int[]scene1Pics={R.drawable.similar1,R.drawable.similar2,R.drawable.similar3,R.drawable.similar4,
                     R.drawable.similar21,R.drawable.similar22,R.drawable.similar23,R.drawable.similar24,
                     R.drawable.similar31,R.drawable.similar32,R.drawable.similar33,R.drawable.similar34,
                     R.drawable.similar41,R.drawable.similar42,R.drawable.similar43,R.drawable.similar44};
    int[]scene2Pics={R.drawable.similar51,R.drawable.similar52,R.drawable.similar53,R.drawable.similar54,
            R.drawable.similar61,R.drawable.similar62,R.drawable.similar63,R.drawable.similar64,
            R.drawable.similar71,R.drawable.similar72,R.drawable.similar73,R.drawable.similar74,
            R.drawable.similar81,R.drawable.similar82,R.drawable.similar83,R.drawable.similar84};
   ImageButton pressedBtn = null;
    SoundPool sp;
   int  correctAnswers=0;
    int currentGamePoints = 0;
    int btnIndex;
    private int testNum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_similarity);
        btn1= (ImageButton) findViewById(R.id.btn1);
        btn2= (ImageButton) findViewById(R.id.btn2);
        btn3= (ImageButton) findViewById(R.id.btn3);
        btn4= (ImageButton) findViewById(R.id.btn4);
        btn5= (ImageButton) findViewById(R.id.btn5);
        btn6= (ImageButton) findViewById(R.id.btn6);
        btn7= (ImageButton) findViewById(R.id.btn7);
        btn8= (ImageButton) findViewById(R.id.btn8);
        btn9= (ImageButton) findViewById(R.id.btn9);
        btn10= (ImageButton) findViewById(R.id.btn10);
        btn11= (ImageButton) findViewById(R.id.btn11);
        btn12= (ImageButton) findViewById(R.id.btn12);
        btn13= (ImageButton) findViewById(R.id.btn13);
        btn14= (ImageButton) findViewById(R.id.btn14);
        btn15= (ImageButton) findViewById(R.id.btn15);
        btn16= (ImageButton) findViewById(R.id.btn16);
        allButtons[0]=btn1;
        allButtons[1]=btn2;
        allButtons[2]=btn3;
        allButtons[3]=btn4;
        allButtons[4]=btn5;
        allButtons[5]=btn6;
        allButtons[6]=btn7;
        allButtons[7]=btn8;
        allButtons[8]=btn9;
        allButtons[9]=btn10;
        allButtons[10]=btn11;
        allButtons[11]=btn12;
        allButtons[12]=btn13;
        allButtons[13]=btn14;
        allButtons[14]=btn15;
        allButtons[15]=btn16;


        sp = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        correctSound = sp.load(this, R.raw.zvukpravilno, 1);
        wrongSound = sp.load(this, R.raw.zvukgreshka, 1);
        endSound = sp.load(this, R.raw.endmussic, 1);

        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);

        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);

        btn10.setOnClickListener(this);
        btn11.setOnClickListener(this);
        btn12.setOnClickListener(this);

        btn14.setOnClickListener(this);
        btn15.setOnClickListener(this);
        btn16.setOnClickListener(this);
        loadScenePic(sceneNum);
        setCorrectAnswers(sceneNum);
        Intent mIntent = getIntent();
        testNum = mIntent.getIntExtra("TestNum", 0);
    }

    public void  loadScenePic (int sceneNum){
        switch (sceneNum){
            case 1:{
                for(int i=0;i<16;i++){
                    allButtons[i].setImageResource(scene1Pics[i]);
                    if(i!=0|| i!=4||i!=8 ||i!=12){
                    allButtons[i].setBackgroundColor(Color.WHITE);
                    }

                }

//                btn1.setImageResource(R.drawable.similar1);
//                btn2.setImageResource(R.drawable.similar2);
//                btn3.setImageResource(R.drawable.similar3);
//                btn4.setImageResource(R.drawable.similar4);
//                btn5.setImageResource(R.drawable.similar21);
//                btn6.setImageResource(R.drawable.similar22);
//                btn7.setImageResource(R.drawable.similar23);
//                btn8.setImageResource(R.drawable.similar24);
//                btn9.setImageResource(R.drawable.similar31);
//                btn10.setImageResource(R.drawable.similar32);
//                btn11.setImageResource(R.drawable.similar33);
//                btn12.setImageResource(R.drawable.similar34);
//                btn13.setImageResource(R.drawable.similar41);
//                btn14.setImageResource(R.drawable.similar42);
//                btn15.setImageResource(R.drawable.similar43);
//                btn16.setImageResource(R.drawable.similar44);
            }
            break;
            case 2:{
                for(int i=0;i<16;i++){
                    allButtons[i].setImageResource(scene2Pics[i]);

                    if(i!=0|| i!=4||i!=8 ||i!=12){
                        allButtons[i].setBackgroundColor(Color.WHITE);
                    allButtons[i].setClickable(true);
                    }

                }
//                btn1.setImageResource(R.drawable.similar51);
//                btn2.setImageResource(R.drawable.similar52);
//                btn3.setImageResource(R.drawable.similar53);
//                btn4.setImageResource(R.drawable.similar54);
//                btn5.setImageResource(R.drawable.similar61);
//                btn6.setImageResource(R.drawable.similar62);
//                btn7.setImageResource(R.drawable.similar63);
//                btn8.setImageResource(R.drawable.similar64);
//                btn9.setImageResource(R.drawable.similar71);
//                btn10.setImageResource(R.drawable.similar72);
//                btn11.setImageResource(R.drawable.similar73);
//                btn12.setImageResource(R.drawable.similar74);
//                btn13.setImageResource(R.drawable.similar81);
//                btn14.setImageResource(R.drawable.similar82);
//                btn15.setImageResource(R.drawable.similar83);
//                btn16.setImageResource(R.drawable.similar84);
            }
            break;
        }


    }
    public void setCorrectAnswers(int sceneNum){
        switch (sceneNum){
            case 1:{
                correctAnswersBtns[0]=btn4;
                correctAnswersBtns[1]=btn7;
                correctAnswersBtns[2]=btn12;
                correctAnswersBtns[3]=btn15;
            }
            break;
            case 2:{
                correctAnswersBtns[0]=btn4;
                correctAnswersBtns[1]=btn6;
                correctAnswersBtns[2]=btn10;
                correctAnswersBtns[3]=btn14;
            }
            break;



        }
    }

    @Override
    public void onClick(View v) {
        int answer=v.getId();


        switch (v.getId()) {

            case R.id.btn1: {
                pressedBtn = btn1;
                btnIndex = 1;

                break;
            }
            case R.id.btn2: {
                pressedBtn = btn2;
                btnIndex = 2;
                break;
            }
            case R.id.btn3: {
                pressedBtn = btn3;
                btnIndex = 3;
                break;
            }
            case R.id.btn4: {
                pressedBtn = btn4;
                btnIndex = 4;
                break;
            }
            case R.id.btn5: {
                pressedBtn = btn5;
                btnIndex = 5;
                break;
            }
            case R.id.btn6: {
                pressedBtn = btn6;
                btnIndex = 6;
                break;
            }
            case R.id.btn7: {
                pressedBtn = btn7;
                btnIndex = 7;
                break;
            }
            case R.id.btn8: {
                pressedBtn = btn8;
                btnIndex = 8;
                break;
            }
            case R.id.btn9: {
                pressedBtn = btn9;
                btnIndex = 9;
                break;
            }
            case R.id.btn10: {
                pressedBtn = btn10;
                btnIndex = 10;
                break;
            }
            case R.id.btn11: {
                pressedBtn = btn11;
                btnIndex = 11;
                break;
            }

            case R.id.btn12: {
                pressedBtn = btn12;
                btnIndex = 12;
                break;
            }
            case R.id.btn13: {
                pressedBtn = btn13;
                btnIndex = 13;
                break;
            }
            case R.id.btn14: {
                pressedBtn = btn14;
                btnIndex = 14;
                break;
            }
            case R.id.btn15: {
                pressedBtn = btn15;
                btnIndex = 15;
                break;
            }
            case R.id.btn16: {
                pressedBtn = btn16;
                btnIndex = 16;
                break;
            }
        }
        checkAnswer(pressedBtn);
        disableRowBtns();
        numAnswers++;

    }
    public void disableRowBtns(){
        switch(btnIndex){
            case 2:
            case 3:
            case 4:{
                btn2.setClickable(false);
                btn3.setClickable(false);
                btn4.setClickable(false);

                break;
            }
            case 6:
            case 7:
            case 8:{
                btn6.setClickable(false);
                btn7.setClickable(false);
                btn8.setClickable(false);

                break;
            }
            case 10:
            case 11:
            case 12:{
                btn10.setClickable(false);
                btn11.setClickable(false);
                btn12.setClickable(false);

                break;
            }
            case 14:
            case 15:
            case 16:{
                btn14.setClickable(false);
                btn15.setClickable(false);
                btn16.setClickable(false);

                break;
            }
        }
    }

    private void checkAnswer(ImageButton pressedBtn) {
        if (!Arrays.asList(correctAnswersBtns).contains(pressedBtn)) {
            pressedBtn.setBackgroundColor(Color.RED);

            sp.play(wrongSound, 1, 1, 0, 0, 1);

        } else {
            pressedBtn.setBackgroundColor(Color.GREEN);

            sp.play(correctSound, 1, 1, 0, 0, 1);

            correctAnswers++;

        }
        if(numAnswers>=4){
            boolean isEnd = true;
            if(!MainActivity.isTest||sceneNum<2){
                sceneNum++;
                loadScenePic(sceneNum);
                setCorrectAnswers(sceneNum);
                numAnswers=0;
            }
            else {
                if(correctAnswers==4){
                    currentGamePoints = 1;
                }
                TransitionParams transitionParams = new TransitionParams();
                transitionParams.setIsEnd(isEnd);
                transitionParams.setpActivity(this);
                transitionParams.setTestNumber(testNum);
                transitionParams.setpCorrectAnswers(correctAnswers);
                transitionParams.setpCurrentGamePoints(currentGamePoints);
                Transition.toNextActivity(transitionParams);
                //finish();
            }



        }
    }
}
