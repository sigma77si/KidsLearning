package com.dev.sigma77.kidslearning;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

/**
 * Created by user on 22.12.2015 г..
 */
public class VizAdapter extends RecyclerView.Adapter<VizAdapter.MyViewHolder> {
    private LayoutInflater inflater;
    List<DataInformation>data= Collections.emptyList();
    String activityname;
    private Context context;


    public VizAdapter(Context context,List<DataInformation> data,String activityName){
        this.context=context;
        inflater= LayoutInflater.from(context);
        this.data=data;
        this.activityname=activityName;

   }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view= inflater.inflate(R.layout.custom_row,parent,false);
        MyViewHolder holder=new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder  holder, int position) {
        DataInformation current=data.get(position);
        holder.title.setText(current.title);
        holder.icon.setImageResource(current.iconId);


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title;
        ImageView icon;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.listText);
            icon = (ImageView) itemView.findViewById(R.id.itemImage);
            icon.setOnClickListener(this);
            title.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            MainActivity.isTest=false;
            startSelectedActivity(getPosition(),activityname);



        }
        public void startSelectedActivity(int itemPosition,String actName){
            switch (itemPosition) {


                case 0: {
                    if(actName=="Practice") {
                        //isTest = false;
                        //sp.play(bipSound, 1, 1, 0, 0, 1);
                        Intent in = new Intent(context, IntroTextForAllActivity.class);
                        in.putExtra("IntroText", R.string.Intro1Text1);
                        in.putExtra("ImageToLoad", R.drawable.count_on_fingers_05);
                        in.putExtra("ExerciseNum",1);
                        in.putExtra("IntroReading", R.raw.intro_one);
                        context.startActivity(in);
                    }
                 else if(actName=="Test"){
                        MainActivity.isTest = true;
                        Intent in = new Intent(context, IntroTextForAllActivity.class);
                        in.putExtra("IntroText", (R.string.Intro1Text3));
                        in.putExtra("ImageToLoad", R.drawable.a_example);
                        in.putExtra("ExerciseNum", 3);
                        in.putExtra("TestNum", 1);
                        in.putExtra("IntroReading", R.raw.zvukpravilno);
                        MainActivity.correctAnswersList.clear();
                        MainActivity.gamePointsList.clear();
                        MainActivity.isTest=true;
                        ResultActivity.result=-1;
                        ResultActivity.isLastTest=false;

                        context.startActivity(in);

                       }

                    break;
                }
                case 1: {
                    if(actName=="Practice") {
                        // isTest = false;
                        // sp.play(bipSound, 1, 1, 0, 0, 1);
                        Intent in = new Intent(context, IntroTextForAllActivity.class);
                        in.putExtra("IntroText", R.string.Intro1Text2);
                        in.putExtra("ImageToLoad", R.drawable.test2_intro_pic);
                        in.putExtra("ExerciseNum", 2);
                        in.putExtra("IntroReading", R.raw.zvukpravilno);
                        context.startActivity(in);
                    }

                        else if(actName=="Test"){

                       // Toast.makeText(context,"Вземи Про версия",Toast.LENGTH_SHORT).show();

                        MainActivity.isTest = true;

                        Intent in = new Intent(context, IntroTextForAllActivity.class);
                        in.putExtra("IntroText", R.string.Intro1Text2);
                        in.putExtra("ImageToLoad", R.drawable.test2_intro_pic);
                        in.putExtra("ExerciseNum", 10);
                        in.putExtra("TestNum", 2);
                        in.putExtra("IntroReading", R.raw.zvukpravilno);
                        MainActivity.correctAnswersList.clear();
                        MainActivity.gamePointsList.clear();
                        MainActivity.isTest=true;
                        ResultActivity.result=-1;
                        ResultActivity.isLastTest=false;
                        context.startActivity(in);
                        }


                    break;
                }
                case 2: {
                    if(actName=="Practice") {
                        // isTest = false;
                        // sp.play(bipSound, 1, 1, 0, 0, 1);
                        Intent in = new Intent(context, IntroTextForAllActivity.class);
                        in.putExtra("IntroText", (R.string.Intro1Text3));
                        in.putExtra("ImageToLoad", R.drawable.a_example);
                        in.putExtra("ExerciseNum", 3);
                        in.putExtra("IntroReading", R.raw.zvukpravilno);
                        context.startActivity(in);
                    }
                    else if(actName=="Test"){
                        Toast.makeText(context,"Вземи Про версия",Toast.LENGTH_SHORT).show();

                    }
                }

                break;
                case 3: {
                    if(actName=="Practice") {
                        // isTest = false;
                        //  sp.play(bipSound, 1, 1, 0, 0, 1);
                        Intent in = new Intent(context, IntroTextForAllActivity.class);
                        in.putExtra("IntroText", (R.string.Intro1Text4));
                        in.putExtra("ExerciseNum", 4);
                        in.putExtra("ImageToLoad", R.drawable.buttons_example);
                        in.putExtra("IntroReading", R.raw.zvukpravilno);
                        context.startActivity(in);
                    }

                    else if(actName=="Test"){


                   Toast.makeText(context,"Вземи Про версия",Toast.LENGTH_SHORT).show();

                    }


                    break;
                }
                case 4: {
                    if(actName=="Practice") {
                        // isTest = false;
                        // sp.play(bipSound, 1, 1, 0, 0, 1);
                        Intent in = new Intent(context, IntroTextForAllActivity.class);
                        in.putExtra("IntroText", (R.string.Intro1Text5));
                        in.putExtra("ExerciseNum", 5);
                        in.putExtra("ImageToLoad", R.drawable.pear_main);
                        in.putExtra("IntroReading", R.raw.zvukpravilno);
                        context.startActivity(in);
                    }

                    else if(actName=="Test"){

                        Intent in = new Intent(context, MainActivity.class);
                        in.putExtra("CallMain", true);
                        context.startActivity(in);
                       // MainActivity.btnPro.setVisibility(View.VISIBLE);

                    }


                    break;
                }
                case 5: {
                    if(actName=="Practice") {
                        //isTest = false;
                        //sp.play(bipSound, 1, 1, 0, 0, 1);
                        Intent in = new Intent(context, IntroTextForAllActivity.class);
                        in.putExtra("IntroText", R.string.Intro1Text7);
                        in.putExtra("ImageToLoad", R.drawable.count_on_fingers_05);
                        in.putExtra("ExerciseNum", 7);
                        in.putExtra("IntroReading", R.raw.intro_one);
                        context.startActivity(in);
                    }
                    else if(actName=="Test"){
                        MainActivity.isTest = true;
                        Intent in = new Intent(context, IntroTextForAllActivity.class);
                        in.putExtra("IntroText", R.string.Intro1Text7);
                        in.putExtra("ImageToLoad", R.drawable.count_on_fingers_05);
                        in.putExtra("ExerciseNum", 7);
                        in.putExtra("IntroReading", R.raw.intro_one);
                        context.startActivity(in);
                    }

                    break;
                }
                case 6: {
                    if(actName=="Practice") {
                        // isTest = false;
                        //  sp.play(bipSound, 1, 1, 0, 0, 1);
                        Intent in = new Intent(context, IntroTextForAllActivity.class);
                        in.putExtra("IntroText", (R.string.Intro1Text4));
                        in.putExtra("ExerciseNum", 9);
                        in.putExtra("ImageToLoad", R.drawable.buttons_example);
                        in.putExtra("IntroReading", R.raw.zvukpravilno);
                        context.startActivity(in);
                    }

                    else if(actName=="Test"){


                        Toast.makeText(context,"Вземи Про версия",Toast.LENGTH_SHORT).show();

                    }


                    break;
                }
                case 7: {
                    if(actName=="Practice") {
                        // isTest = false;
                        //  sp.play(bipSound, 1, 1, 0, 0, 1);
                        Intent in = new Intent(context, IntroTextForAllActivity.class);
                        in.putExtra("IntroText", (R.string.Intro1Text13));
                        in.putExtra("ExerciseNum", 13);
                        in.putExtra("ImageToLoad", R.drawable.zapomni);
                        in.putExtra("IntroReading", R.raw.zvukpravilno);
                        context.startActivity(in);
                    }

                    else if(actName=="Test"){


                        Toast.makeText(context,"Вземи Про версия",Toast.LENGTH_SHORT).show();

                    }


                    break;
                }
                case 8: {
                    if(actName=="Practice") {
                        // isTest = false;
                        //  sp.play(bipSound, 1, 1, 0, 0, 1);
                        Intent in = new Intent(context, IntroTextForAllActivity.class);
                        in.putExtra("IntroText", (R.string.Intro1Text14));
                        in.putExtra("ExerciseNum", 14);
                        in.putExtra("ImageToLoad", R.drawable.clock1);
                        in.putExtra("IntroReading", R.raw.zvukpravilno);
                        context.startActivity(in);
                    }

                    else if(actName=="Test"){


                        Toast.makeText(context,"Вземи Про версия",Toast.LENGTH_SHORT).show();

                    }


                    break;
                }
                case 9: {
                    if(actName=="Practice") {
                        // isTest = false;
                        //  sp.play(bipSound, 1, 1, 0, 0, 1);
                        Intent in = new Intent(context, IntroTextForAllActivity.class);
                        in.putExtra("IntroText", (R.string.Intro1Text15));
                        in.putExtra("ExerciseNum", 15);
                        in.putExtra("ImageToLoad", R.drawable.similar1);
                        in.putExtra("IntroReading", R.raw.zvukpravilno);
                        context.startActivity(in);
                    }

                    else if(actName=="Test"){


                        Toast.makeText(context,"Вземи Про версия",Toast.LENGTH_SHORT).show();

                    }


                    break;
                }
                case 10: {
                    if(actName=="Practice") {
                        // isTest = false;
                        //  sp.play(bipSound, 1, 1, 0, 0, 1);
                        Intent in = new Intent(context, IntroTextForAllActivity.class);
                        in.putExtra("IntroText", (R.string.Intro1Text16));
                        in.putExtra("ExerciseNum", 16);
                        in.putExtra("ImageToLoad", R.drawable.digit_example);
                        in.putExtra("IntroReading", R.raw.zvukpravilno);
                        context.startActivity(in);
                    }

                    else if(actName=="Test"){


                        Toast.makeText(context,"Вземи Про версия",Toast.LENGTH_SHORT).show();

                    }


                    break;
                }
                case 11: {
                    if(actName=="Practice") {
                        // isTest = false;
                        //  sp.play(bipSound, 1, 1, 0, 0, 1);
                        Intent in = new Intent(context, IntroTextForAllActivity.class);
                        in.putExtra("IntroText", (R.string.hello_world));
                        in.putExtra("ExerciseNum", 16);
                        in.putExtra("ImageToLoad", R.drawable.a_example);
                        in.putExtra("IntroReading", R.raw.zvukpravilno);
                        context.startActivity(in);
                    }

                    else if(actName=="Test"){


                        Toast.makeText(context,"Вземи Про версия",Toast.LENGTH_SHORT).show();

                    }


                    break;
                }
                case 12: {
                    if(actName=="Practice") {
                        // isTest = false;
                        //  sp.play(bipSound, 1, 1, 0, 0, 1);
                        Intent in = new Intent(context, IntroTextForAllActivity.class);
                        in.putExtra("IntroText", (R.string.Intro1Text19));
                        in.putExtra("ExerciseNum", 19);
                        in.putExtra("ImageToLoad", R.drawable.next_digit_exampel);
                        in.putExtra("IntroReading", R.raw.zvukpravilno);
                        context.startActivity(in);
                    }

                    else if(actName=="Test"){


                        Toast.makeText(context,"Вземи Про версия",Toast.LENGTH_SHORT).show();

                    }


                    break;
                }
                case 13: {
                    if(actName=="Practice") {
                        // isTest = false;
                        //  sp.play(bipSound, 1, 1, 0, 0, 1);
                        Intent in = new Intent(context, IntroTextForAllActivity.class);
                        in.putExtra("IntroText", (R.string.Intro1Text18));
                        in.putExtra("ExerciseNum", 18);
                        in.putExtra("ImageToLoad", R.drawable.squares_exampel);
                        in.putExtra("IntroReading", R.raw.zvukpravilno);
                        context.startActivity(in);
                    }

                    else if(actName=="Test"){


                        Toast.makeText(context,"Вземи Про версия",Toast.LENGTH_SHORT).show();

                    }


                    break;
                }
            }

        }
    }
}
