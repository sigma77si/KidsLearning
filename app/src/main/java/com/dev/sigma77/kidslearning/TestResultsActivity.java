package com.dev.sigma77.kidslearning;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class TestResultsActivity extends ActionBarActivity implements View.OnClickListener{

   public static TextView correct1, points1,
            correct2, points2,
            correct3, points3,
            correct4, points4,
            correct5, points5,
             allPoints;
    Button ok;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_results);
        correct1= (TextView) findViewById(R.id.correct1);
        correct2= (TextView) findViewById(R.id.correct2);
        correct3= (TextView) findViewById(R.id.correct3);
        correct4= (TextView) findViewById(R.id.correct4);
        correct5= (TextView) findViewById(R.id.correct5);
        points1= (TextView) findViewById(R.id.points1);
        points2= (TextView) findViewById(R.id.points2);
        points3= (TextView) findViewById(R.id.points3);
        points4= (TextView) findViewById(R.id.points4);
        points5= (TextView) findViewById(R.id.points5);
        allPoints= (TextView) findViewById(R.id.allPoints);
        ok= (Button) findViewById(R.id.btnOk);
        ok.setOnClickListener(this);
        TextView[]answers={correct1,correct2,correct3,correct4,correct5};
        TextView[]points={points1,points2,points3,points4,points5};

        Intent mIntent = getIntent();
        ArrayList<String> gamesCorrectAnswers = mIntent.getStringArrayListExtra("GamesCorrectAnswers");
        ArrayList<String> gamesPoints = mIntent.getStringArrayListExtra("GamesPoints");
        int allGamesPoints=mIntent.getIntExtra("AllPoints", 0);
        String stringAllGamePoints= String.valueOf(allGamesPoints);
        allPoints.setText( stringAllGamePoints);
        for(int i=0; i<answers.length; i++){

            answers[i].setText(gamesCorrectAnswers.get(i));
            points[i].setText(gamesPoints.get(i));

        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnOk) {
            finish();


                 return;
        }


    }
}
