package com.freechat.flashchatnewfirebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class About_developers extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_about_developers);
    }
    public  void onClick(){
        Intent i=new Intent (About_developers.this,About_app.class);
        finish ();
        startActivity (i);
    }

}

