package com.example.retrofitpost;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class intent extends AppCompatActivity {
TextView textView1,textView2,textView3,textView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        textView1=findViewById(R.id.textView1);
        textView2=findViewById(R.id.textView2);
        textView3=findViewById(R.id.textView3);
        textView4=findViewById(R.id.textView4);
        Intent intent=getIntent();
        textView1.setText(intent.getStringExtra("data1"));
        textView2.setText(intent.getStringExtra("data2"));
        textView3.setText(intent.getStringExtra("data3"));
        textView4.setText(intent.getStringExtra("data4"));

    }
}