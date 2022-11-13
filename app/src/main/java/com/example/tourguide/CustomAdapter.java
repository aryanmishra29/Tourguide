package com.example.tourguide;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


public class CustomAdapter extends ArrayAdapter<Country> {


        public CustomAdapter(@NonNull Context context, ArrayList<Country> arrayList) {

            // pass the context and arrayList for the super
            // constructor of the ArrayAdapter class
            super(context, 0, arrayList);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            // convertView which is recyclable view
            View currentItemView = convertView;

            // of the recyclable view is null then inflate the custom layout for the same
            if (currentItemView == null) {
                currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.customlist, parent, false);
            }

            // get the position of the view from the ArrayAdapter
            Country country = getItem(position);
            TextView magnitude = currentItemView.findViewById(R.id.country);
            magnitude.setText(country.getName());
            magnitude.setTextColor(Color.parseColor("#585F65"));


            // then return the recyclable view
            return currentItemView;
        }


}

