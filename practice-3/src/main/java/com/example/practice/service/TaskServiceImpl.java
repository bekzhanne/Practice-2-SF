package com.example.practice.service;

import com.example.practice.config.AppProperties;
import com.example.practice.model.Task;
import com.example.practice.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ОТРЕФАКТОРЕНО (Practice 3): вместо @Autowired на полях (см. Practice 2)
 * используется конструкторная инъекция. Поля теперь final, объект нельзя
 * получить в "недособранном" состоянии, а сам класс легко создать через
 * "new" в обычном юнит-тесте без Spring-контейнера.
 */
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final NotificationService notificationService;
    private final AppProperties appProperties;

    public TaskServiceImpl(TaskRepository taskRepository,
                            NotificationService notificationService,
                            AppProperties appProperties) {
        this.taskRepository = taskRepository;
        this.notificationService = notificationService;
        this.appProperties = appProperties;
    }

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

        Task task = taskRepository.save(title);
        notificationService.notify("Создана новая задача: " + task.getTitle());
        return task;
    }
}
