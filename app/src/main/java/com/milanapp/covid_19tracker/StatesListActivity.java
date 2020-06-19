package com.milanapp.covid_19tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.milanapp.covid_19tracker.Adapter.StatesAdapter;
import com.milanapp.covid_19tracker.Model.MainStatisticModel;
import com.milanapp.covid_19tracker.Model.RegionDatum;

import java.util.ArrayList;
import java.util.List;

public class StatesListActivity extends AppCompatActivity {
    private  static final String URL = "https://api.apify.com/v2/key-value-stores/toDWvRj1JpTXiM8FF/records/LATEST?disableRedirect=true";
    private RecyclerView recyclerView;
    private List<RegionDatum> regionDatumList;
    private StatesAdapter statesAdapter;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_states_list);

        recyclerView = findViewById(R.id.states_list_recycler);
        regionDatumList = new ArrayList<>();


        recyclerView.setHasFixedSize(true);
        statesAdapter = new StatesAdapter(this,regionDatumList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(statesAdapter);
        JsonRequest();


    }

    private void JsonRequest() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.serializeNulls().create();

                MainStatisticModel mainStatisticModel = gson.fromJson(response,MainStatisticModel.class);
                regionDatumList.clear();

                regionDatumList.addAll(mainStatisticModel.getRegionData());
                statesAdapter.notifyDataSetChanged();

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(StatesListActivity.this, "Error", Toast.LENGTH_SHORT).show();

            }
        });

        requestQueue = Volley.newRequestQueue(StatesListActivity.this);
        requestQueue.add(stringRequest);
    }



}