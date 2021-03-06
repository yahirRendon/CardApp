package com.example.android.cardapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button submitNamesButton; //Submit names button
    EditText toNameText; //To name EditText
    EditText fromNameText; //From name EditText
    String toName; //String from to EditText
    String fromName; //String from, from EditText

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Run initialize elements method
        initialize();
    }

    //Initialize elements
    public void initialize() {
        submitNamesButton = (Button)findViewById(R.id.submit_names);
        toNameText = (EditText)findViewById(R.id.to_name);
        fromNameText = (EditText)findViewById(R.id.from_name);
    }

    //Runs when submitNamesButton is clicked. Check if empty else send to Activity2
    public void launchActivityTwo(View view) {
        toName = toNameText.getText().toString().trim();
        fromName = fromNameText.getText().toString().trim();
        if(toName.matches("") || fromName.matches("")) {
            Toast.makeText(getBaseContext(), "Please enter a To and From name",
                    Toast.LENGTH_SHORT).show();
        } else {
            Intent toActivity2 = new Intent(getApplicationContext(), Main2Activity.class);
            toActivity2.putExtra(MyConstants.myFirstKey, toName);
            toActivity2.putExtra(MyConstants.mySecondKey, fromName);
            startActivity(toActivity2);
        }
    }

    //Manage global constants
    public class MyConstants {
        public static final String myFirstKey = "toNamePush";
        public static final String mySecondKey = "FromNamePush";
    }
}



