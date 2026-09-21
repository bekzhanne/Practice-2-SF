package com.example.practice.repository;

import com.example.practice.model.Task;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryTaskRepository implements TaskRepository {

    private final Map<Long, Task> storage = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong();

    @Override
    public List<Task> findAll() {
        return List.copyOf(storage.values());
    }

    @Override
    public Task save(String title) {
        long id = idGenerator.incrementAndGet();
        Task task = new Task(id, title, false);
        storage.put(id, task);
        return task;
    }
}
