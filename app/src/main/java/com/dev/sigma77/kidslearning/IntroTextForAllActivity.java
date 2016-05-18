package com.dev.sigma77.kidslearning;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class IntroTextForAllActivity extends Activity {
    public static TextView text;
    Button btnNext ;
    ImageButton btnSound;
    ImageView pic;

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_for_all_activitys);
        Intent mIntent = getIntent();
        final int textToSet = mIntent.getIntExtra("IntroText", 0);
        final int image = mIntent.getIntExtra("ImageToLoad", 0);
        final int exerciseNum = mIntent.getIntExtra("ExerciseNum", 0);
        final int testNum = mIntent.getIntExtra("TestNum", 0);
        final int introReading = mIntent.getIntExtra("IntroReading", 0);

        mp = MediaPlayer.create(IntroTextForAllActivity.this, introReading );
        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        btnNext = (Button) findViewById(R.id.button);
        btnSound =(ImageButton) findViewById(R.id.imgSound);

        text = (TextView) findViewById(R.id.textView);
        text.setMovementMethod(new ScrollingMovementMethod());
        pic = (ImageView) findViewById(R.id.imageView);
        text.setText(textToSet);
        pic.setImageResource(image);

        View.OnClickListener oclBtn = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.button:{
                        if (exerciseNum == 1) {
                            Intent in = new Intent(IntroTextForAllActivity.this, CountActivity.class);
                            in.putExtra("TestNum", testNum);
                            CountActivity.game=1;
                            startActivity(in);
                        } else if (exerciseNum == 2) {
                            Intent in = new Intent(IntroTextForAllActivity.this, FindCorrectPic.class);
                            in.putExtra("SceneNum", 1);
                            in.putExtra("TestNum", testNum);
                            startActivity(in);
                            FindCorrectPic.currentGamePoints = 0;
                            FindCorrectPic.correctAnswers = 0;
                        } else if (exerciseNum == 3) {
                            Intent in = new Intent(IntroTextForAllActivity.this, FindCorrectPic.class);
                            in.putExtra("SceneNum", 6);
                            in.putExtra("TestNum", testNum);
                            startActivity(in);
                            FindCorrectPic.currentGamePoints = 0;
                            FindCorrectPic.correctAnswers = 0;
                        } else if (exerciseNum == 4) {
                            Intent in = new Intent(IntroTextForAllActivity.this, ButtonActivity.class);
                            in.putExtra("TestNum", testNum);
                            startActivity(in);
                        } else if (exerciseNum == 5) {
                            Intent in = new Intent(IntroTextForAllActivity.this, CutedPicActivity.class);
                            in.putExtra("TestNum", testNum);
                            startActivity(in);
                        }
//                         else if (exerciseNum == 6) {
//                            Intent in = new Intent(IntroTextForAllActivity.this, FindUncorrectPic.class);
//                            in.putExtra("TestNum", testNum);
//                            startActivity(in);
//                         }
                            else if (exerciseNum == 7) {
                            Intent in = new Intent(IntroTextForAllActivity.this, CountActivity.class);
                            in.putExtra("TestNum", testNum);
                            startActivity(in);
                            CountActivity.game=2;
                        }
                        else if (exerciseNum == 9) {
                            Intent in = new Intent(IntroTextForAllActivity.this, ButtonActivity.class);
                            in.putExtra("TestNum", testNum);
                            startActivity(in);
                            ButtonActivity.game =2;
                        }
                        else if (exerciseNum == 10) {
                            Intent in = new Intent(IntroTextForAllActivity.this, FindCorrectPic.class);
                            in.putExtra("SceneNum", 2);
                            in.putExtra("TestNum", testNum);
                            startActivity(in);
                            FindCorrectPic.currentGamePoints = 0;
                            FindCorrectPic.correctAnswers = 0;
                        }
                        else if (exerciseNum == 11) {
                            Intent in = new Intent(IntroTextForAllActivity.this, FindCorrectPic.class);
                            in.putExtra("SceneNum", 7);
                            in.putExtra("TestNum", testNum);
                            startActivity(in);
                            CutedPicActivity.scene = 2;
                            FindCorrectPic.currentGamePoints = 0;
                            FindCorrectPic.correctAnswers = 0;
                        }
                        else if (exerciseNum == 12) {
                            Intent in = new Intent(IntroTextForAllActivity.this, CutedPicActivity.class);
                            in.putExtra("TestNum", testNum);
                            startActivity(in);
                        }
                        else if (exerciseNum == 13) {
                            Intent in = new Intent(IntroTextForAllActivity.this, MemoryActivity.class);
                            in.putExtra("TestNum", testNum);
                            startActivity(in);
                        }
                        else if (exerciseNum == 14) {
                            Intent in = new Intent(IntroTextForAllActivity.this, ClockActivity.class);
                            in.putExtra("TestNum", testNum);
                            startActivity(in);
                        }
                        else if (exerciseNum == 15) {
                            Intent in = new Intent(IntroTextForAllActivity.this, SimilarityActivity.class);
                            in.putExtra("TestNum", testNum);
                            startActivity(in);
                        }
                        else if (exerciseNum == 16) {
                            Intent in = new Intent(IntroTextForAllActivity.this, SeeDigitActivity.class);
                            in.putExtra("TestNum", testNum);
                            startActivity(in);
                        }


                        finish();

                        break;
                    }
                    case R.id.imgSound:{
                        mp.start();

                        break;
                    }

                }

            }
        };
        btnNext.setOnClickListener(oclBtn);
        btnSound.setOnClickListener(oclBtn);



    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_intro_text_for_all_activity, menu);
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
}
