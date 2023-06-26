package com.example.eventmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class signupActivity extends AppCompatActivity {


    EditText uname,uemail,uphone,uuserid,upass,ure_pass;
    SharedPreferences ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        uname = findViewById(R.id.name);
        uemail = findViewById(R.id.email);
        uphone = findViewById(R.id.phone);
        uuserid = findViewById(R.id.userid);
        upass = findViewById(R.id.pass);
        ure_pass = findViewById(R.id.re_pass);

        // initialize the shared preference in private mode
        ref = getSharedPreferences("MySharedPref",MODE_PRIVATE);

    }

    public void go_signup(View view) {

        //getting edit text values
        String name = uname.getText().toString();
        String email = uemail.getText().toString();
        String phone = uphone.getText().toString();
        String userid = uuserid.getText().toString();
        String pass = upass.getText().toString();
        String re_pass = ure_pass.getText().toString();

        //save the values to shared preferences
        ref.edit().putString("name",name).apply();
        ref.edit().putString("email",email).apply();
        ref.edit().putString("phone",phone).apply();
        ref.edit().putString("userid",userid).apply();
        ref.edit().putString("pass",pass).apply();
        ref.edit().putString("re_pass",re_pass).apply();
        ref.edit().putBoolean("login",true).apply();

        //call the main activity after signup successfull
        Intent i = new Intent(signupActivity.this,MainActivity.class);
        startActivity(i);

    }
    public void Login(View view){
        Intent i = new Intent(signupActivity.this,signinActivity.class);
        startActivity(i);
    }
    public void exit(View view){
        finish();
    }
}