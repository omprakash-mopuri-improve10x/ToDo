package com.example.todo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TodoService {

    @GET("omTodo")
    Call<List<Task>> fetchTask();

    @POST("omTodo")
    Call<Task> createTask(@Body Task task);

    @DELETE("omTodo/{id}")
    Call<Void> deleteTask(@Path("id") String id);
}
