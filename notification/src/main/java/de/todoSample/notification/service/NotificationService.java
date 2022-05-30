package de.todoSample.notification.service;

import de.todoSample.clients.notification.NotificationRequest;
import de.todoSample.notification.repository.NotificationRepository;
import de.todoSample.notification.mode.Notification;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public void send(NotificationRequest notificationRequest) {
        notificationRepository.save(
                Notification.builder()
                        .toUserId(notificationRequest.toUserId())
                        .toUsername(notificationRequest.toUsername())
                        .sender("todosample")
                        .message(notificationRequest.message())
                        .sentAt(LocalDateTime.now())
                        .build()
        );
    }
}
