package com.example.todo;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TaskViewHolder extends RecyclerView.ViewHolder {

    public TextView taskNameTxt;
    public TextView taskDescriptionTxt;
    public ImageButton deleteIb;

    public TaskViewHolder(@NonNull View itemView) {
        super(itemView);
        taskNameTxt = itemView.findViewById(R.id.task_name_txt);
        taskDescriptionTxt = itemView.findViewById(R.id.task_description_txt);
        deleteIb = itemView.findViewById(R.id.delete_ib);
    }
}
