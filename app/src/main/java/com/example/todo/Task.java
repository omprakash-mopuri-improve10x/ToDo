package com.example.todo;

import com.google.gson.annotations.SerializedName;

public class Task {
    @SerializedName("_id")
    public String id;
    @SerializedName("task")
    public String name;
    public String description;
}
