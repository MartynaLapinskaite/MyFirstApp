package com.example.martyna.myfirstapp;

import android.content.ClipData;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ListView;
import android.content.Context;
import android.content.Intent;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.ListResourceBundle;



public class MainActivity extends AppCompatActivity {

    private Button myButton;
    private TextView mytextField;
    private Button secondActivityButton;
    private Context context = this;
    private List<ListItem> items, addd;
    private EditText title;///
    private EditText desription;///
    private Button ad;///
    private TextView addplace; ////
    private ArrayAdapter<String> adapter;
    private ArrayList<String> arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = new ArrayList<>();
        addd = new ArrayList<>();
//
        //myButton = (Button) findViewById(R.id.button);
        secondActivityButton = (Button) findViewById(R.id.secondActivityButton);
        mytextField = (TextView) findViewById(R.id.textfield);
//
        //myButton.setOnClickListener(myButtonClick);
        secondActivityButton.setOnClickListener(startSecondActivity);
        secondActivityButton.setOnLongClickListener(startSecondActivityLong);

        title = (EditText) findViewById(R.id.title);
        desription =(EditText) findViewById(R.id.desciption);
        ad = (Button) findViewById(R.id.add);
        addplace=(TextView) findViewById(R.id.addplace);

        arrayList = new ArrayList<String>();
        adapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.activity_list_item, arrayList);

        //addplace.setAdapter(adapter);

        onBtnClick();
    }

    public void onBtnClick(){
        ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addplace.setText(addplace.getText() + "\n" + title.getText().toString() + "\n"+desription.getText().toString());
                //String result = title.getText().toString() + "\n"+desription.getText().toString();
                //addplace.setText(result);
                //arrayList.add(result);
                //adapter.notifyDataSetChanged();
            }
        });
    }
/*
    View.OnClickListener addClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            List<ListItem> addd= new ArrayList<>();

            addd.add(new ListItem(title.getText().toString(),R.drawable.ic_3d_rotation_black_24dp,desription.getText().toString()));
        }
    };
*//*
    View.OnClickListener myButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mytextField.setText(mytextField.getText() + "\n" + "Next line");
        }
    };
/*
    public void runSecondActivity(boolean b) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra("flag",b);
        context.startActivity(intent);
    }
    */

    View.OnClickListener startSecondActivity = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            items = new ArrayList<>();
            items.add(new ListItem("Jack",R.drawable.ic_3d_rotation_black_24dp,"Mathematics, Chemistry"));
            items.add(new ListItem("Jane",R.drawable.ic_sms_failed_black_24dp,"Physics, Informatics"));
            items.add(new ListItem("Bob",R.drawable.ic_alarm_black_24dp,"Mathematics, Informatics"));
            items.add(new ListItem("Clara", R.drawable.ic_account_box_black_24dp,"Geography, Chemistry"));
            items.add(new ListItem("Sam",R.drawable.ic_accessibility_black_24dp,"Mathematics, Physics"));
            runSecondActivity(true);
        }
    };

    View.OnLongClickListener startSecondActivityLong = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            runSecondActivity(false);
            return true;
        }
    };

    private void runSecondActivity(boolean b)
    {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra("flag",b);
        Bundle bundle = new Bundle();
        bundle.putSerializable("list", (Serializable) items);

        intent.putExtras(bundle);
        context.startActivity(intent);


    }
}
