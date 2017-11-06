package com.freechat.flashchatnewfirebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class About_app extends AppCompatActivity {
Button b1,b2;
    TextView t1;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_about_app);
        t1= (TextView) findViewById (R.id.textView);
        b1= (Button) findViewById (R.id.Developers);
        b2= (Button) findViewById (R.id.Back);
        //t1.setText ("hi about app");


        b1.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View v) {
                Intent i=new Intent (About_app.this,About_developers.class);

                startActivity (i);
                finish ();
            }
        });

        b2.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View v) {
                Intent j=new Intent (About_app.this,LoginActivity.class);

                startActivity (j);
                finish ();
            }
        });

    }



    }

