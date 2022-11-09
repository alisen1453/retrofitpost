package com.example.retrofitpost;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofitpost.clients.RetrofitClient;
import com.example.retrofitpost.models.User;
import com.example.retrofitpost.services.keyvalueprovider.KeyValueApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button button, button1;
    EditText name, surname;
    public KeyValueApiInterface keyValueApiInterface;
    public User user;
    ArrayList<User> arrayList;
    public TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.singup);
        button1 = findViewById(R.id.login);
        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singup();
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
    }

    public void singup() {
        user = new User(name.getText().toString(), surname.getText().toString());
        keyValueApiInterface = RetrofitClient.getRetrofitInstance("https://keyvaluegoservice.herokuapp.com").create(KeyValueApiInterface.class);
        Call<User> call = keyValueApiInterface.getdata(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Kayıt Başarılı", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });

    }


}

