package de.todoSample.todo.model;

import java.time.LocalDate;

/***
 * Since the internal state of an immutable object remains constant in time,
 * we can share it safely among multiple threads.  Immutable objects don't change
 * their internal state in time, they are thread-safe and side-effects free.
 * Because of those properties, immutable objects are also especially useful when dealing
 * with multi-thread environments.
 * */
public record TodoRequestRegister(
        Integer userId,
        LocalDate modifiedDate,
        String taskName,
        String taskDescription,
        String author,
        boolean finished,
        TodoCategory category,
        TodoPriority priority,
        LocalDate createdDate
) {
}
