package com.dev.sigma77.kidslearning;

import android.content.Intent;
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


public class PracticeActivity extends AppCompatActivity {
    ImageView v;

    private Toolbar toolbar;
    RecyclerView reciclerView;
    private VizAdapter adapter;

    public PracticeActivity() {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        v=(ImageView)findViewById(R.id.imageView9);
        reciclerView = (RecyclerView) findViewById(R.id.drowerList);
        adapter = new VizAdapter(this, getData(),"Practice");
        reciclerView.setAdapter(adapter);
        reciclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public static List<DataInformation> getData() {
        List<DataInformation> data = new ArrayList<>();
        int[] icons = {R.drawable.count_on_fingers_04_small, R.drawable.mushroom1_small, R.drawable.a2_small, R.drawable.button6_small, R.drawable.pear_main_small,R.drawable.count_on_fingers_04_small, R.drawable.button16_small,R.drawable.zapomni1,R.drawable.clock1,R.drawable.similar21,R.drawable.digit3,R.drawable.a_example,R.drawable.next_digit3,R.drawable.squares5};
        String[] titles = {"Преброй пръстите", "Открий силуета", "Намери излишната картинка", "Открий еднаквите", "Сглоби картината","Преброй сгънатите пръсти","Открий еднаквите","Запомни картинките","Колко е часът","Намери подобните","Коя е цифрата","test1","Коя е следващата цифра?","Колко са квадратите?"};
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
        getMenuInflater().inflate(R.menu.menu_practice, menu);
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
            startActivity(new Intent(this,HelpActivity.class));
//            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
