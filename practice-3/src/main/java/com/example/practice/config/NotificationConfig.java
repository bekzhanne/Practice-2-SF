package com.example.practice.config;

import com.example.practice.service.ConsoleNotificationService;
import com.example.practice.service.EmailNotificationService;
import com.example.practice.service.NotificationService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Регистрирует ОДИН из двух бинов NotificationService в зависимости
 * от значения свойства app.notification.type. Это и есть "условный бин"
 * из задания Practice 3.
 */
@Configuration
public class NotificationConfig {

    @Bean
    @ConditionalOnProperty(name = "app.notification.type", havingValue = "email")
    public NotificationService emailNotificationService() {
        return new EmailNotificationService();
    }

    @Bean
    @ConditionalOnProperty(name = "app.notification.type", havingValue = "console", matchIfMissing = true)
    public NotificationService consoleNotificationService() {
        return new ConsoleNotificationService();
    }
}
