package com.dev.sigma77.kidslearning;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ResultActivity extends ActionBarActivity implements View.OnClickListener {
    TextView textResults, textCorrect, textTestResult, currentCorrectResult,points;
    public static TextView testResultView;
    Button ok;
    private Toolbar toolbar;
   static LinearLayout testResultLayout;
   public static int result;
    public static boolean isLastTest;

  //  List<String> correctAnswersSet = new ArrayList<>();
   // List<String> gamePointsSet = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        textResults = (TextView) findViewById(R.id.textResults);
        textCorrect = (TextView) findViewById(R.id.textCorrect);
        textTestResult = (TextView) findViewById(R.id.textTestResult);
        currentCorrectResult = (TextView) findViewById(R.id.currentCorrectResult);
        testResultView = (TextView) findViewById(R.id.testPoints);
        testResultLayout= (LinearLayout) findViewById(R.id.testResultLayout);
        points = (TextView) findViewById(R.id.points);
        ok= (Button) findViewById(R.id.button1);
        ok.setOnClickListener(this);
        toolbar= (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent mIntent = getIntent();
        if(MainActivity.isTest==false){
            ResultActivity.testResultLayout.setVisibility(View.INVISIBLE);
        };
       int gamePoints = mIntent.getIntExtra("GamePoints", 0);
        int gameCorrectAnswers = mIntent.getIntExtra("CorrectAnswers", 0);
        MainActivity.correctAnswersList.add(String.valueOf(gameCorrectAnswers));
        MainActivity.gamePointsList.add(String.valueOf(gamePoints));

        if(result!=-1) {
            result = getPreferences(MODE_PRIVATE).getInt("Result", 0);
        }
        else{
            result=0;
        }
        setResults(gamePoints,gameCorrectAnswers);

//        new Handler().postDelayed(new Runnable() {
//
//            @Override
//            public void run() {
//
//                finish();
//            }
//        }, 4700);
    }

    @Override
    protected void onPause() {


        super.onPause();
//
        getPreferences(MODE_PRIVATE).edit().putInt("Result", result).commit();

    }

    private void setResults(int currentPoints,int gameCorrectAnswers) {
        result+= currentPoints;
        testResultView.setText(Integer.toString(result));
        currentCorrectResult.setText(Integer.toString(gameCorrectAnswers));
        points.setText(Integer.toString(currentPoints));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_result, menu);
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
        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:{
                if(isLastTest==true){

                    Intent in = new Intent(this, TestResultsActivity.class);
                   // in.putExtra ("GamesCorrectAnswers", (Serializable) correctAnswersSet);
                  //  in.putExtra ("GamesPoints", (Serializable) gamePointsSet);
                   in.putStringArrayListExtra("GamesCorrectAnswers",(ArrayList<String>)MainActivity.correctAnswersList);
                    in.putStringArrayListExtra("GamesPoints", (ArrayList<String>) MainActivity.gamePointsList);
                    in.putExtra("AllPoints",result);
                    startActivity(in);

                }
                this.finish();
                break;

            }

        }
    }
}
