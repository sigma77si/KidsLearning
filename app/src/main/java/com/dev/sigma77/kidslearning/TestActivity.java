package com.dev.sigma77.kidslearning;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;


public class TestActivity extends AppCompatActivity {
    ImageView v;

    private Toolbar toolbar;
    RecyclerView reciclerView;
    private VizAdapter adapter;

    public TestActivity() {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        v=(ImageView)findViewById(R.id.imageView9);
        reciclerView = (RecyclerView) findViewById(R.id.drowerList);
        adapter = new VizAdapter(this, getData(),"Test");
        reciclerView.setAdapter(adapter);
        reciclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public static List<DataInformation> getData() {
        List<DataInformation> data = new ArrayList<>();
        int[] icons = {R.drawable.test_ikon, R.drawable.mushroom1_small};
                //R.drawable.a2_small, R.drawable.button6_small, R.drawable.pear_main_small};
        String[] titles = {"Тест 1", "Тест 2"};
                //"Тест 3 - Про версия", "Тест 4 - Про версия", "Вземи Про версия"};
        for (int i = 0; i < titles.length && i < icons.length; i++) {
            DataInformation current = new DataInformation();

            current.iconId = icons[i];
            current.title = titles[i];
            data.add(current);
        }
        return data;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test, menu);
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

}
