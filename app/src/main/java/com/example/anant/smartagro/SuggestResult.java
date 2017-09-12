package com.example.anant.smartagro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SuggestResult extends AppCompatActivity {
    Bundle b;
    String nitrogen,potassium,phosphorous;
    Integer n,p,k;
    ImageView img;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggest_result);
        b=getIntent().getExtras();
        nitrogen=b.getString("nitrogen");
        potassium=b.getString("potassium");
        phosphorous=b.getString("phosphorous");
        n=Integer.parseInt(nitrogen);
        k=Integer.parseInt(potassium);
        p=Integer.parseInt(phosphorous);
        img =(ImageView) findViewById(R.id.resultimage);
        tv=(TextView) findViewById(R.id.resulttext);


        if (n >= 10.0 && p <= 3.0 && k <= 1.0)
        {
            img.setImageResource(R.drawable.corn);
            tv.setText("You should grow CORN as your soil type matches SOIL113");

        }

        else if (n >= 10.0 && p >=3.0 && k >=1.0 ) {
            img.setImageResource(R.drawable.wheat);
            tv.setText("You should grow WHEAT as your soil type matches SOIL16 ");
        }

        else if (n >= 10.0 && p <=3.0 && k >=1.0 ){
            img.setImageResource(R.drawable.sugarcane);
            tv.setText("You should grow SUGARCANE as your soil type matches SOIL 45");
        }
        else if (n >= 10.0 && p >=3.0 && k <=1.0 ){
            img.setImageResource(R.drawable.rice);
            tv.setText("You should grow RICE as your soil type matches SOIL 98");
        }
        else if (n <= 10.0 && p <= 3.0 && k <= 1.0){
            img.setImageResource(R.drawable.jute);
            tv.setText("You should grow JUTE as your soil type matches SOIL 13");
        }
        else if (n <= 10.0 && p >=3.0 && k >=1.0 ){
            img.setImageResource(R.drawable.cotton);
            tv.setText("You should grow COTTON as your soil type matches SOIL 36");
        }
        else if (n <= 10.0 && p <=3.0 && k >=1.0 ){
            img.setImageResource(R.drawable.potato);
            tv.setText("You should grow POTATO as your soil type matches SOIL 55");
        }
        else if (n <= 10.0 && p >=3.0 && k <=1.0 ){
            img.setImageResource(R.drawable.onion);
            tv.setText("You should grow ONION as your soil type matches SOIL 65");
        }
    }
}
