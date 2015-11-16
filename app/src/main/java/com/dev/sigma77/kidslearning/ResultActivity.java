package com.dev.sigma77.kidslearning;

import android.app.Activity;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ResultActivity extends Activity implements View.OnClickListener {
    TextView text1,text2,text3;
    Button ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        text1= (TextView) findViewById(R.id.textView1);
        text2= (TextView) findViewById(R.id.textView2);
        text3= (TextView) findViewById(R.id.textView3);
        ok= (Button) findViewById(R.id.button1);
        ok.setOnClickListener(this);


        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                finish();
            }
        }, 4700);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_result, menu);
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

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:{
                finish();
                break;

            }

        }
    }
}
