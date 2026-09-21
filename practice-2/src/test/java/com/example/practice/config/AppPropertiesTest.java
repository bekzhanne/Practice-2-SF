package com.example.practice.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Поднимает полный Spring-контекст с профилем "test" и проверяет,
 * что application-test.yml переопределил значения из application.yml.
 */
@SpringBootTest
@ActiveProfiles("test")
class AppPropertiesTest {

    @Autowired
    private AppProperties appProperties;

    @Test
    void bindsPropertiesFromTestProfile() {
        assertEquals("Task Manager (TEST)", appProperties.getName());
        assertEquals(5, appProperties.getMaxTasks());
    }
}
