package com.example.practice.controller;

import com.example.practice.config.AppProperties;
import com.example.practice.model.Task;
import com.example.practice.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private AppProperties appProperties;

    @GetMapping("/api/tasks")
    public List<Task> getTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping("/api/tasks")
    public Task createTask(@RequestParam String title) {
        return taskService.createTask(title);
    }

    // Показывает, что настройки из application.yml дошли до типизированного AppProperties.
    @GetMapping("/api/info")
    public Map<String, Object> info() {
        return Map.of(
                "name", appProperties.getName(),
                "description", appProperties.getDescription(),
                "maxTasks", appProperties.getMaxTasks()
        );
    }
}
