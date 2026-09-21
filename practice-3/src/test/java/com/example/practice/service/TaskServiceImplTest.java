package com.example.practice.service;

import com.example.practice.config.AppProperties;
import com.example.practice.model.Task;
import com.example.practice.repository.InMemoryTaskRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Обычный юнит-тест БЕЗ поднятия Spring-контекста.
 * Благодаря конструкторной инъекции можно создать TaskServiceImpl через
 * "new" и подставить любые реализации зависимостей вручную — включая
 * "фейковый" NotificationService в виде лямбды. Сравните с тестом
 * TaskServiceImplTest в practice-2, где так сделать было нельзя.
 */
class TaskServiceImplTest {

    @Test
    void createsTaskAndNotifies() {
        AppProperties properties = new AppProperties();
        properties.setMaxTasks(2);

        StringBuilder lastMessage = new StringBuilder();
        NotificationService fakeNotifier = message -> lastMessage.append(message);

        TaskServiceImpl service = new TaskServiceImpl(
                new InMemoryTaskRepository(), fakeNotifier, properties);

        Task task = service.createTask("Learn Spring");

        assertEquals("Learn Spring", task.getTitle());
        assertEquals(1, service.getAllTasks().size());
        assertEquals("Создана новая задача: Learn Spring", lastMessage.toString());
    }

    @Test
    void throwsWhenLimitReached() {
        AppProperties properties = new AppProperties();
        properties.setMaxTasks(1);

        TaskServiceImpl service = new TaskServiceImpl(
                new InMemoryTaskRepository(), message -> { }, properties);

        service.createTask("First task");

        assertThrows(IllegalStateException.class, () -> service.createTask("Second task"));
    }
}
