package com.example.todo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TodoApi {

    public TodoService createTodoService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://crudcrud.com/api/479dd07f8c1d482e9219f7dcb48e25f4/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        TodoService todoService = retrofit.create(TodoService.class);
        return todoService;
    }
}
