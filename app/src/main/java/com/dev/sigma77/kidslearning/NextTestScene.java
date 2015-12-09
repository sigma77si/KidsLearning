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
    int testNumber;
    int imageToLoad;
    int introReading;

    public NextTestScene(Activity paractivityObj,int parIntroText, int parImageToLoad,int parTestNumber, int parIntroReading){

        introText = parIntroText;
        testNumber = parTestNumber;
        imageToLoad = parImageToLoad;
        introReading = parIntroReading;
        activityObj   = paractivityObj;
    }

    public void putExtra(){
        Intent intent = new Intent(activityObj, IntroTextForAllActivity.class);
        intent.putExtra("IntroText", introText);
        intent.putExtra("ImageToLoad", imageToLoad);
        intent.putExtra("TestNum", testNumber);
        intent.putExtra("IntroReading",introReading);
        activityObj.startActivity(intent);

    }

    @Override
    public void run() {
        putExtra();

    }
}
