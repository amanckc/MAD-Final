package com.freechat.flashchatnewfirebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class About_developers extends AppCompatActivity {
Button b1;
    ImageView i1,i2;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_about_developers);
        b1= (Button) findViewById (R.id.Back);
        i1= (ImageView) findViewById (R.id.abhi);
        i2= (ImageView) findViewById (R.id.aman);
        b1.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View v) {
                Intent i=new Intent (About_developers.this,LoginActivity.class);

                startActivity (i);
                finish ();
            }
        });
    }


}

