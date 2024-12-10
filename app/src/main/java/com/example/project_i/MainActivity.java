package com.example.project_i;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    ImageButton imgCurr,imgTemp,imgWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgCurr =(ImageButton)findViewById(R.id.imgCurrConv);
        imgCurr.setOnClickListener(this);

        imgTemp =(ImageButton)findViewById(R.id.imgTempConv);
        imgTemp.setOnClickListener(this);

        imgWeight =(ImageButton)findViewById(R.id.imgWeightConv);
        imgWeight.setOnClickListener(this);


    }

    @Override
    public void onClick(View v)
    {
        Intent t = new Intent();
        switch (v.getId())
        {
            case R.id.imgCurrConv:
            t=new Intent(this,CurrConverter.class);
            startActivity(t);
            break;

            case R.id.imgTempConv:
                t=new Intent(this,TempConverter.class);
                startActivity(t);
                break;

            case R.id.imgWeightConv:
                t=new Intent(this,WeightConverter.class);
                startActivity(t);
                break;

            default:
                Toast.makeText(this, "Click on one of the three Buttons", Toast.LENGTH_LONG);
        }

    }
    public void back(View view)
    {
    }
}