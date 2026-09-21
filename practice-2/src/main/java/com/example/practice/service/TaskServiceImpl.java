package com.example.practice.service;

import com.example.practice.config.AppProperties;
import com.example.practice.model.Task;
import com.example.practice.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ВАЖНО (для понимания Practice 3): здесь намеренно используется
 * ПОЛЕВАЯ инъекция через @Autowired на полях. Это самый простой,
 * но не самый лучший способ внедрения зависимостей — у него есть
 * недостатки (поля нельзя сделать final, класс нельзя создать через
 * "new" без Spring-контейнера, скрытые зависимости).
 * Именно этот класс в Practice 3 переписывается на конструкторную
 * инъекцию.
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AppProperties appProperties;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task createTask(String title) {
        if (taskRepository.findAll().size() >= appProperties.getMaxTasks()) {
            throw new IllegalStateException(
                    "Достигнут лимит задач: " + appProperties.getMaxTasks());
        }
        return taskRepository.save(title);
    }
}
