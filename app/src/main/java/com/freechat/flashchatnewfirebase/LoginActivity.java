package com.freechat.flashchatnewfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginActivity extends AppCompatActivity {

    // TODO: Add member variables here:
    // UI references.
    private FirebaseAuth mAuth;
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmailView = (AutoCompleteTextView) findViewById(R.id.login_email);
        mPasswordView = (EditText) findViewById(R.id.login_password);

        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        // TODO: Grab an instance of FirebaseAuth
        mAuth=FirebaseAuth.getInstance ();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem mi) {
        switch(mi.getItemId()) {
            case R.id.app:
                Intent intent=new Intent(LoginActivity.this,About_app.class);
                finish ();
                startActivity (intent);
                return true;
            case R.id.dev:
                Intent intent1=new Intent(LoginActivity.this,About_developers.class);
                finish ();
                startActivity (intent1);
                return true;
            default:return super.onOptionsItemSelected(mi);

        }
    }

    // Executed when Sign in button pressed
    public void signInExistingUser(View v)   {
        // TODO: Call attemptLogin() here
        attemptLogin ();

    }

    // Executed when Register button pressed
    public void registerNewUser(View v) {
        Intent intent = new Intent(this, com.freechat.flashchatnewfirebase.RegisterActivity.class);
        finish();
        startActivity(intent);
    }

    // TODO: Complete the attemptLogin() method
    private void attemptLogin() {
        String email=mEmailView.getText ().toString ();
        String password=mPasswordView.getText ().toString ();
        if(email.equals ("")||password.equals ((""))) return;
        Toast.makeText (this, "LOgin in progress", Toast.LENGTH_SHORT).show ();

        


        // TODO: Use FirebaseAuth to sign in with email & password
        mAuth.signInWithEmailAndPassword (email,password).addOnCompleteListener (this, new OnCompleteListener<AuthResult> () {
            @Override
            public void onComplete (@NonNull Task<AuthResult> task) {
                Log.d("Free chat","sign in with email complete oncomplete"+task.isSuccessful ());
                if(!task.isSuccessful ()){
                    Log.d("Free chat","Problem signing in"+task.getException ());
                    showErrorDialog ("There was a problem signing in");

                }else {
                    Intent intent=new Intent(LoginActivity.this,MainChatActivity.class);
                    finish ();
                    startActivity (intent);
                }
            }
        });



    }

    // TODO: Show error on screen with an alert dialog

    private  void showErrorDialog(String message){
        new AlertDialog.Builder (this)
                .setTitle ("Oops!!")
                .setMessage (message)
                .setPositiveButton (android.R.string.ok,null)
                .setIcon (android.R.drawable.ic_dialog_alert)
                .show();
    }



}