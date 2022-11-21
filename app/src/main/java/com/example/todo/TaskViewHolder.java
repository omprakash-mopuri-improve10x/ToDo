package com.example.todo;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TaskViewHolder extends RecyclerView.ViewHolder {

    public TextView taskNameTxt;
    public TextView taskDescriptionTxt;

    public TaskViewHolder(@NonNull View itemView) {
        super(itemView);
        taskNameTxt = itemView.findViewById(R.id.task_name_txt);
        taskDescriptionTxt = itemView.findViewById(R.id.task_description_txt);
    }
}
