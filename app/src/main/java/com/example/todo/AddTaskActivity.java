package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AddTaskActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        getSupportActionBar().setTitle("Add Task");
        handleAddBtn();
    }

    public void handleAddBtn() {
        Button addBtn = findViewById(R.id.add_btn);
        addBtn.setOnClickListener(view -> {
            EditText taskNameTxt = findViewById(R.id.task_name_txt);
            String taskName = taskNameTxt.getText().toString();
            EditText taskDescriptionTxt = findViewById(R.id.task_description_txt);
            String taskDescription = taskDescriptionTxt.getText().toString();
            Intent intent = new Intent(this, TaskListActivity.class);
            startActivity(intent);
        });
    }
}