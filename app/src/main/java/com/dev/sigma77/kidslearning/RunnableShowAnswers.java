package com.dev.sigma77.kidslearning;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by user on 29.11.2015 г..
 */
public class RunnableShowAnswers implements Runnable {
    Activity activityObj;
    Class nextScene;
    public RunnableShowAnswers(Activity pActivity, Class scene){
        activityObj = pActivity;
        nextScene=scene;
    }


    @Override
        public void run() {
        Intent in = new Intent(activityObj, ResultActivity.class);
        Intent int2=new Intent(activityObj, nextScene);
        activityObj.startActivity(in);
        if( nextScene != MainActivity.class){
            activityObj.startActivity(int2);
        }

        activityObj.finish();
    }
}
