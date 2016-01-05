package com.dev.sigma77.kidslearning;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
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
    private Context context;

    public VizAdapter(Context context,List<DataInformation> data){
        this.context=context;
        inflater= LayoutInflater.from(context);
        this.data=data;
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
            startSelectedActivity(getPosition());


            Toast.makeText(context,"The position is: " +getPosition(),Toast.LENGTH_SHORT).show();
        }
        public void startSelectedActivity(int itemPosition){
            switch (itemPosition) {


                case 0: {
                    //isTest = false;
                    //sp.play(bipSound, 1, 1, 0, 0, 1);
                    Intent in = new Intent(context, IntroTextForAllActivity.class);
                    in.putExtra("IntroText", R.string.Intro1Text1);
                    in.putExtra("ImageToLoad", R.drawable.count_on_fingers_05);
                    in.putExtra("TestNum", 1);
                    in.putExtra("IntroReading", R.raw.intro_one);
                    context.startActivity(in);


                    break;
                }
                case 1: {
                   // isTest = false;
                   // sp.play(bipSound, 1, 1, 0, 0, 1);
                    Intent in = new Intent(context, IntroTextForAllActivity.class);
                    in.putExtra("IntroText", R.string.Intro1Text2);
                    in.putExtra("ImageToLoad", R.drawable.test2_intro_pic);
                    in.putExtra("TestNum", 2);
                    in.putExtra("IntroReading", R.raw.zvukpravilno);
                    context.startActivity(in);


                    break;
                }
                case 2: {
                   // isTest = false;
                   // sp.play(bipSound, 1, 1, 0, 0, 1);
                    Intent in = new Intent(context, IntroTextForAllActivity.class);
                    in.putExtra("IntroText", (R.string.Intro1Text3));
                    in.putExtra("ImageToLoad", R.drawable.a_example);
                    in.putExtra("TestNum", 3);
                    in.putExtra("IntroReading", R.raw.zvukpravilno);
                    context.startActivity(in);
                }

                break;
                case 3: {
                   // isTest = false;
                  //  sp.play(bipSound, 1, 1, 0, 0, 1);
                    Intent in = new Intent(context, IntroTextForAllActivity.class);
                    in.putExtra("IntroText", (R.string.Intro1Text4));
                    in.putExtra("TestNum", 4);
                    in.putExtra("ImageToLoad", R.drawable.buttons_example);
                    in.putExtra("IntroReading", R.raw.zvukpravilno);
                    context.startActivity(in);


                    break;
                }
                case 4: {
                   // isTest = false;
                   // sp.play(bipSound, 1, 1, 0, 0, 1);
                    Intent in = new Intent(context, IntroTextForAllActivity.class);
                    in.putExtra("IntroText", (R.string.Intro1Text5));
                    in.putExtra("TestNum", 5);
                    in.putExtra("ImageToLoad", R.drawable.pear_main);
                    in.putExtra("IntroReading", R.raw.zvukpravilno);
                    context.startActivity(in);


                    break;
                }
            }

        }
    }
}
