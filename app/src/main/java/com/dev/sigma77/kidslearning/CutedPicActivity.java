package com.dev.sigma77.kidslearning;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.dev.sigma77.kidslearning.util.Transition;
import com.dev.sigma77.kidslearning.util.TransitionParams;

import java.util.HashMap;
import java.util.Map;


public class CutedPicActivity extends Activity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    Button btnCheck;
    Spinner spinner2, spinner3, spinner4, spinner5, spinner6;
    SoundPool sp;
    ImageView img1, img2, img3, img4, img5, img6,
            v2img1, v2img2, v2img3, v2img4, v2img5, v2img6;
    boolean isEnd;


    static int scene = 1;
    int countAnswers = 1, correctAnswers = 0, correctSound, wrongSound, endSound, currentGamePoints = 0;
    private int testNum;
    LinearLayout layout1, layout2, layoutSpinners;
    Map<Integer, Integer> imgresource = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuted_pic);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        spinner4 = (Spinner) findViewById(R.id.spinner4);
        spinner5 = (Spinner) findViewById(R.id.spinner5);
        spinner6 = (Spinner) findViewById(R.id.spinner6);

        spinner2.setOnItemSelectedListener(this);
        spinner3.setOnItemSelectedListener(this);
        spinner4.setOnItemSelectedListener(this);
        spinner5.setOnItemSelectedListener(this);
        spinner6.setOnItemSelectedListener(this);

        setArrayAdapters();

        btnCheck = (Button) findViewById(R.id.button1);

        img1 = (ImageView) findViewById(R.id.imageView1);
        img2 = (ImageView) findViewById(R.id.imageView2);
        img3 = (ImageView) findViewById(R.id.imageView3);
        img4 = (ImageView) findViewById(R.id.imageView4);
        img5 = (ImageView) findViewById(R.id.imageView5);
        img6 = (ImageView) findViewById(R.id.imageView6);
        v2img1 = (ImageView) findViewById(R.id.image2View1);
        v2img2 = (ImageView) findViewById(R.id.image2View2);
        v2img3 = (ImageView) findViewById(R.id.image2View3);
        v2img4 = (ImageView) findViewById(R.id.image2View4);
        v2img5 = (ImageView) findViewById(R.id.image2View5);
        v2img6 = (ImageView) findViewById(R.id.image2View6);
        layout1 = (LinearLayout) findViewById(R.id.layout1);
        layout2 = (LinearLayout) findViewById(R.id.layout2);
        layoutSpinners = (LinearLayout) findViewById(R.id.layoutSpinners);


        btnCheck.setOnClickListener(this);
        sp = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        correctSound = sp.load(this, R.raw.zvukpravilno, 1);
        wrongSound = sp.load(this, R.raw.zvukgreshka, 1);
        endSound = sp.load(this, R.raw.endmussic, 1);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        Intent mIntent = getIntent();
        testNum = mIntent.getIntExtra("TestNum", 0);


    }

    private void setArrayAdapters() {
        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this, R.array.num, android.R.layout.simple_spinner_item);
        spinner2.setAdapter(adapter2);
        ArrayAdapter adapter3 = ArrayAdapter.createFromResource(this, R.array.num, android.R.layout.simple_spinner_item);

        spinner3.setAdapter(adapter3);
        ArrayAdapter adapter4 = ArrayAdapter.createFromResource(this, R.array.num, android.R.layout.simple_spinner_item);
        spinner4.setAdapter(adapter4);
        ArrayAdapter adapter5 = ArrayAdapter.createFromResource(this, R.array.num, android.R.layout.simple_spinner_item);
        spinner5.setAdapter(adapter5);
        ArrayAdapter adapter6 = ArrayAdapter.createFromResource(this, R.array.num, android.R.layout.simple_spinner_item);
        spinner6.setAdapter(adapter6);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cuted_pic, menu);
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

        switch (v.getId()) {


            case R.id.button1: {
                {
                    if (countAnswers >= 5) {
                        layout2.setVisibility(View.INVISIBLE);
                        layout1.setVisibility(View.VISIBLE);
                        layoutSpinners.setVisibility(View.INVISIBLE);
                        btnCheck.setVisibility(View.INVISIBLE);
                        if (correctAnswers == 5) {
                            currentGamePoints = 1;
                            sp.play(correctSound, 1, 1, 0, 0, 1);
                        } else {
                            sp.play(wrongSound, 1, 1, 0, 0, 1);
                        }
                        if (MainActivity.isTest == true) {
                            isEnd = true;
                            if(scene==2){
                                ResultActivity.isLastTest=true;
                            }
                            TransitionParams transitionParams = new TransitionParams();
                            transitionParams.setIsEnd(isEnd);
                            transitionParams.setpActivity(this);
                            transitionParams.setTestNumber(testNum);
                            transitionParams.setpCorrectAnswers(correctAnswers);
                            transitionParams.setpCurrentGamePoints(currentGamePoints);
                            Transition.toNextActivity(transitionParams);
                        } else {


                            new Handler().postDelayed(new Runnable() {

                                @Override
                                public void run() {
                                    if (scene == 1) {
                                        imgresource.remove(R.id.spinner2);
                                        imgresource.remove(R.id.spinner3);
                                        imgresource.remove(R.id.spinner4);
                                        imgresource.remove(R.id.spinner5);
                                        imgresource.remove(R.id.spinner6);
                                        correctAnswers = 0;
                                        startNewScene();
                                    } else {

                                        finish();
                                    }
                                }
                            }, 1950);
                            new Handler().postDelayed(new ShowResults(this, correctAnswers, currentGamePoints, isEnd), 1500);
                        }

                    }
                }


            }


        }


    }

    private void startNewScene() {
        v2img1.setBackgroundResource(R.drawable.boy_1);
        v2img2.setBackgroundResource(R.drawable.boy_4);
        v2img3.setBackgroundResource(R.drawable.boy_6);
        v2img4.setBackgroundResource(R.drawable.boy_3);
        v2img5.setBackgroundResource(R.drawable.boy_5);
        v2img6.setBackgroundResource(R.drawable.boy_2);
        img1.setBackgroundResource(R.drawable.boy_1);
        img2.setBackgroundResource(R.drawable.boy_4);
        img3.setBackgroundResource(R.drawable.boy_6);
        img4.setBackgroundResource(R.drawable.boy_3);
        img5.setBackgroundResource(R.drawable.boy_5);
        img6.setBackgroundResource(R.drawable.boy_2);
        layout2.setVisibility(View.VISIBLE);
        layout1.setVisibility(View.INVISIBLE);
        setArrayAdapters();
        layoutSpinners.setVisibility(View.VISIBLE);
        btnCheck.setVisibility(View.VISIBLE);
        countAnswers = 1;
        scene++;
    }


    public void checkAnswer(int scene, int spinerNum, int positoin) {
        Map<Integer, Integer> spinnerMap = new HashMap<>();
        if (scene == 1) {
            spinnerMap.put(R.id.spinner2, 3);
            spinnerMap.put(R.id.spinner3, 5);
            spinnerMap.put(R.id.spinner4, 2);
            spinnerMap.put(R.id.spinner5, 4);
            spinnerMap.put(R.id.spinner6, 1);


        } else if (scene == 2) {
            spinnerMap.put(R.id.spinner2, 3);
            spinnerMap.put(R.id.spinner3, 5);
            spinnerMap.put(R.id.spinner4, 2);
            spinnerMap.put(R.id.spinner5, 4);
            spinnerMap.put(R.id.spinner6, 1);

        }
        if (spinnerMap.get(spinerNum) == positoin) {
            correctAnswers++;
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        int img = R.drawable.pear2;
        int spinnerNum = parent.getId();
        countAnswers++;
        checkAnswer(scene, spinnerNum, position);
        setPicture(position, spinnerNum);


    }


    public void setPicture(int position, int spinner) {
        if (position < 1) {
            position = 1;
        }

        if (scene == 1) {

            imgresource.put(R.id.spinner2, R.drawable.pear4);
            imgresource.put(R.id.spinner3, R.drawable.pear6);
            imgresource.put(R.id.spinner4, R.drawable.pear3);
            imgresource.put(R.id.spinner5, R.drawable.pear5);
            imgresource.put(R.id.spinner6, R.drawable.pear2);
        } else if (scene == 2) {

            imgresource.put(R.id.spinner2, R.drawable.boy_4);
            imgresource.put(R.id.spinner3, R.drawable.boy_6);
            imgresource.put(R.id.spinner4, R.drawable.boy_3);
            imgresource.put(R.id.spinner5, R.drawable.boy_5);
            imgresource.put(R.id.spinner6, R.drawable.boy_2);

        }
        ImageView[] resultPics = {v2img2, v2img3, v2img4, v2img5, v2img6};
        resultPics[position - 1].setBackgroundResource(imgresource.get(spinner));


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
