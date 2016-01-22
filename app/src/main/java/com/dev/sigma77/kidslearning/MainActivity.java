package com.dev.sigma77.kidslearning;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.support.design.widget.FloatingActionButton;
import android.widget.ActionMenuView;


import com.kidslearning.inappbilling.util.Inventory;
import com.kidslearning.inappbilling.util.Purchase;

import com.kidslearning.inappbilling.util.IabHelper;
import com.kidslearning.inappbilling.util.IabResult;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static boolean isTest = false;
    Button game1;
    Button game2;
    Button game3;
    Button game4;
    Button game5;
    Button game6;
    Button game7;
    Button game8;
    static Button btnPro;
    SoundPool sp;
    MediaPlayer mp;
    boolean callMain;
    int introSound, bipSound, clickAnswerSound;
    private static final String TAG =
            "com.dev.sigma77.kidslearning";
    static final String ITEM_SKU = "android.test_pic.purchased";
     IabHelper mHelper;

    private Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Intent mIntent = getIntent();
        callMain= mIntent.getBooleanExtra("CallMain",false);
        setContentView(R.layout.activity_main);
//        game1 = (Button) findViewById(R.id.btnGame1);
//        game2 = (Button) findViewById(R.id.btnGame2);
//        game3 = (Button) findViewById(R.id.btnGame3);
//        game4 = (Button) findViewById(R.id.btnGame4);
//        game5 = (Button) findViewById(R.id.btnGame5);
       // game6 = (Button) findViewById(R.id.btnGame6);
        game7 = (Button) findViewById(R.id.btnGame7);
        game8 = (Button) findViewById(R.id.btnGame8);
        btnPro = (Button) findViewById(R.id.btnPro);

        toolbar= (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);


//        game1.setOnClickListener(this);
//        game2.setOnClickListener(this);
//        game3.setOnClickListener(this);
//        game4.setOnClickListener(this);
//        game5.setOnClickListener(this);
       // game6.setOnClickListener(this);
        game7.setOnClickListener(this);
        game8.setOnClickListener(this);
        btnPro.setOnClickListener(this);
        sp = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        introSound = sp.load(this, R.raw.intro_one, 1);
        bipSound = sp.load(this, R.raw.blub, 1);
        clickAnswerSound = sp.load(this, R.raw.sound, 1);
        mp = MediaPlayer.create(MainActivity.this, R.raw.intro_one);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
       // game7.setText("Тест 2 Про");
       // game8.setText("Tест 3 Про");
       // game7.setEnabled(false);
       // game8.setEnabled(false);
        if(callMain==true){
            btnPro.setVisibility(View.VISIBLE);
            game7.setVisibility(View.INVISIBLE);
            game8.setVisibility(View.INVISIBLE);
        }
        else {
        btnPro.setVisibility(View.INVISIBLE);
        }
        String base64EncodedPublicKey =
                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoWcEpy7TKjzd2DK8R6FTGKIekGYubBtWfOtc4D8nlghiYYQX53tZpK/HEa7GiiTNhLLR8TN0zuZru5kDdXyZbqqajomZ/KWQS+IR3WAILtkCDS5yvoRbTZJztVklB8csPIQhA7xloyI6EhpRT/4OKVWrcbsyUtkWH5U+0Wv3xlN0wblsTlUH+1X6djKeaZdZxjgULcA/KvA/A6Ah/2VVlcMe5oj6TOb5myhbOLUQRO2FccDau+woxPNhtLWZr2hqbFXQD6nXP6gPOKGujLZoLI/MCN6GS4nm3OzrmF4RSiBQgoFcdxvIW8BqKZlyTg/09VVqQ3Dms71zKe9ilGTkXwIDAQAB";

        mHelper = new IabHelper(this, base64EncodedPublicKey);

        mHelper.startSetup(new
                                   IabHelper.OnIabSetupFinishedListener() {
                                       public void onIabSetupFinished(IabResult result)
                                       {
                                           if (!result.isSuccess()) {
                                               Log.d(TAG, "In-app Billing setup failed: " +
                                                       result);
                                           } else {
                                               Log.d(TAG, "In-app Billing is set up OK");
                                           }
                                       }
                                   });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
