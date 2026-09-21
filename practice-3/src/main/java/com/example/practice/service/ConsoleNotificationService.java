package com.example.practice.service;

/**
 * Обычный класс (НЕ помечен @Service) — создаётся вручную через @Bean
 * в NotificationConfig, только если условие сработало.
 */
public class ConsoleNotificationService implements NotificationService {

    @Override
    public void notify(String message) {
        System.out.println("[CONSOLE NOTIFICATION] " + message);
    }
}
