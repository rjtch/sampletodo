package de.todoSample.clients.todo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@FeignClient(
        name="todo-service",
        url = "${todo-clients.todo-service.url}"
)
public interface TodoClient {

    @PostMapping(path = "api/v1/todos")
    ResponseEntity<Void> editTodo(TodoRequest todoResponse);

    @GetMapping(path = "api/v1/todos/{todoId}")
    ResponseEntity<TodoRequest> getTodo(@PathVariable("todoId") String todoId);

    @GetMapping(path = "api/v1/todos/{userId}/users")
    ResponseEntity<List<TodoRequest>> listTodos(@PathVariable("userId")  Integer userId);

    @PutMapping(path = "api/v1/todos/{todoId}")
    ResponseEntity<Boolean> UpdateTodo(@PathVariable("todoId")  Integer todoId, boolean finished);
}
