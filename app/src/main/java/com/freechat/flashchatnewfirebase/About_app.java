package com.freechat.flashchatnewfirebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class About_app extends AppCompatActivity {
//Button b1,b2;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_about_app);
        //b1= (Button) findViewById (R.id.chat_button);
        //b2= (Button) findViewById (R.id.dev_button);

    }
    public void onChat(){//go to chat
        Intent i=new Intent (About_app.this,MainChatActivity.class);
        finish ();
        startActivity (i);


    }

    public void onDev(){//go to about developers
        Intent i=new Intent (About_app.this,About_developers.class);
        finish ();
        startActivity (i);
    }



    }

