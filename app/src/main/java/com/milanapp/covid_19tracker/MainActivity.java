package com.milanapp.covid_19tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private TextView tv_total_case,tv_active_case,tv_recover_case,tv_death_case;
    private Button states_list_btn;
    RequestQueue requestQueue;
    String activeCases,recovered,deaths,totalCases;

    String JsonURL = "https://api.apify.com/v2/key-value-stores/toDWvRj1JpTXiM8FF/records/LATEST?disableRedirect=true";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        tv_total_case=findViewById(R.id.tv_total_case);
        tv_active_case=findViewById(R.id.tv_active_case);
        tv_death_case=findViewById(R.id.tv_deaths_case);
        tv_recover_case=findViewById(R.id.tv_recover_case);
        states_list_btn=findViewById(R.id.state_list_btn);
        requestQueue = Volley.newRequestQueue(this);

        ApiDataFetch();

        states_list_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,StatesListActivity.class);
                startActivity(intent);
            }
        });

    }

    private void ApiDataFetch() {


        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, JsonURL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    activeCases=response.getString("activeCases");
                    recovered=response.getString("recovered");
                    deaths=response.getString("deaths");
                    totalCases=response.getString("totalCases");

                    tv_total_case.setText(totalCases);
                    tv_active_case.setText(activeCases);
                    tv_death_case.setText(deaths);
                    tv_recover_case.setText(recovered);



                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(MainActivity.this, "internet is not availble", Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(objectRequest);
    }
}
