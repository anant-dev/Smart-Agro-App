package com.example.anant.smartagro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {


    SharedPreferences pref;
    SharedPreferences.Editor editor;
    EditText user, pass1,pass2,contact;
    Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        init();
        final String name = user.getText().toString();
        final String p1=pass1.getText().toString();
        final String p2=pass2.getText().toString();
        final String mobile=contact.getText().toString();
        pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        editor = pref.edit();
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("contact_number",mobile);
                editor.putString("username",name);
                if (p1.equals(p2)&&(!p1.equals("")))
                {
                    editor.putString("password",p1);
                }
                else{
                    Toast.makeText(Signup.this, "Incorrect password", Toast.LENGTH_LONG).show();
                    pass1.setText("");
                    pass2.setText("");
                }
                editor.commit();
                Intent i = new Intent(Signup.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void init() {
        user=(EditText)findViewById(R.id.username);
        pass1=(EditText)findViewById(R.id.pass1);
        pass2=(EditText)findViewById(R.id.pass2);
        contact=(EditText)findViewById(R.id.contact);
        signup=(Button) findViewById(R.id.signup);
    }

}
