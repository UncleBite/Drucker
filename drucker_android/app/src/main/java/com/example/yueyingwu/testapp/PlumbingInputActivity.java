package com.example.yueyingwu.testapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.StaticLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class PlumbingInputActivity extends AppCompatActivity {

    static String waterCostPlumb;
    static String taxRatePlumb;
    static String minReturnPlumb;
    static String spinnerOld3Plumb;
    static String spinnerNew4Plumb;
    static String oldNumFixturePlumb;
    static String newNumFixturePlumb;
    static String oldPricePlumb;
    static String newPricePlumb;
    static String oldFlowRatePlumb;
    static String newFlowRatePlumb;
    static String oldEstimatedHoursPerDayPlumb;
    static String newEstimatedHoursPerDayPlumb;
    static String rebatesPlumb;

    static Double escaltingRatePlumbing;
    static Double npvPlumbing;
    static Double irrPlumbing;
    static Double simplyPaybackPeriodPlumbing;

    final TextView display2 = findViewById(R.id.display2);

    public void toBulbInput(View v) {
        Intent bulbInputIntent = new Intent(getApplicationContext(), BulbInputActivity.class);
        startActivity(bulbInputIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plumbing_input);


        final ImageButton iBquestion2=findViewById(R.id.iBquestion2);
        iBquestion2.setScaleType(ImageButton.ScaleType.FIT_XY);
        iBquestion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent manualIntent2 = new Intent(getApplicationContext(), TrainLightActivity.class);
                startActivity(manualIntent2);
            }
        });

        final EditText etWaterCost = findViewById(R.id.etWaterCost);
        final EditText etTaxRate = findViewById(R.id.etTaxRate);
        final EditText etMinReturn =  findViewById(R.id.etMinReturn2);
        final Spinner spinner3 = findViewById(R.id.spinner3);
        final Spinner spinner4 = findViewById(R.id.spinner4);
        final EditText etOldNumFixture = findViewById(R.id.etOldNumFixture);
        final EditText etNewNumFixture = findViewById(R.id.etNewNumFixture);

        final EditText etOldPrice = findViewById(R.id.etOldPrice);
        final EditText etNewPrice = findViewById(R.id.etNewPrice);
        final EditText etOldFlowRate = findViewById(R.id.etOldFlowRate);
        final EditText etNewFlowRate = findViewById(R.id.etNewFlowRate);
        final EditText etOldEstimatedHoursPerDay = findViewById(R.id.etOldEstimatedHoursPerDay);
        final EditText etNewEstimatedHoursPerDay = findViewById(R.id.etNewEstimatedHoursPerDay);
        final EditText etRebates=findViewById(R.id.etRebates);

        final Button bSubmit = findViewById(R.id.bSubmit);
        final Button bBackBulb = findViewById(R.id.bBackBulb);
        final Button bClearPlumb = findViewById(R.id.bClearPlumb);

        bClearPlumb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etTaxRate.getText().clear();
                etWaterCost.getText().clear();
                etMinReturn.getText().clear();
                etOldNumFixture.getText().clear();
                etNewNumFixture.getText().clear();
                etOldPrice.getText().clear();
                etNewPrice.getText().clear();
                etOldFlowRate.getText().clear();
                etNewFlowRate.getText().clear();
                etOldEstimatedHoursPerDay.getText().clear();
                etNewEstimatedHoursPerDay.getText().clear();
                etRebates.getText().clear();
            }
        });

        bSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                waterCostPlumb = etWaterCost.getText().toString();
                taxRatePlumb = etTaxRate.getText().toString();
                minReturnPlumb = etMinReturn.getText().toString();
                spinnerOld3Plumb = spinner3.getSelectedItem().toString();
                spinnerNew4Plumb = spinner4.getSelectedItem().toString();
                oldNumFixturePlumb = etOldNumFixture.getText().toString();
                newNumFixturePlumb = etNewNumFixture.getText().toString();
                oldPricePlumb = etOldPrice.getText().toString();
                newPricePlumb = etNewPrice.getText().toString();
                oldFlowRatePlumb = etOldFlowRate.getText().toString();
                newFlowRatePlumb = etNewFlowRate.getText().toString();
                oldEstimatedHoursPerDayPlumb = etOldEstimatedHoursPerDay.getText().toString();
                newEstimatedHoursPerDayPlumb = etNewEstimatedHoursPerDay.getText().toString();
                rebatesPlumb=etRebates.getText().toString();

                plumbToServer connectPlumb=new plumbToServer();
                connectPlumb.execute();
//                display2.setText(spinnerOld3);
                //etTaxRate.getText().clear();
            }
        });

    }
    private class plumbToServer extends AsyncTask<Void,Void,Void> {
        private String receivedDataPlumb = "";
        @Override
        protected Void doInBackground(Void... voids) {
            String sendURL="http://localhost:8080/PlumbModul?y1="+waterCostPlumb+"&y2="+taxRatePlumb+"&y3="+minReturnPlumb+"&s1="+spinnerOld3Plumb+"&s2="+spinnerNew4Plumb+"&y4="+oldNumFixturePlumb+"&y8="+newNumFixturePlumb+"&y5="+oldPricePlumb+"&y9="+newPricePlumb+"&y6="+oldFlowRatePlumb+"&y10="+newFlowRatePlumb+"&y7="+oldEstimatedHoursPerDayPlumb+"&y11="+newEstimatedHoursPerDayPlumb+"&y12="+rebatesPlumb;
            try {
                URL url=new URL(sendURL);
                try {
                    HttpURLConnection response=(HttpURLConnection) url.openConnection();
                    InputStream input = response.getInputStream();
                    BufferedReader buffer = new BufferedReader(new InputStreamReader(input));
                    String line = "";
                    while(line != null){
                        line = buffer.readLine();
                        receivedDataPlumb = receivedDataPlumb+line;
                    }
                    try {
                        JSONObject receivedString=new JSONObject(receivedDataPlumb);
                        escaltingRatePlumbing=receivedString.getDouble("escaltingRate");
                        npvPlumbing=receivedString.getDouble("npv");
                        irrPlumbing=receivedString.getDouble("irr");
                        simplyPaybackPeriodPlumbing=receivedString.getDouble("simplyPaybackPeriod");

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            display2.setText("Escalting Rate: "+Double.toString(escaltingRatePlumbing)+"\n"+"NPV"+Double.toString(npvPlumbing)+"\n"+"IRR"+Double.toString(irrPlumbing)+"\n"+"Simple Payback period (year)"+Double.toString(simplyPaybackPeriodPlumbing)+"\n");
        }
    }
}
