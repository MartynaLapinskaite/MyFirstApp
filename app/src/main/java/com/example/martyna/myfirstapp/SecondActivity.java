package com.example.martyna.myfirstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ListView;
import android.content.Intent;

public class SecondActivity extends AppCompatActivity {
    private ListView mylist;
    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivitydesign);
        mylist = (ListView) findViewById(R.id.listView);
        Intent intent = getIntent();
        if(intent.getBooleanExtra("flag",true)){
            //

        }else{
            //
        }
    }
}
