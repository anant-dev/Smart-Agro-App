package com.example.anant.smartagro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SuggestCrop extends AppCompatActivity {
    EditText n,p,k;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggest_crop);
        Button login=(Button) findViewById(R.id.suggest);
        init();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle b = new Bundle();
                Intent i = new Intent(SuggestCrop.this,SuggestResult.class);
                b.putString("nitrogen", n.getText().toString());
                b.putString("potassium",p.getText().toString());
                b.putString("phosphorous",k.getText().toString());
                i.putExtras(b);
                startActivity(i);
                finish();
            }
        });
    }

    private void init() {
        n=(EditText)findViewById(R.id.nitro);
        p=(EditText)findViewById(R.id.phos);
        k=(EditText)findViewById(R.id.potas);

    }
}
