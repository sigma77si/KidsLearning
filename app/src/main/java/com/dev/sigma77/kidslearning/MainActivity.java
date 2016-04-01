package com.dev.sigma77.kidslearning;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import com.kidslearning.inappbilling.util.Inventory;
import com.kidslearning.inappbilling.util.Purchase;

import com.kidslearning.inappbilling.util.IabHelper;
import com.kidslearning.inappbilling.util.IabResult;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static boolean isTest = false;

    Button practice;
    Button test;
    static Button btnPro;
    SoundPool sp;
    MediaPlayer mp;
    boolean callMain;
    int introSound, bipSound, clickAnswerSound;
    private static final String TAG =
            "com.dev.sigma77.kidslearning";
    static final String ITEM_SKU = "android.test_pic.purchased";
     IabHelper mHelper;
   public static List<String> correctAnswersList = new ArrayList<>();
    public static List<String> gamePointsList = new ArrayList<>();

    private Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Intent mIntent = getIntent();
        callMain= mIntent.getBooleanExtra("CallMain",false);
        setContentView(R.layout.activity_main);

        practice = (Button) findViewById(R.id.btnGame7);
        test = (Button) findViewById(R.id.btnGame8);
        btnPro = (Button) findViewById(R.id.btnPro);

        toolbar= (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);



        practice.setOnClickListener(this);
        test.setOnClickListener(this);
        btnPro.setOnClickListener(this);
        sp = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        introSound = sp.load(this, R.raw.intro_one, 1);
        bipSound = sp.load(this, R.raw.blub, 1);
        clickAnswerSound = sp.load(this, R.raw.sound, 1);
        mp = MediaPlayer.create(MainActivity.this, R.raw.intro_one);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
       // practice.setText("Тест 2 Про");
       // test.setText("Tест 3 Про");
       // practice.setEnabled(false);
       // test.setEnabled(false);
        if(callMain==true){
            btnPro.setVisibility(View.VISIBLE);
            practice.setVisibility(View.INVISIBLE);
            test.setVisibility(View.INVISIBLE);
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
//            return true;
            //HelpActivity.text.setText(R.string.help);
            startActivity(new Intent(this,HelpActivity.class));

        }
//        if (id == R.id.navigate) {
//            startActivity(new Intent(this,HelpActivity.class));
//            new Handler().postDelayed(new Runnable() {
//
//                @Override
//                public void run() {
//
//                    HelpActivity.text.setText(R.string.about);
//                }
//            }, 4950);
//
//
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
               practice.setEnabled(true);
                test.setEnabled(true);

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


//
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
