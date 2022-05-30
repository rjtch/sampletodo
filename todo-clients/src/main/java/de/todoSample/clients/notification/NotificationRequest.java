package de.todoSample.clients.notification;

public record NotificationRequest(
        Integer toUserId,
        String toUsername,
        String message
){
}
