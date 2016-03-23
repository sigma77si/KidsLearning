package com.dev.sigma77.kidslearning;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by user on 4.12.2015 г..
 */
public class NextTestScene implements Runnable
{
    Activity activityObj;
    int introText;
    int exerciseNumber;
    int imageToLoad;
    int introReading;
    int testNum;

    public NextTestScene(Activity paractivityObj,int parIntroText, int parImageToLoad,int pTestNum, int parExerciseNumber, int parIntroReading){

        introText = parIntroText;
        exerciseNumber = parExerciseNumber;
        imageToLoad = parImageToLoad;
        introReading = parIntroReading;
        activityObj   = paractivityObj;
        testNum = pTestNum;
    }

    public void putExtra(){

        Intent intent = new Intent(activityObj, IntroTextForAllActivity.class);
        intent.putExtra("IntroText", introText);
        intent.putExtra("ImageToLoad", imageToLoad);
        intent.putExtra("ExerciseNum", exerciseNumber);
        intent.putExtra("TestNum", testNum);
        intent.putExtra("IntroReading",introReading);
        activityObj.startActivity(intent);

    }

    @Override
    public void run() {
        putExtra();

    }
}
