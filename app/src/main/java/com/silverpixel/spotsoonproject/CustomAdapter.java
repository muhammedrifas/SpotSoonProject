package com.silverpixel.spotsoonproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Rifas on 6/13/2017.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private List<Video> videosList;
    Context context;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, time, desc;
        ImageView img;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            time = (TextView) view.findViewById(R.id.time);
            desc = (TextView) view.findViewById(R.id.desc);
            img=(ImageView) view.findViewById(R.id.videoicon);
        }
    }
    public CustomAdapter(List<Video> videosList,Context context) {
        this.videosList = videosList;
        this.context=context;
    }
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.videos_list_item, parent, false);

        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(CustomAdapter.MyViewHolder holder, int position) {
        Video video=videosList.get(position);
        holder.title.setText(video.getTitle());
        holder.desc.setText(video.getDesc());
        holder.time.setText(video.getTime());
        Picasso.with(context).load(video.getImage_url()).into(holder.img);

    }

    @Override
    public int getItemCount() {
        return videosList.size();
    }
}
