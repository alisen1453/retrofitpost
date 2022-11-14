package com.example.retrofitpost.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitpost.MainActivity3;
import com.example.retrofitpost.R;
import com.example.retrofitpost.models.Todos;

import java.util.ArrayList;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViwe> {
    ArrayList<Todos> arrayList;
    Context context;

    public TodoAdapter(ArrayList<Todos> arrayList) {
        this.arrayList = arrayList;
        //this.context = context;
    }

    @NonNull
    @Override
    public TodoAdapter.TodoViwe onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todosrecyclerow, parent, false);
        return new TodoViwe(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoAdapter.TodoViwe holder, int position) {
        Todos todos = arrayList.get(position);
        holder.loaddata(todos);



        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),MainActivity3.class);
                intent.putExtra("data",todos.getId());
                intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP|intent.FLAG_ACTIVITY_CLEAR_TASK|
                        intent.FLAG_ACTIVITY_NEW_TASK);
                v.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class TodoViwe extends RecyclerView.ViewHolder {
        public TextView txt, txt1, txt2, txt3;

        public TodoViwe(@NonNull View itemView) {
            super(itemView);
            txt = itemView.findViewById(R.id.userId);
            txt1 = itemView.findViewById(R.id.Id);
            txt2 = itemView.findViewById(R.id.title);
            txt3 = itemView.findViewById(R.id.completed);
        }
        public void loaddata(Todos todos) {
            this.txt.setText(todos.getUserId());
            this.txt1.setText(todos.getId());
            this.txt2.setText(todos.getTitle());
            this.txt3.setText(todos.getCompleted());
        }

    }

}
