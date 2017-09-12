package com.example.anant.smartagro;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Query extends AppCompatActivity {

    EditText q;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);
        q=(EditText) findViewById(R.id.query);
    }


    public void query(View view){
        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
        sendIntent.setType("plain/text");
        sendIntent.setData(Uri.parse("anantsingh1010@gmail.com"));
        sendIntent.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
        sendIntent.putExtra(Intent.EXTRA_EMAIL, new String[] { "anantsingh1010@gmail.com" });
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Query To Smart Agro");
        sendIntent.putExtra(Intent.EXTRA_TEXT,q.getText().toString());
        startActivity(sendIntent);
    }
}
