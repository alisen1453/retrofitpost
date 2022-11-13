package com.example.retrofitpost.adapters;

import android.content.Context;
import android.content.Intent;
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
        this.context = context;
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
                //Toast.makeText(holder.itemView.getContext(), arrayList.get(holder.getAdapterPosition()).id, Toast.LENGTH_SHORT).show();
                String a=arrayList.get(holder.getAdapterPosition()).userId;
                String b=arrayList.get(holder.getAdapterPosition()).id;
                String c=arrayList.get(holder.getAdapterPosition()).title;
                String d=arrayList.get(holder.getAdapterPosition()).completed;

                Intent intentsent=new Intent(holder.itemView.getContext(),MainActivity3.class);
                intentsent.putExtra("data1",a);
                intentsent.putExtra("data2",b);
                intentsent.putExtra("data3",c);
                intentsent.putExtra("data4",d);
                holder.itemView.getContext().startActivity(intentsent);

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
