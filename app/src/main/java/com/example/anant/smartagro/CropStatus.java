package com.example.anant.smartagro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CropStatus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_status);
    }
    public void crop_status(View view){
        Intent i= new Intent(this,LiveFeed.class);
        startActivity(i);
    }
}

