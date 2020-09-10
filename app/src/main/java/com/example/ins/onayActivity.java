package com.example.ins;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class onayActivity extends AppCompatActivity {
    EditText b_mail;
    private Bundle extras = null;
    private String str_email;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onay);

        b_mail = findViewById(R.id.b_mail);
        extras = getIntent().getExtras();
        str_email = extras.getString(girisActivity.MAIL);
        b_mail.setText( str_email);




    }
}