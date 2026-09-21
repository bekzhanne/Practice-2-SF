package com.example.practice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Типизированный класс настроек.
 * Spring сам заполняет его поля значениями из application.yml / application-*.yml,
 * ключи которых начинаются с префикса "app.".
 */
@ConfigurationProperties(prefix = "app")
public class AppProperties {

    private String name;
    private String description;
    private int maxTasks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMaxTasks() {
        return maxTasks;
    }

    public void setMaxTasks(int maxTasks) {
        this.maxTasks = maxTasks;
    }
}
