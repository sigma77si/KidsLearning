package com.dev.sigma77.kidslearning.util;

import android.os.Handler;

import com.dev.sigma77.kidslearning.MainActivity;
import com.dev.sigma77.kidslearning.NextTestScene;
import com.dev.sigma77.kidslearning.ShowResults;

/**
 * Created by user on 20.3.2016 г..
 */
public class Transition {

    public static void toNextActivity(TransitionParams transitionParams) {
        if(MainActivity.isTest == true) {
            new Handler().postDelayed(new NextTestScene(transitionParams.getpActivity(), transitionParams.getpIntroTextId(), transitionParams.getpIntroPicId(), transitionParams.getpExerciseNumber()
                    , transitionParams.getpIntroTalk()), 1900);

        }
        new Handler().postDelayed(new ShowResults(transitionParams.getpActivity(), transitionParams.getpCorrectAnswers(), transitionParams.getpCurrentGamePoints(), transitionParams.isEnd()), 2000);
    }
}
