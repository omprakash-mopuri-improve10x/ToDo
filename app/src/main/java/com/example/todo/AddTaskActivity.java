package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddTaskActivity extends AppCompatActivity {

    public Task task;
    public Button updateBtn;
    public Button addBtn;
    public EditText taskNameTxt;
    public EditText taskDescriptionTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        findIds();
        if (getIntent().hasExtra("task")) {
            getSupportActionBar().setTitle("Edit Task");
            task = (Task) getIntent().getSerializableExtra("task");
            updateBtn.setVisibility(View.VISIBLE);
            addBtn.setVisibility(View.GONE);
            showData();
            handleUpdateBtn();
        } else {
            getSupportActionBar().setTitle("Add Task");
            addBtn.setVisibility(View.VISIBLE);
            updateBtn.setVisibility(View.GONE);
            handleAddBtn();
        }
    }

    public void updateTask(String id, String taskName, String description) {
        Task task = new Task();
        task.name = taskName;
        task.description = description;

        TodoApi todoApi = new TodoApi();
        TodoService todoService = todoApi.createTodoService();
        Call<Void> call = todoService.updateTask(id,task);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(AddTaskActivity.this, "Successfully updated task", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(AddTaskActivity.this, "Failed to update task", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void showData() {
        taskNameTxt.setText(task.name);
        taskDescriptionTxt.setText(task.description);
    }

    public void findIds() {
        addBtn = findViewById(R.id.add_btn);
        updateBtn = findViewById(R.id.update_btn);
        taskNameTxt = findViewById(R.id.task_name_txt);
        taskDescriptionTxt = findViewById(R.id.task_description_txt);
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
        addBtn.setOnClickListener(view -> {
            String taskName = taskNameTxt.getText().toString();
            String taskDescription = taskDescriptionTxt.getText().toString();
            addTask(taskName, taskDescription);
        });
    }

    public void handleUpdateBtn() {
        updateBtn.setOnClickListener(view -> {
            String taskName = taskNameTxt.getText().toString();
            String description = taskDescriptionTxt.getText().toString();
            updateTask(task.id, taskName, description);
        });
    }
}