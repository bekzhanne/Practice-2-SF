package com.example.practice.repository;

import com.example.practice.model.Task;

import java.util.List;

public interface TaskRepository {

    List<Task> findAll();

    Task save(String title);
}
