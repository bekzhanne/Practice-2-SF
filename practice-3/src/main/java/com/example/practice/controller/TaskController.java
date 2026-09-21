package com.example.practice.controller;

import com.example.practice.config.AppProperties;
import com.example.practice.model.Task;
import com.example.practice.service.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TaskController {

    private final TaskService taskService;
    private final AppProperties appProperties;

    public TaskController(TaskService taskService, AppProperties appProperties) {
        this.taskService = taskService;
        this.appProperties = appProperties;
    }

    @GetMapping("/api/tasks")
    public List<Task> getTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping("/api/tasks")
    public Task createTask(@RequestParam String title) {
        return taskService.createTask(title);
    }

    @GetMapping("/api/info")
    public Map<String, Object> info() {
        return Map.of(
                "name", appProperties.getName(),
                "description", appProperties.getDescription(),
                "maxTasks", appProperties.getMaxTasks(),
                "notificationType", appProperties.getNotification().getType()
        );
    }
}
