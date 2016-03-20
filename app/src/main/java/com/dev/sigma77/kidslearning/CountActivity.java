package com.dev.sigma77.kidslearning;

import android.app.Activity;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.dev.sigma77.kidslearning.util.TransitionParams;
import com.dev.sigma77.kidslearning.util.Transition;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class CountActivity extends Activity implements View.OnClickListener {
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10;
    SoundPool sp;

    Map<Integer, Integer> intPicList = new HashMap<>();
    Map<Integer, Integer> buttonMap = new HashMap<>();
    private ImageView pic;
    private int currentPic, correctSound, wrongSound;
    private int correctAnswers, currentGamePoints = 0;
    static int game = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);
        btn0 = (Button) findViewById(R.id.button0);
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn5 = (Button) findViewById(R.id.button5);
        btn6 = (Button) findViewById(R.id.button6);
        btn7 = (Button) findViewById(R.id.button7);
        btn8 = (Button) findViewById(R.id.button8);
        btn9 = (Button) findViewById(R.id.button9);
        btn10 = (Button) findViewById(R.id.button10);
        pic = (ImageView) findViewById(R.id.imageView);


        btn0.setOnClickListener(this);
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


        intPicList.put(1, R.drawable.count_on_fingers_01);
        intPicList.put(2, R.drawable.count_on_fingers_02);
        intPicList.put(3, R.drawable.count_on_fingers_03);
        intPicList.put(4, R.drawable.count_on_fingers_04);
        intPicList.put(5, R.drawable.count_on_fingers_05);
        intPicList.put(6, R.drawable.count_on_fingers_06);
        intPicList.put(7, R.drawable.count_on_fingers_07);
        intPicList.put(8, R.drawable.count_on_fingers_08);
        intPicList.put(9, R.drawable.count_on_fingers_09);
        intPicList.put(10, R.drawable.count_on_fingers_10);
        buttonMap.put(R.id.button0, 0);
        buttonMap.put(R.id.button1, 1);
        buttonMap.put(R.id.button2, 2);
        buttonMap.put(R.id.button3, 3);
        buttonMap.put(R.id.button4, 4);
        buttonMap.put(R.id.button5, 5);
        buttonMap.put(R.id.button6, 6);
        buttonMap.put(R.id.button7, 7);
        buttonMap.put(R.id.button8, 8);
        buttonMap.put(R.id.button9, 9);
        buttonMap.put(R.id.button10, 10);


        getRandomPic();
        sp = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        correctSound = sp.load(this, R.raw.zvukpravilno, 1);
        wrongSound = sp.load(this, R.raw.zvukgreshka, 1);

        setVolumeControlStream(AudioManager.STREAM_MUSIC);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_count, menu);
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
        int btnNumber = buttonMap.get(selectedButtonId);

        checkAnswer(btnNumber);
    }

    public void changePic(int picNum) {
        int number = intPicList.get(picNum);
        pic.setImageResource(number);

        currentPic = picNum;
    }

    public void checkAnswer(int answerNum) {
        int answer = answerNum;
        if (game == 2) {

            if (currentPic < 6) {
                answer = 5 - answer;
            } else if (currentPic == 5 && answerNum == 0) {
                answer = 5;
            } else if (currentPic == 10 && answerNum == 0) {
                answer = 10;
            } else {
                answer = 10 - answer;
            }

        }


        if (currentPic == answer) {
            correctAnswers++;
            sp.play(correctSound, 1, 1, 0, 0, 1);
        } else {
            sp.play(wrongSound, 1, 1, 0, 0, 1);
        }
        intPicList.remove(currentPic);
        if (intPicList.size() <= 0) {
            boolean isEnd = true;
            btn1.setClickable(false);
            btn2.setClickable(false);
            btn3.setClickable(false);
            btn4.setClickable(false);
            btn5.setClickable(false);
            btn6.setClickable(false);
            btn7.setClickable(false);
            btn8.setClickable(false);
            btn9.setClickable(false);
            btn10.setClickable(false);
            if (correctAnswers == 10) {
                currentGamePoints = 1;
            }

            TransitionParams tansitionParams = new TransitionParams();
            tansitionParams.setIsEnd(isEnd);
            tansitionParams.setpActivity(this);
            tansitionParams.setpIntroTextId(R.string.Intro1Text2);
            tansitionParams.setpIntroPicId(R.drawable.test2_intro_pic);
            tansitionParams.setpExerciseNumber(2);
            tansitionParams.setpIntroTalk(R.raw.zvukpravilno);
            tansitionParams.setpCorrectAnswers(correctAnswers);
            tansitionParams.setpCurrentGamePoints(currentGamePoints);
            Transition.toNextActivity(tansitionParams);

        } else {
            getRandomPic();
        }


    }


    public void getRandomPic() {
        Random rnd = new Random();
        int randomPicPos = rnd.nextInt(10) + 1;
        while (!intPicList.containsKey(randomPicPos)) {
            randomPicPos = rnd.nextInt(10) + 1;
        }
        // int randomPic = intPicList.get(randomPicPos);
        changePic(randomPicPos);
    }
}
