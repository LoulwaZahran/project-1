package com.example.project_i;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class WeightConverter extends AppCompatActivity {
    Spinner spFrom, spTo;
    TextView tvRes;
    EditText etWeightFrom;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_converter);
        spFrom = (Spinner) findViewById(R.id.spWeightFrom);
        etWeightFrom = (EditText) findViewById(R.id.etWeightFromVal);
        spTo = (Spinner) findViewById(R.id.spWeightTo);
        tvRes = (TextView) findViewById(R.id.tvWeightRes);
    }

    public void ConvertWeight(View view)
    {
        String FromVal = etWeightFrom.getText().toString();
        String SelectedWeightFrom = String.valueOf(spFrom.getSelectedItem());
        String SelectedWeightTo = String.valueOf(spTo.getSelectedItem());
        Double result = 0.0;

        if (FromVal.equals(""))
        {
            Toast.makeText(this, "Please enter a value !", Toast.LENGTH_LONG);
        }
        switch (SelectedWeightFrom) {
            case "Kilograms":
                if (SelectedWeightTo.equals("Pounds"))
                {
                    result = Double.parseDouble(etWeightFrom.getText().toString()) * 2.20462262;
                    tvRes.setText(result.toString());
                }
                else
                {
                    Toast.makeText(this, "Can't convert to same Weight Unit !", Toast.LENGTH_LONG);
                    break;
                }

            case "Pounds":
                if (SelectedWeightTo.equals("Kilograms"))
                {
                    result = Double.parseDouble(etWeightFrom.getText().toString()) / 2.20462262;
                    tvRes.setText(result.toString());
                }
                else
                {
                    Toast.makeText(this, "Can't convert to same Weight Unit !", Toast.LENGTH_LONG);
                }
                break;
        }
    }
    public void goBack(View v)
    {
        Intent t = new Intent();
        t = new Intent(this,MainActivity.class);
        startActivity(t);
    }
}
