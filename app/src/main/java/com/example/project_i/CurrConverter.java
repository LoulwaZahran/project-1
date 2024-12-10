package com.example.project_i;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CurrConverter extends AppCompatActivity {
    Spinner spFrom,spTo ;
    TextView tvRes;
    EditText etCurrFrom;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curr_converter);
        spFrom=(Spinner)findViewById(R.id.spCurrFrom);
        etCurrFrom=(EditText)findViewById(R.id.etCurrFromAmt);
        spTo=(Spinner)findViewById(R.id.spCurrTo);
        tvRes=(TextView) findViewById(R.id.tvCurrRes);
        // btnBack=(Button)findViewById(R.id.)
    }
    public void ConvertCurr(View v)
    {
        String FromVal=etCurrFrom.getText().toString();
        String SelectedCurrFrom=String.valueOf(spFrom.getSelectedItem());
        String SelectedCurrTo=String.valueOf(spTo.getSelectedItem());
        Double result=0.0;

        if(FromVal.equals(""))
        {
            //Toast.makeText(this,"Please enter a value !",Toast.LENGTH_LONG);
            Toast.makeText(this,"Please",Toast.LENGTH_LONG);
        }
        switch (SelectedCurrFrom)
        {
            case "LBP":
                if (SelectedCurrTo.equals("USD"))
                {
                    result = Double.parseDouble(etCurrFrom.getText().toString()) / 90000;
                    tvRes.setText(result.toString());
                }
                else if (SelectedCurrTo.equals("EUR"))
                {
                    result = Double.parseDouble(etCurrFrom.getText().toString())/ 94000;
                    tvRes.setText(result.toString());
                }

                else{
                    Toast.makeText(this,"Can't convert to same Currency !",Toast.LENGTH_LONG);
                }
                break;

            case "USD":
                if (SelectedCurrTo.equals("LBP"))
                {
                    result = Double.parseDouble(etCurrFrom.getText().toString()) * 90000;
                    tvRes.setText(result.toString());
                }
                else if (SelectedCurrTo.equals("EUR"))
                {
                    result = Double.parseDouble(etCurrFrom.getText().toString())* 0.94;
                    tvRes.setText(result.toString());
                }
                else
                {
                    Toast.makeText(this,"Can't convert to same Currency !",Toast.LENGTH_LONG);
                }
                break;

            case "EUR":
                if (SelectedCurrTo.equals("LBP"))
                {
                    result = Double.parseDouble(etCurrFrom.getText().toString()) * 94000 ;
                    tvRes.setText(result.toString());
                }
                else if (SelectedCurrTo.equals("USD"))
                {
                    result = Double.parseDouble(etCurrFrom.getText().toString())*0.94;
                    tvRes.setText(result.toString());
                }
                else
                {
                    Toast.makeText(this,"Can't convert to same Currency !",Toast.LENGTH_LONG);
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