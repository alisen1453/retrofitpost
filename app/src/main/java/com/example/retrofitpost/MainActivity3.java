package com.example.retrofitpost;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.retrofitpost.models.Todos;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
TextView txt,txt1,txt2,txt3;
//*/-+
// 3  ArrayList<Todos> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        txt=findViewById(R.id.txt);
        txt1=findViewById(R.id.txt1);
        txt2=findViewById(R.id.txt2);
        txt3=findViewById(R.id.txt3);
        Intent intentholderpost=getIntent();

        txt.setText(intentholderpost.getStringExtra("data1"));
        txt1.setText(intentholderpost.getStringExtra("data2"));
        txt2.setText(intentholderpost.getStringExtra("data3"));
        txt3.setText(intentholderpost.getStringExtra("data4"));

    }
}