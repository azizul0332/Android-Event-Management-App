package com.example.eventmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class signinActivity extends AppCompatActivity {

    EditText uuserid,upass;
    SharedPreferences ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        uuserid = findViewById(R.id.userid);
        upass = findViewById(R.id.pass);

        // initialize the shared preference in private mode
        ref = getSharedPreferences("MySharedPref",MODE_PRIVATE);

    }

    public void go_signin(View view){

        String S_userid = ref.getString("userid","");
        String S_pass = ref.getString("pass","");

        if(S_userid.equals(uuserid.getText().toString()) && S_pass.equals(upass.getText().toString())){

            ref.edit().putBoolean("login",true).apply();
            Intent i = new Intent(signinActivity.this,MainActivity.class);
            startActivity(i);
        }
        else {
            Toast.makeText(this, "Invalid User", Toast.LENGTH_SHORT).show();
        }


    }
}