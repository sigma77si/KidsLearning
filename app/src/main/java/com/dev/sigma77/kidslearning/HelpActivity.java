package com.dev.sigma77.kidslearning;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import com.dev.sigma77.kidslearning.R;

public class HelpActivity extends ActionBarActivity {
  public static TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        text= (TextView) findViewById(R.id.textView);

    }

}
