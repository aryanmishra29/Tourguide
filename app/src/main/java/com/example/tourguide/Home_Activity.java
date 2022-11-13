package com.example.tourguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Home_Activity extends AppCompatActivity {
    TextView tv_welcome;
    ImageView iv_menu;
    ImageView iv_acc_dp;
    ImageButton but_search;
    EditText et_search;
    ImageView ivclick_hotel;
    ImageView ivclick_travel;
    ImageView ivclick_food;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        tv_welcome = findViewById(R.id.tv_welcome);
        iv_menu = findViewById(R.id.iv_home_menu);
        iv_acc_dp = findViewById(R.id.iv_home_account);
        but_search = findViewById(R.id.but_home_search);
        et_search = findViewById(R.id.et_home_search);
        ivclick_food = findViewById(R.id.iv_home_food);
        ivclick_hotel = findViewById(R.id.iv_home_hotel);
        ivclick_travel = findViewById(R.id.iv_home_travel);


        String name="";
        //get the name from firebase(login)
       // tv_welcome.setText("Welcome, "+name);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }
}