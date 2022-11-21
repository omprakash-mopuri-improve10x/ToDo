package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class TaskListActivity extends AppCompatActivity {

    public RecyclerView taskListRv;
    public ArrayList<Task> tasksList;
    public TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        getSupportActionBar().setTitle("Task List");
        setupData();
        setupTaskListRv();
        handleAddButton();
    }

    public void setupData() {
        tasksList = new ArrayList<>();

        Task task = new Task();
        task.name = "Get Vegetables";
        task.description = "for 1 week";
        tasksList.add(task);

        Task task1 = new Task();
        task1.name = "Reading news";
        task1.description = "Explore politics, filmy and sport news";
        tasksList.add(task1);

        Task task2 = new Task();
        task2.name = "Prepare Lunch";
        task2.description = "Biryani and Raitha. yummyyyyy";
        tasksList.add(task2);

        Task task3 = new Task();
        task3.name = "Have Breakfast";
        task3.description = "Healthy breakfast for a better morning";
        tasksList.add(task3);
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