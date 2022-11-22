package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TaskListActivity extends AppCompatActivity {

    public RecyclerView taskListRv;
    public ArrayList<Task> tasksList = new ArrayList<>();
    public TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        getSupportActionBar().setTitle("Task List");
        setupTaskListRv();
        handleAddButton();
        fetchData();
    }

    public void fetchData() {
        TodoApi todoApi = new TodoApi();
        TodoService todoService = todoApi.createTodoService();
        Call<List<Task>> call =  todoService.fetchTask();
        call.enqueue(new Callback<List<Task>>() {
            @Override
            public void onResponse(Call<List<Task>> call, Response<List<Task>> response) {
                List<Task> tasks =  response.body();
                taskAdapter.setData(tasks);
            }

            @Override
            public void onFailure(Call<List<Task>> call, Throwable t) {
                Toast.makeText(TaskListActivity.this, "Failed to load data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setupTaskListRv() {
        taskListRv = findViewById(R.id.task_list_rv);
        taskListRv.setLayoutManager(new LinearLayoutManager(this));
        taskAdapter = new TaskAdapter();
        taskAdapter.setData(tasksList);
        taskListRv.setAdapter(taskAdapter);
    }

    public void handleAddButton() {
        Button addBtn = findViewById(R.id.add_btn);
        addBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, AddTaskActivity.class);
            startActivity(intent);
        });
    }
}