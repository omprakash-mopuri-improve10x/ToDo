package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddTaskActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        getSupportActionBar().setTitle("Add Task");
        handleAddBtn();
    }

    public void addTask(String taskName, String description) {
        Task task = new Task();
        task.name = taskName;
        task.description = description;

        TodoApi todoApi = new TodoApi();
        TodoService todoService = todoApi.createTodoService();
        Call<Task> call = todoService.createTask(task);
        call.enqueue(new Callback<Task>() {
            @Override
            public void onResponse(Call<Task> call, Response<Task> response) {
                Toast.makeText(AddTaskActivity.this, "Success", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<Task> call, Throwable t) {
                Toast.makeText(AddTaskActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void handleAddBtn() {
        Button addBtn = findViewById(R.id.add_btn);
        addBtn.setOnClickListener(view -> {
            EditText taskNameTxt = findViewById(R.id.task_name_txt);
            String taskName = taskNameTxt.getText().toString();
            EditText taskDescriptionTxt = findViewById(R.id.task_description_txt);
            String taskDescription = taskDescriptionTxt.getText().toString();
            addTask(taskName, taskDescription);
        });
    }
}