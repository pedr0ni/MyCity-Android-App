package com.projetomycity.mycity.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.projetomycity.mycity.R;
import com.projetomycity.mycity.modules.PostModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private ArrayList<PostModel> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txt_username;
        TextView txt_userurl;
        TextView txt_content;
        TextView txt_time;
        ImageView img_icon;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.txt_username = (TextView) itemView.findViewById(R.id.post_username);
            this.txt_userurl = (TextView) itemView.findViewById(R.id.post_userurl);
            this.txt_time = (TextView) itemView.findViewById(R.id.post_time);
            this.txt_content = (TextView) itemView.findViewById(R.id.post_content);
            this.img_icon = (ImageView) itemView.findViewById(R.id.post_image);
        }
    }

    public CustomAdapter(ArrayList<PostModel> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_layout, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView txt_username = holder.txt_username;
        TextView txt_userurl = holder.txt_userurl;
        TextView txt_time = holder.txt_time;
        TextView txt_content = holder.txt_content;
        //ImageView img_icon = holder.img_icon;

        txt_username.setText(dataSet.get(listPosition).getUserName());
        txt_userurl.setText(dataSet.get(listPosition).getUserUrl());
        txt_time.setText(dataSet.get(listPosition).getTime());
        txt_content.setText(dataSet.get(listPosition).getContent());

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}