package com.example.piggypop;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void oinkClick(View v){
        Toast toast = Toast.makeText(this, "Welcome to Piggy Pop!", Toast.LENGTH_SHORT);
        toast.show();

    }
    public void startClick(View v){
        Intent intentR = new Intent(this, Popping_screen.class);
         startActivity(intentR);
    }

}