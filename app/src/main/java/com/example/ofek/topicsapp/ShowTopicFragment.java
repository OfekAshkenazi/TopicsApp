package com.example.ofek.topicsapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import Entities.Topic;


public class ShowTopicFragment extends Fragment {
    Topic topic;
    public ShowTopicFragment() {
    }
    public static ShowTopicFragment getInstance(Topic topic){
        ShowTopicFragment instance=new ShowTopicFragment();
        instance.setTopic(topic);
        return instance;
    }
    public void setTopic(Topic topic) {
        this.topic = topic;
    }
    ScrollView scrollView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_show_topic,container,false);
        scrollView=view.findViewById(R.id.scrollView);
        TextView textView=scrollView.findViewById(R.id.contentTV);
        if (topic!=null) {
            textView.setText(topic.getBody());
        }
        return view;
    }



}
