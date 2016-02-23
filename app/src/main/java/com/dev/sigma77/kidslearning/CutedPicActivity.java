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


public class CutedPicActivity extends Activity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    Button btnCheck;
    Spinner spinner2, spinner3, spinner4, spinner5, spinner6;
    SoundPool sp;
    ImageView img1, img2, img3, img4, img5, img6,
            v2img1, v2img2, v2img3, v2img4, v2img5, v2img6;
    boolean isEnd;

    ImageView imageViwePosition;
    int scene=1;
    int countAnswers = 1,correctAnswers=0, correctSound, wrongSound, endSound,currentGamePoints=0;

    LinearLayout layout1, layout2, layoutSpinners;

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
                        if (correctAnswers==5) {
                            currentGamePoints=1;
                            sp.play(correctSound, 1, 1, 0, 0, 1);
                        } else {
                            sp.play(wrongSound, 1, 1, 0, 0, 1);
                        }
                        if(MainActivity.isTest == true){
                            isEnd=true;
                            new Handler().postDelayed(new NextTestScene(this, R.string.Intro1Text4, R.drawable.buttons_example,4
                                    ,R.raw.zvukpravilno), 1900);
//

                        }else {


                        new Handler().postDelayed(new Runnable() {

                            @Override
                            public void run() {
                                if(scene==1){
                                    correctAnswers=0;
                                    startNewScene();
                                }
                                else {

                                    finish();
                                }
                            }
                        }, 1900);}
                      new Handler().postDelayed(new ShowResults(this,correctAnswers,currentGamePoints,isEnd), 2000);
//
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

//    public void setPicElementImg(ImageView v, int img) {
//
//        switch (img) {
//            case 2: {
//                v.setBackgroundResource(R.drawable.pear2);
//                break;
//            }
//            case 3: {
//                v.setBackgroundResource(R.drawable.pear3);
//                break;
//            }
//            case 4: {
//                v.setBackgroundResource(R.drawable.pear4);
//                break;
//            }
//            case 5: {
//                v.setBackgroundResource(R.drawable.pear5);
//                break;
//            }
//            case 6: {
//                v.setBackgroundResource(R.drawable.pear6);
//                break;
//            }
//        }
//    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        int img = R.drawable.pear2;

        if(scene==2) {
            switch (parent.getId()) {
                case R.id.spinner2: {
                    if (position == 3) {
                        correctAnswers++;
                    }
                    countAnswers++;
                    img = R.drawable.boy_4;
                    break;
                }
                case R.id.spinner3: {
                    if (position == 5) {
                        correctAnswers++;
                    }
                    img = R.drawable.boy_6;
                    countAnswers++;
                    break;
                }
                case R.id.spinner4: {
                    if (position == 2) {
                        correctAnswers++;
                    }
                    img = R.drawable.boy_3;
                    countAnswers++;
                    break;
                }
                case R.id.spinner5: {
                    if (position == 4) {
                        correctAnswers++;
                    }
                    img = R.drawable.boy_5;
                    countAnswers++;
                    break;
                }
                case R.id.spinner6: {
                    if (position == 1) {
                        correctAnswers++;
                    }
                    img = R.drawable.boy_2;
                    countAnswers++;
                    break;
                }


            }
        }
        if(scene==1) {
            switch (parent.getId()) {
                case R.id.spinner2: {
                    if (position == 3) {
                        correctAnswers++;
                    }
                    countAnswers++;
                    img = R.drawable.pear4;
                    break;
                }
                case R.id.spinner3: {
                    if (position == 5) {
                        correctAnswers++;
                    }
                    img = R.drawable.pear6;
                    countAnswers++;
                    break;
                }
                case R.id.spinner4: {
                    if (position == 2) {
                        correctAnswers++;
                    }
                    img = R.drawable.pear3;
                    countAnswers++;
                    break;
                }
                case R.id.spinner5: {
                    if (position == 4) {
                        correctAnswers++;
                    }
                    img = R.drawable.pear5;
                    countAnswers++;
                    break;
                }
                case R.id.spinner6: {
                    if (position == 1) {
                        correctAnswers++;
                    }
                    img = R.drawable.pear2;
                    countAnswers++;
                    break;
                }


            }
        }


        setPicture(position, img);


    }
    public void SetCorectAnswer(int scene ,int position){

        if(scene==1){

        }
    }


    private void setPicture(int position, int img) {
        switch (position) {
            case 0: {
                // v2img2.setBackgroundResource(img);
                break;
            }
            case 1: {
                v2img2.setBackgroundResource(img);
                break;
            }
            case 2: {
                v2img3.setBackgroundResource(img);
                break;
            }
            case 3: {
                v2img4.setBackgroundResource(img);
                break;
            }
            case 4: {
                v2img5.setBackgroundResource(img);
                break;
            }
            case 5: {
                v2img6.setBackgroundResource(img);
                break;
            }

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
