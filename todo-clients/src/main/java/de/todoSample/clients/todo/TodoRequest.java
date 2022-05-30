package de.todoSample.clients.todo;

import java.time.LocalDate;

public record TodoRequest(
        Integer userId,
        LocalDate modifiedDate,
        String taskName,
        String taskDescription,
        String author,
        boolean finished,
        LocalDate createdDate
) {}
