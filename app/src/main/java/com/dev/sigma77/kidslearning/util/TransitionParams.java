package com.dev.sigma77.kidslearning.util;

import android.app.Activity;

public class TransitionParams {
    private boolean isEnd;
    private Activity pActivity;
    private int pIntroTextId;
    private int pIntroPicId;
    private int pTestNumber;
    private int pIntroTalk;
    private int pCorrectAnswers;
    private int pCurrentGamePoints;

    public TransitionParams()
    {

    }

    public TransitionParams(boolean isEnd, Activity pActivity, int pIntroTextId, int pIntroPicId, int pTestNumber, int pIntroTalk, int pCorrectAnswers, int pCurrentGamePoints) {
        this.isEnd = isEnd;
        this.pActivity = pActivity;
        this.pIntroTextId = pIntroTextId;
        this.pIntroPicId = pIntroPicId;
        this.pTestNumber = pTestNumber;
        this.pIntroTalk = pIntroTalk;
        this.pCorrectAnswers = pCorrectAnswers;
        this.pCurrentGamePoints = pCurrentGamePoints;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public Activity getpActivity() {
        return pActivity;
    }

    public int getpIntroTextId() {
        return pIntroTextId;
    }

    public int getpIntroPicId() {
        return pIntroPicId;
    }

    public int getTestNumber() {
        return pTestNumber;
    }

    public int getpIntroTalk() {
        return pIntroTalk;
    }

    public int getpCorrectAnswers() {
        return pCorrectAnswers;
    }

    public int getpCurrentGamePoints() {
        return pCurrentGamePoints;
    }

    public void setIsEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }

    public void setpActivity(Activity pActivity) {
        this.pActivity = pActivity;
    }

    public void setpIntroTextId(int pIntroTextId) {
        this.pIntroTextId = pIntroTextId;
    }

    public void setpIntroPicId(int pIntroPicId) {
        this.pIntroPicId = pIntroPicId;
    }

    public void setTestNumber(int pExerciseNumber) {
        this.pTestNumber = pExerciseNumber;
    }

    public void setpIntroTalk(int pIntroTalk) {
        this.pIntroTalk = pIntroTalk;
    }

    public void setpCorrectAnswers(int pCorrectAnswers) {
        this.pCorrectAnswers = pCorrectAnswers;
    }

    public void setpCurrentGamePoints(int pCurrentGamePoints) {
        this.pCurrentGamePoints = pCurrentGamePoints;
    }
}
