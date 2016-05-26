package com.dev.sigma77.kidslearning;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.dev.sigma77.kidslearning.R;
import com.dev.sigma77.kidslearning.util.Transition;
import com.dev.sigma77.kidslearning.util.TransitionParams;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by user on 25.5.2016 г..
 */
public class MethodsFor10AnswersActivitys extends Activity implements View.OnClickListener{
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10;
    SoundPool sp;

    static Map<Integer, Integer> intPicList = new HashMap<>();
    Map<Integer, Integer> buttonMap = new HashMap<>();
    private static ImageView pic;
    private static int currentPic;
    private int correctSound;
    private int wrongSound;
    private int correctAnswers, currentGamePoints = 0;
    static int game = 1;
    private int testNum;
    String gameName;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);

        initiateButtons();


        setOnClickListeners();
        Intent mIntent = getIntent();
        testNum = mIntent.getIntExtra("TestNum", 0);
        gameName=mIntent.getStringExtra("GameName");

if(gameName.equals("Digit")) {
    populatePicList(R.drawable.digit1, R.drawable.digit2, R.drawable.digit3, R.drawable.digit4, R.drawable.digit5,
            R.drawable.digit6, R.drawable.digit7, R.drawable.digit8, R.drawable.digit9, R.drawable.digit10);
}
      else  if(gameName.equals("Fingers")) {
            populatePicList(R.drawable.count_on_fingers_01, R.drawable.count_on_fingers_02, R.drawable.count_on_fingers_03, R.drawable.count_on_fingers_04, R.drawable.count_on_fingers_05,
                    R.drawable.count_on_fingers_06, R.drawable.count_on_fingers_07, R.drawable.count_on_fingers_08, R.drawable.count_on_fingers_09, R.drawable.count_on_fingers_10);
        }
else  if(gameName.equals("Squares")) {
    populatePicList(R.drawable.squares1, R.drawable.squares2, R.drawable.squares3, R.drawable.squares4, R.drawable.squares5,
            R.drawable.squares6, R.drawable.squares7, R.drawable.squares8, R.drawable.squares9, R.drawable.squares10);
}
else  if(gameName.equals("NextDigit")) {
    populatePicList(R.drawable.next_digit1, R.drawable.next_digit2, R.drawable.next_digit3, R.drawable.next_digit4, R.drawable.next_digit5,
            R.drawable.next_digit6, R.drawable.next_digit7, R.drawable.next_digit8, R.drawable.next_digit9, R.drawable.next_digit10);
}


        populateButtonMap();


        sp = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        correctSound = sp.load(this, R.raw.zvukpravilno, 1);
        wrongSound = sp.load(this, R.raw.zvukgreshka, 1);

        setVolumeControlStream(AudioManager.STREAM_MUSIC);


        getRandomPic();
}

   public void populateButtonMap() {
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
    }

    public void populatePicList(int pic1,int pic2,int pic3,int pic4,int pic5,int pic6,int pic7,int pic8,int pic9,int pic10
                                ) {
        intPicList.put(1, pic1);
        intPicList.put(2, pic2);
        intPicList.put(3, pic3);
        intPicList.put(4, pic4);
        intPicList.put(5, pic5);
        intPicList.put(6, pic6);
        intPicList.put(7, pic7);
        intPicList.put(8, pic8);
        intPicList.put(9, pic9);
        intPicList.put(10, pic10);
    }

    public void setOnClickListeners() {
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
    }

    private void initiateButtons() {
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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_count, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        int selectedButtonId = v.getId();
        int btnNumber = buttonMap.get(selectedButtonId);

        checkAnswer(btnNumber);

    }
    public  void changePic(int picNum) {
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

            TransitionParams transitionParams = new TransitionParams();
            transitionParams.setIsEnd(isEnd);
            transitionParams.setpActivity(this);
            transitionParams.setTestNumber(testNum);
            transitionParams.setpCorrectAnswers(correctAnswers);
            transitionParams.setpCurrentGamePoints(currentGamePoints);
            Transition.toNextActivity(transitionParams);

        } else {
            getRandomPic();
        }


    }
    public   void getRandomPic() {
        Random rnd = new Random();
        int randomPicPos = rnd.nextInt(10) + 1;
        while (!intPicList.containsKey(randomPicPos)) {
            randomPicPos = rnd.nextInt(10) + 1;
        }
        // int randomPic = intPicList.get(randomPicPos);
        changePic(randomPicPos);
    }
}
