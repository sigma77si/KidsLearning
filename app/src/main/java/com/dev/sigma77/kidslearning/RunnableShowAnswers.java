package com.dev.sigma77.kidslearning;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by user on 29.11.2015 г..
 */
public class RunnableShowAnswers implements Runnable {
    Activity activityObj;

    public RunnableShowAnswers(Activity pActivity){
        activityObj = pActivity;
    }


    @Override
    public void run() {
        Intent in = new Intent(activityObj, ResultActivity.class);
        activityObj.startActivity(in);
        activityObj.finish();
    }
}
