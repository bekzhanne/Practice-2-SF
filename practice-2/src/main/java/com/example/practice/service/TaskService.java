package com.example.practice.service;

import com.example.practice.model.Task;

import java.util.List;

public interface TaskService {

    List<Task> getAllTasks();

    Task createTask(String title);
}
