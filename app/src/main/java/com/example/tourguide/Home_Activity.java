package com.example.tourguide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Home_Activity extends AppCompatActivity {
    TextView welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        welcome = findViewById(R.id.tv_welcome);
        String name="";
        //get the name from firebase(login)
        welcome.setText("Welcome, "+name);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
}