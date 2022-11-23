package com.example.todo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Task implements Serializable {
    @SerializedName("_id")
    public String id;
    @SerializedName("task")
    public String name;
    public String description;
}
