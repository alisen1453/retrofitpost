package com.example.retrofitpost;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;

import com.example.retrofitpost.adapters.TodoAdapter;
import com.example.retrofitpost.clients.RetrofitClient;
import com.example.retrofitpost.models.Todos;
import com.example.retrofitpost.models.User;
import com.example.retrofitpost.services.todosprovider.TodosApiInterface;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {
    public TodosApiInterface api;
    public ArrayList<Todos> arrayttodos;
    public TodoAdapter todoAdapter;
    public Todos todos;
    public RecyclerView recyclerView;
    CompositeDisposable compositeDisposable;


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        loadData();
        arrayttodos = new ArrayList<>();
        recyclerView = findViewById(R.id.recycleview);

    }


    public void loadData() {
        api = RetrofitClient.getRetrofitInstance("https://jsonplaceholder.typicode.com/")
                .create(TodosApiInterface.class);
        compositeDisposable=new CompositeDisposable();
        compositeDisposable.add(api.getvalue().
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(this::todosrespons));

        /*
        api.getvalue().enqueue(new Callback<List<Todos>>() {
            @Override
            public void onResponse(Call<List<Todos>> call, Response<List<Todos>> response) {
                arrayttodos = new ArrayList<>();
                if (response.isSuccessful()) {
                    List<Todos> todosList = response.body();
                    arrayttodos = new ArrayList<>(todosList);
                    todoAdapter = new TodoAdapter(arrayttodos);
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity2.this));
                    recyclerView.setAdapter(todoAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Todos>> call, Throwable t) {

            }
        });*/
    }
    private void todosrespons(List<Todos> todoslist){
            arrayttodos=new ArrayList<>(todoslist);
            todoAdapter = new TodoAdapter(arrayttodos);
            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity2.this));
            recyclerView.setAdapter(todoAdapter);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }

}