package com.example.practice.service;

import com.example.practice.model.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * ВАЖНО: из-за полевой инъекции (@Autowired на полях в TaskServiceImpl)
 * этот тест НЕ МОЖЕТ обойтись без поднятия полного Spring-контекста —
 * простое "new TaskServiceImpl()" оставит поля пустыми (null) и вызов
 * любого метода упадёт с NullPointerException.
 * В Practice 3 после перехода на конструкторную инъекцию это
 * ограничение снимается (см. TaskServiceImplTest в practice-3).
 */
@SpringBootTest
@ActiveProfiles("test")
class TaskServiceImplTest {

    @Autowired
    private TaskService taskService;

    @Test
    void createsTask() {
        Task task = taskService.createTask("Learn Spring");

        assertEquals("Learn Spring", task.getTitle());
        assertEquals(1, taskService.getAllTasks().size());
    }
}
