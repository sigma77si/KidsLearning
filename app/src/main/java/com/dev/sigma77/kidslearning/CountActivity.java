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
import android.widget.ImageView;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;


public class CountActivity extends Activity implements View.OnClickListener {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10;
    SoundPool sp;
    //  private int listSize=10;
    Map<Integer, Integer> intPicList = new HashMap<>();
    private ImageView pic;
    private int currentPic, correctSound, wrongSound, endSound;
    private int corectAnswers = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);
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


        intPicList.put(1, 1);
        intPicList.put(2, 2);
        intPicList.put(3, 3);
        intPicList.put(4, 4);
        intPicList.put(5, 5);
        intPicList.put(6, 6);
        intPicList.put(7, 7);
        intPicList.put(8, 8);
        intPicList.put(9, 9);
        intPicList.put(10, 10);

        getRandomPic();
        sp = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        correctSound = sp.load(this, R.raw.zvukpravilno, 1);
        wrongSound = sp.load(this, R.raw.zvukgreshka, 1);
        endSound = sp.load(this, R.raw.endmussic, 1);


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
        int btnNumber = 0;
        switch (v.getId()) {


            case R.id.button1: {
                btnNumber = 1;
                break;
            }
            case R.id.button2: {
                btnNumber = 2;
                break;
            }
            case R.id.button3: {
                btnNumber = 3;
                break;
            }
            case R.id.button4: {
                btnNumber = 4;
                break;
            }
            case R.id.button5: {
                btnNumber = 5;
                break;
            }
            case R.id.button6: {
                btnNumber = 6;
                break;
            }
            case R.id.button7: {
                btnNumber = 7;
                break;
            }
            case R.id.button8: {
                btnNumber = 8;
                break;
            }
            case R.id.button9: {
                btnNumber = 9;
                break;
            }
            case R.id.button10: {
                btnNumber = 10;
                break;
            }
        }
        checkAnswer(btnNumber);
    }

    public void chengePic(int picNum) {
        switch (picNum) {
            case 1: {
                pic.setImageResource(R.drawable.count_on_fingers_01);
                break;
            }
            case 2: {
                pic.setImageResource(R.drawable.count_on_fingers_02);
                break;
            }
            case 3: {
                pic.setImageResource(R.drawable.count_on_fingers_03);
                break;
            }
            case 4: {
                pic.setImageResource(R.drawable.count_on_fingers_04);
                break;
            }
            case 5: {
                pic.setImageResource(R.drawable.count_on_fingers_05);
                break;
            }
            case 6: {
                pic.setImageResource(R.drawable.count_on_fingers_06);
                break;
            }
            case 7: {
                pic.setImageResource(R.drawable.count_on_fingers_07);
                break;
            }
            case 8: {
                pic.setImageResource(R.drawable.count_on_fingers_08);
                break;
            }
            case 9: {
                pic.setImageResource(R.drawable.count_on_fingers_09);
                break;
            }
            case 10: {
                pic.setImageResource(R.drawable.count_on_fingers_10);
                break;
            }
        }
        currentPic = picNum;
    }

    public void checkAnswer(int answerNum) {

        if (currentPic == answerNum) {

            corectAnswers++;
            sp.play(correctSound, 1, 1, 0, 0, 1);
        } else {
            sp.play(wrongSound, 1, 1, 0, 0, 1);
        }
        intPicList.remove(currentPic);
        if (intPicList.size() <= 0) {
            // Intent i =new Intent(this,MainActivity.class);

            // startActivity(i);
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {

                    finish();
                }
            }, 1700);
           // sp.play(endSound, 1, 1, 0, 0, 1);

            //TODO
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
        int randomPic = intPicList.get(randomPicPos);
        chengePic(randomPic);
    }
}
