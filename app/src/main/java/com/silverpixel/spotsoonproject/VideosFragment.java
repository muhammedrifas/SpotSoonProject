package com.silverpixel.spotsoonproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class VideosFragment extends Fragment {
    private List<Video> videoList = new ArrayList<>();
    private RecyclerView recyclerView;
    private CustomAdapter mAdapter;


    public VideosFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_videos, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.videosview);
        mAdapter = new CustomAdapter(videoList,getActivity().getApplicationContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        if(!MyApplication.videosdisplayed){
            prepareData();
            MyApplication.videosdisplayed=true;
        }

        return view;

    }
    private void prepareData(){
        Video video=new Video("EMPTINESS FT. JUSTIN TIMBERLAKE","18 HOURS AGO","Lorem Ipsum is simply dummy text of the printing and typesetting industry.",R.drawable.emptiness);
        videoList.add(video);
        video=new Video("I'M FALLING LOVE WITH YOU","20 HOURS AGO","Lorem Ipsum is simply dummy text of the printing and typesetting industry.",R.drawable.love);
        videoList.add(video);
        video=new Video("BABY FT. JUSTIN BIEBER","22 HOURS AGO","Lorem Ipsum is simply dummy text of the printing and typesetting industry.",R.drawable.baby);
        videoList.add(video);
        video=new Video("WHITE HORSE FT. TAYLOR SWIFT","25 HOURS AGO","Lorem Ipsum is simply dummy text of the printing and typesetting industry.",R.drawable.whitehorse);
        videoList.add(video);
        mAdapter.notifyDataSetChanged();
    }





}
