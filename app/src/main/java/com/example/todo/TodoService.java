package com.example.todo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface TodoService {

    @GET("omTodo")
    Call<List<Task>> fetchTask();

    @POST("omTodo")
    Call<Task> createTask(@Body Task task);
}
