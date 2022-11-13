package com.example.tourguide;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Country_Activity extends AppCompatActivity {
    ListView listView;
    CustomAdapter mAdapter;
    private static final String URL="https://countriesnow.space/api/v0.1/countries";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.country_name);
        listView=findViewById(R.id.listView);
        listView.setAdapter(mAdapter);
        CountryAsyncTask task = new CountryAsyncTask();
        task.execute(URL);
        mAdapter = new CustomAdapter(this, new ArrayList<Country>());
        listView.setAdapter(mAdapter);
    }
    private boolean isConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }
    private class CountryAsyncTask extends AsyncTask<String, Void, List<Country>> {

        @Override
        protected List<Country> doInBackground(String... urls) {
            if (urls.length < 1 || urls[0] == null) {
                return null;
            }

            List<Country> result = QueryUtils.fetchCountryData(urls[0]);
            return result;
        }

        @Override
        protected void onPostExecute(List<Country> data) {
            boolean isConnected = isConnected();
            View loadingIndicator = findViewById(R.id.loading_indicator);

            mAdapter.clear();
            if(isConnected) {

                loadingIndicator.setVisibility(View.GONE);
                mAdapter.addAll(data);
            }
            else{
                loadingIndicator.setVisibility(View.GONE);
                TextView txt=findViewById(R.id.empty_view);
                txt.setText("No Internet");
            }

            if (data != null && !data.isEmpty()) {

            }



        }
    }
}
