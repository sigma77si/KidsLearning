package com.dev.sigma77.kidslearning;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by user on 4.12.2015 г..
 */
public class NextTestScene {
    Activity activityObj;
    int introText;
    int testNumber;
    int imageToLoad;
    int introReading;

    public NextTestScene(Activity paractivityObj,int parIntroText,int parTestNumber, int parImageToLoad, int parIntroReading){

        introText = parIntroText;
        testNumber = parTestNumber;
        imageToLoad = parImageToLoad;
        introReading = parIntroReading;
        activityObj   = paractivityObj;
    }

    public void putExtra(){
        Intent intent = new Intent(activityObj, IntroTextForAllActivity.class);
        intent.putExtra("IntroText", R.string.Intro1Text2);
        intent.putExtra("ImageToLoad", R.drawable.test2_intro_pic);
        intent.putExtra("TestNum", 2);
        intent.putExtra("IntroReading", R.raw.zvukpravilno);
        activityObj.startActivity(intent);

    }
}