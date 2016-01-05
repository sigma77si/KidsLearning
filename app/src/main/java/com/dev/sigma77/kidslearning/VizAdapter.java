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
            Toast.makeText(context,"The position is: " +getPosition(),Toast.LENGTH_SHORT).show();
        }
    }
}
