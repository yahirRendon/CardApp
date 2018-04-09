package com.example.android.cardapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView greetingText; //Greeting TextView
    TextView fromText; //From TextView
    ImageView img; //Background ImageView
    boolean inEnglish; //Determine of greeting/from is displayed in english
    String toName; //Holds the name input into the to EditText
    String fromName; //Holds the name input into the from EditText

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Run initializeAct2 method
        initializeAct2();
    }

    //Initialize method for onCreate elements
    public void initializeAct2() {
        inEnglish = true;
        greetingText=(TextView)findViewById(R.id.toText);
        fromText=(TextView)findViewById(R.id.fromText);
        img=(ImageView)findViewById(R.id.felizImage);
        toName = getIntent().getStringExtra("toNamePush");
        fromName = getIntent().getStringExtra("fromNamePush");
        greetingText.setText(getString(R.string.greeting_en, toName));
        fromText.setText(getString(R.string.from_en, fromName));
    }

    //Translate the greeting and from text if greeting or from TextView is clicked
    public void translateText(View view) {
        inEnglish =! inEnglish;
        if(inEnglish) {
            greetingText.setText(getString(R.string.greeting_en, toName));
            fromText.setText(getString(R.string.from_en, fromName));
        } else {
            greetingText.setText(getString(R.string.greeting_es, toName));
            fromText.setText(getString(R.string.from_es, fromName));
        }
    }

    //Send user to web resource when imaged background image is clicked
    public void sendToResource(View view) {
        Intent moreInfo = new Intent();
        moreInfo.setAction(Intent.ACTION_VIEW);
        moreInfo.addCategory(Intent.CATEGORY_BROWSABLE);
        if(inEnglish) {
            moreInfo.setData(Uri.parse("https://en.wikipedia.org/wiki/Day_of_the_Dead"));
        } else {
            moreInfo.setData(Uri.parse("https://es.wikipedia.org/wiki/D%C3%ADa_de_Muertos"));
        }
        startActivity(moreInfo);
    }
}
