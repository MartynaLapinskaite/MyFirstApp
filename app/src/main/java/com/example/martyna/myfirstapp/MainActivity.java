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
    private List<ListItem> items, nauji;
    private EditText title;
    private EditText desription;///
    private Button ad;///
    private Button image;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = new ArrayList<>();
        nauji =new ArrayList<>();
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

        ad.setOnClickListener(addClick);

        image =(Button)findViewById(R.id.image);

        image.setOnClickListener(imageClick);

    }

    View.OnClickListener addClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            nauji.add(new ListItem(title.getText().toString(),R.drawable.ic_fiber_new_black_24dp,desription.getText().toString()));
        }
    };
    View.OnClickListener imageClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, Image.class);
            context.startActivity(intent);
        }
    };





/*
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
            items.add(new ListItem("Jack",R.drawable.ic_3d_rotation_black_24dp,"Mathematics, Chemistry"));
            items.add(new ListItem("Jane",R.drawable.ic_sms_failed_black_24dp,"Physics, Informatics"));
            items.add(new ListItem("Bob",R.drawable.ic_alarm_black_24dp,"Mathematics, Informatics"));
            items.add(new ListItem("Clara", R.drawable.ic_account_box_black_24dp,"Geography, Chemistry"));
            items.add(new ListItem("Sam",R.drawable.ic_accessibility_black_24dp,"Mathematics, Physics"));
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

    private void runSecondActivity(boolean b) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra("flag",b);
        Bundle bundle = new Bundle();
        bundle.putSerializable("list", (Serializable) items);
        bundle.putSerializable("nauji", (Serializable) nauji);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }


}
