package com.example.practice.service;

/**
 * "Заглушка" под реальную email-рассылку — имитирует отправку письма,
 * чтобы показать работу условного бина.
 */
public class EmailNotificationService implements NotificationService {

    @Override
    public void notify(String message) {
        System.out.println("[EMAIL NOTIFICATION] Отправляю письмо: " + message);
    }
}
