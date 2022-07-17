package com.example.csvdata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    InputStream inputStream;
    String[] data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputStream=getResources().openRawResource(R.raw.sample);

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        Double sum=0D;
        int a=0;
        try{
            String CsvLine;
            while ((CsvLine= reader.readLine())!=null){
                data=CsvLine.split(",");

                try{
                    Log.e("Data",""+data[1]);
                    sum=sum+Double.parseDouble(data[1].toString());
                    a++;
                    if(a==10){
                        Log.e("Avg","Average of 10Data : "+sum/10);
                        a =0;
                        sum = 0D;
                    }

                } catch (Exception e) {
                    Log.e("Problem",e.toString());
                                    }
            }

        } catch (IOException ex) {
            throw new RuntimeException("Error in reading csv file:"+ex);
        }
    }
}