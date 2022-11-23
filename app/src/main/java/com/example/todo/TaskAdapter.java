package com.example.todo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskViewHolder> {

    public List<Task> tasks;
    public OnItemActionListener onItemActionListener;

    public void setData(List<Task> tasksList) {
        tasks = tasksList;
        notifyDataSetChanged();
    }

    public void setOnItemActionListener(OnItemActionListener actionListener) {
        onItemActionListener = actionListener;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_list_item, parent, false);
        TaskViewHolder taskViewHolder = new TaskViewHolder(view);
        return taskViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task task = tasks.get(position);
        holder.taskNameTxt.setText(task.name);
        holder.taskDescriptionTxt.setText(task.description);
        holder.deleteIb.setOnClickListener(view -> {
            onItemActionListener.onDelete(task.id);
        });
        holder.itemView.setOnClickListener(view -> {
            onItemActionListener.onEdit(task);
        });
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }
}
