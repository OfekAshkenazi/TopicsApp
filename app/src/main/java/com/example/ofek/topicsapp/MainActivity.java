package com.example.ofek.topicsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import Adapters.TopicsAdapter;
import Entities.Topic;

public class MainActivity extends AppCompatActivity implements TopicsAdapter.OnItemListClickListener {

    public boolean isLandscape=false;
    TopicsListFragment listPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listPage = new TopicsListFragment();
        if (findViewById(R.id.topicsLayout_land)!=null){
            landScapeMode();
        }
        else {
            getSupportFragmentManager().beginTransaction().add(R.id.mainFragContainer, listPage, "listPage").commit();
        }
    }

    private void landScapeMode() {
        isLandscape=true;
        //getSupportFragmentManager().beginTransaction().add(R.id.topicsLayout_land,listPage).add(R.id.descLayout_land,new ShowTopicFragment()).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.topicsLayout_land,new TopicsListFragment()).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.descLayout_land,new ShowTopicFragment()).commit();
    }


    @Override
    public void onItemListClick(Topic topic) {
        if (isLandscape){
            getSupportFragmentManager().beginTransaction().replace(R.id.descLayout_land,ShowTopicFragment.getInstance(topic)).commit();
        }
        else {
            getSupportFragmentManager().beginTransaction().replace(R.id.mainFragContainer,ShowTopicFragment.getInstance(topic)).commit();
        }
    }

    @Override
    public void onBackPressed() {
        if (!isLandscape && !listPage.isVisible()) {
            getSupportFragmentManager().beginTransaction().replace(R.id.mainFragContainer, listPage).commit();
        } else {
            super.onBackPressed();
        }
    }
}
