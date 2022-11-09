package com.example.retrofitpost.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitpost.R;
import com.example.retrofitpost.models.Todos;

import java.util.ArrayList;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViwe> {
    ArrayList<Todos> arrayList;
    Context context;

    public TodoAdapter(ArrayList<Todos> arrayList) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public TodoAdapter.TodoViwe onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.todosrecyclerow,parent,false);
        return new TodoViwe(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoAdapter.TodoViwe holder, int position) {
        holder.txt.setText(arrayList.get(position).userId);
        holder.txt1.setText(arrayList.get(position).id);
        holder.txt2.setText(arrayList.get(position).title);
        holder.txt3.setText(arrayList.get(position).completed);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class TodoViwe extends RecyclerView.ViewHolder {
        public TextView txt,txt1,txt2,txt3;
        public TodoViwe(@NonNull View itemView) {
            super(itemView);
            txt=itemView.findViewById(R.id.userId);
            txt1=itemView.findViewById(R.id.Id);
            txt2=itemView.findViewById(R.id.title);
            txt3=itemView.findViewById(R.id.completed);



        }
    }
}
