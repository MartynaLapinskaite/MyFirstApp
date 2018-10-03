package com.example.martyna.myfirstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ListView;
import android.content.Intent;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.List;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    private ListView mylist;
    private ListAdapter adapter;
    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivitydesign);
        mylist = (ListView) findViewById(R.id.listView);

        List<ListItem> items= new ArrayList<>();

        Intent intent = getIntent();
        if(intent.getBooleanExtra("flag",true)){

            items.add(new ListItem("Jack",R.drawable.ic_3d_rotation_black_24dp,"Mathematics, Chemistry"));
            items.add(new ListItem("Jane",R.drawable.ic_sms_failed_black_24dp,"Physics, Informatics"));
            items.add(new ListItem("Bob",R.drawable.ic_alarm_black_24dp,"Mathematics, Informatics"));
            items.add(new ListItem("Clara", R.drawable.ic_account_box_black_24dp,"Geography, Chemistry"));
            items.add(new ListItem("Sam",R.drawable.ic_accessibility_black_24dp,"Mathematics, Physics"));


        }else{

            items.add(new ListItem("Mathematics",R.drawable.ic_3d_rotation_black_24dp,
                    "Mathematics is the study of topics such as quantity, structure, "+
            "space and change."));
            items.add(new ListItem("Physics",R.drawable.ic_sms_failed_black_24dp,
                    "Physics is the natural science that involves the study of matter, "+
            "and its motion through pace and time along with related "+
            "concepts such as energy and forte."));
            items.add(new ListItem("Chemistry",R.drawable.ic_alarm_black_24dp,
                    "Chemistry is a branch of physical science that studies the composition, "+
            "structure, properties and change of matter."));
            items.add(new ListItem("Informatics",R.drawable.ic_account_box_black_24dp,
                    "Informatics is the science of information and computer information systems."));
            items.add(new ListItem("Geography",R.drawable.ic_accessibility_black_24dp,
                    "Geography is a field of science devoted to the study of the lands, the features, "+
            "the inhabitants, and the phenomena of Earth."));
        }
        adapter = new ListAdapter(this, items);
        mylist.setAdapter(adapter);
    }
}