//        if (id == R.id.navigate) {
//
//           startActivity(new Intent(this,ResultActivity.class));
//        }

        return super.onOptionsItemSelected(item);
    }
  
    @Override
    protected void onPause() {
        super.onPause();
        ResultActivity.result = -1;
//        getPreferences(MODE_PRIVATE).edit().putInt("Result",0).commit();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mHelper != null) mHelper.dispose();
        mHelper = null;

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data)
    {
        if (!mHelper.handleActivityResult(requestCode,
                resultCode, data)) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
     IabHelper.OnIabPurchaseFinishedListener mPurchaseFinishedListener
            = new IabHelper.OnIabPurchaseFinishedListener() {
        public void onIabPurchaseFinished(IabResult result,
                                          Purchase purchase)
        {
            if (result.isFailure()) {
                // Handle error
                return;
            }
            else if (purchase.getSku().equals(ITEM_SKU)) {
                consumeItem();
               btnPro.setEnabled(false);
               game7.setEnabled(true);
                game8.setEnabled(true);

            }

        }
    };
    public void consumeItem() {
        mHelper.queryInventoryAsync(mReceivedInventoryListener);
    }

    IabHelper.QueryInventoryFinishedListener mReceivedInventoryListener
            = new IabHelper.QueryInventoryFinishedListener() {
        public void onQueryInventoryFinished(IabResult result,
                                             Inventory inventory) {

            if (result.isFailure()) {
                // Handle failure
            } else {
                mHelper.consumeAsync(inventory.getPurchase(ITEM_SKU),
                        mConsumeFinishedListener);
            }
        }
    };
    IabHelper.OnConsumeFinishedListener mConsumeFinishedListener =
            new IabHelper.OnConsumeFinishedListener() {
                public void onConsumeFinished(Purchase purchase,
                                              IabResult result) {

                    if (result.isSuccess()) {
                        btnPro.setEnabled(true);
                    } else {
                        // handle error
                    }
                }
            };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {


//            case R.id.btnGame1: {
//                isTest = false;
//                sp.play(bipSound, 1, 1, 0, 0, 1);
//                Intent in = new Intent(this, IntroTextForAllActivity.class);
//                in.putExtra("IntroText", R.string.Intro1Text1);
//                in.putExtra("ImageToLoad", R.drawable.count_on_fingers_05);
//                in.putExtra("TestNum", 1);
//                in.putExtra("IntroReading", R.raw.intro_one);
//                startActivity(in);
//
//
//                break;
//            }
//            case R.id.btnGame2: {
//                isTest = false;
//                sp.play(bipSound, 1, 1, 0, 0, 1);
//                Intent in = new Intent(this, IntroTextForAllActivity.class);
//                in.putExtra("IntroText", R.string.Intro1Text2);
//                in.putExtra("ImageToLoad", R.drawable.test2_intro_pic);
//                in.putExtra("TestNum", 2);
//                in.putExtra("IntroReading", R.raw.zvukpravilno);
//                startActivity(in);
//
//
//                break;
//            }
//            case R.id.btnGame3: {
//                isTest = false;
//                sp.play(bipSound, 1, 1, 0, 0, 1);
//                Intent in = new Intent(this, IntroTextForAllActivity.class);
//                in.putExtra("IntroText", (R.string.Intro1Text3));
//                in.putExtra("ImageToLoad", R.drawable.a_example);
//                in.putExtra("TestNum", 3);
//                in.putExtra("IntroReading", R.raw.zvukpravilno);
//                startActivity(in);
//            }
//
//            break;
//            case R.id.btnGame4: {
//                isTest = false;
//                sp.play(bipSound, 1, 1, 0, 0, 1);
//                Intent in = new Intent(this, IntroTextForAllActivity.class);
//                in.putExtra("IntroText", (R.string.Intro1Text4));
//                in.putExtra("TestNum", 4);
//                in.putExtra("ImageToLoad", R.drawable.buttons_example);
//                in.putExtra("IntroReading", R.raw.zvukpravilno);
//                startActivity(in);
//
//
//                break;
//            }
//            case R.id.btnGame5: {
//                isTest = false;
//                sp.play(bipSound, 1, 1, 0, 0, 1);
//                Intent in = new Intent(this, IntroTextForAllActivity.class);
//                in.putExtra("IntroText", (R.string.Intro1Text5));
//                in.putExtra("TestNum", 5);
//                in.putExtra("ImageToLoad", R.drawable.pear_main);
//                in.putExtra("IntroReading", R.raw.zvukpravilno);
//                startActivity(in);
//
//
//                break;
//            }
//            case R.id.btnGame6: {
//                isTest = true;
//                sp.play(bipSound, 1, 1, 0, 0, 1);
//                Intent in = new Intent(this, IntroTextForAllActivity.class);
//                in.putExtra("IntroText", (R.string.Intro1Text3));
//                in.putExtra("ImageToLoad", R.drawable.a_example);
//                in.putExtra("TestNum", 3);
//                in.putExtra("IntroReading", R.raw.zvukpravilno);
//                startActivity(in);
//
//
//                break;
//            }
            case R.id.btnGame7: {
                isTest = true;
                Intent in = new Intent(this, TestActivity.class);

                startActivity(in);

                break;
            }
            case R.id.btnGame8: {
                isTest = true;
                Intent in = new Intent(this, PracticeActivity.class);

                startActivity(in);

                break;
            }
            case R.id.btnPro: {

                mHelper.launchPurchaseFlow(this, ITEM_SKU, 10001,
                        mPurchaseFinishedListener, "mypurchasetoken2");
                 this.finish();


                break;
            }
        }
    }


}
