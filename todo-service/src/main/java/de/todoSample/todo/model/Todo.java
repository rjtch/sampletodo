package de.todoSample.todo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

/***
 * When the complexity of creating object increases, the @Builder pattern can separate out
 * the instantiation process by using another object (a builder) to construct the object.
 *
 * When to Use Builder Pattern
 * When the process involved in creating an object is extremely complex, with lots of mandatory and optional parameters
 * When an increase in the number of constructor parameters leads to a large list of constructors
 * When client expects different representations for the object that's constructed
 * **/

@Data
@Document(collection = "todos")
@AllArgsConstructor
@Builder
public class Todo {
    @Id
    public String _id;
    @NonNull
    private Integer userId;
    @CreatedDate
    private LocalDate createdDate;
    @LastModifiedDate
    private LocalDate modifiedDate;
    private String taskName;
    private String taskDescription;
    private String author;
    private boolean finished;
    private TodoCategory category;
    private TodoPriority priority;
}
