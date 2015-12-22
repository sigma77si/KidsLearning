package com.dev.sigma77.kidslearning;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by user on 22.12.2015 г..
 */
public class VizAdapter extends RecyclerView.Adapter<VizAdapter.MyViewHolder> {
    private LayoutInflater inflater;
    List<DataInformation>data= Collections.emptyList();

    public VizAdapter(Context context,List<DataInformation>data){
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
        DataInformation curent=data.get(position);
        holder.title.setText(curent.title);
        holder.icon.setImageResource(curent.iconId);

    }

    @Override
    public int getItemCount() {
        return 0;
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        ImageView icon;

        public MyViewHolder(View itemView) {
            super(itemView);
            title= (TextView) itemView.findViewById(R.id.list_item);
            icon= (ImageView) itemView .findViewById(R.id.imageView);
        }
    }
}
