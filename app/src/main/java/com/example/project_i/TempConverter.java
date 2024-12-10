package com.example.project_i;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class TempConverter extends AppCompatActivity {

    RadioButton rdCelc,rdFah;
    TextView txtRest;
    EditText etVal;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_converter);

        rdCelc = (RadioButton) findViewById(R.id.radioCelc);
        rdFah = (RadioButton) findViewById(R.id.radioFah);
        txtRest = (TextView) findViewById(R.id.txtRes);
        etVal = (EditText) findViewById(R.id.etTemp);
        }

    public void swap(View v)
    {
        if(rdCelc.isChecked())
            {
                rdFah.setChecked(true);
                rdCelc.setChecked(false);
            }
        else
            {
                rdCelc.setChecked(true);
                rdFah.setChecked(false);
            }
    }
        public void ConvertTemp(View v)
        {
            double result = 0.0;
            if (rdCelc.isChecked())
            {
                //rdFah.setEnabled(false);
                result = Double.parseDouble(etVal.getText().toString())* (9.0/5.0)+32.0;;
                txtRest.setText(etVal.getText().toString() + " Celsius is : " + result + " Fahrenheit");

            }
            else if(rdFah.isChecked())
            {
                //rdCelc.setEnabled(false);
                result = Double.parseDouble(etVal.getText().toString());
                double a1 = result -32;
                double a2 = a1*5.0/9.0;

                txtRest.setText(etVal.getText().toString() + " Fahrenheit is : " + a2 + " Celsius");


            }
        }

    public void goBack(View v)
    {
        Intent t = new Intent();
        t = new Intent(this,MainActivity.class);
        startActivity(t);
    }


    }
