package com.milanapp.covid_19tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


public class DetaiActivity extends AppCompatActivity {
    private TextView tv_states_name;
    private TextView tv_total_case_region,tv_active_case_region,tv_recover_case_region,tv_death_case_region;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detai);
        tv_states_name=findViewById(R.id.tv_states_name);
        tv_active_case_region=findViewById(R.id.tv_active_case_region);
        tv_recover_case_region=findViewById(R.id.tv_recover_case_region);
        tv_death_case_region=findViewById(R.id.tv_deaths_case_region);
        tv_total_case_region=findViewById(R.id.tv_total_case_region);

        String region = (getIntent().getStringExtra("region"));
        Integer totalCases = (Integer) getIntent().getIntExtra("totalCases",0);
        Integer totalInfected = (Integer) getIntent().getIntExtra("totalInfected",0);
        Integer recovered = (Integer) getIntent().getIntExtra("recovered",0);
        Integer deceased = (Integer) getIntent().getIntExtra("deceased",0);



        tv_states_name.setText(region);
        tv_total_case_region.setText(String.valueOf(totalCases));
        tv_active_case_region.setText(String.valueOf(totalInfected));
        tv_death_case_region.setText(String.valueOf(deceased));
        tv_recover_case_region.setText(String.valueOf(recovered));



}


}
