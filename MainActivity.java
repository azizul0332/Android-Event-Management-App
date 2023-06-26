package com.example.eventmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView uName;
    SharedPreferences ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        uName = findViewById(R.id.name);
        // initialize the shared preference
        ref = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        // set the name to edit text after getting it from preferences
        uName.setText(ref.getString("name",""));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if (item.getItemId() == R.id.logout){
            logout();
        }
        return true;
    }
    private void logout(){
        ref.edit().putBoolean("login",false).apply();
        Intent i = new Intent(MainActivity.this,signinActivity.class);
        startActivity(i);
    }

    public void btn_createNew(View view){
        Intent i = new Intent(MainActivity.this,addActivity.class);
        startActivity(i);
    }
    public void btn_history(View view){
        Toast.makeText(MainActivity.this, "No History available", Toast.LENGTH_SHORT).show();
    }
    public void btn_exit(View view){
        finish();
    }

}