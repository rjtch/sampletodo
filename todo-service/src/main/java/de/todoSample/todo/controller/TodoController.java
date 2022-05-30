package de.todoSample.todo.controller;

import de.todoSample.todo.model.Todo;
import de.todoSample.todo.model.TodoRequestRegister;
import de.todoSample.todo.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/todos")
public class TodoController {

    @Autowired
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping()
    public ResponseEntity<Void> todoRegistration(@RequestBody TodoRequestRegister todoRequestRegister) {
        log.info("New todo created {} ", todoRequestRegister);
        todoService.registerTodo(todoRequestRegister);
        return new ResponseEntity("New todo created ",  HttpStatus.OK);
    }

    @GetMapping(path = "{todoId}")
    public ResponseEntity<Todo> getTodo(@PathVariable("todoId") String todoId) {
        log.info("get todo with {} ", todoId);
        Todo todo = todoService.getTodo(todoId);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @GetMapping(path = "{userId}/users")
    public ResponseEntity<List<Todo>> getTodosByUsers(@PathVariable("userId")  Integer userId) {
        log.info("requested todos by user {} ", userId);
        List<Todo> userTodos = todoService.listTodosByUser(userId);
        return new ResponseEntity<>(userTodos, HttpStatus.OK);
    }

    @PutMapping(path = "{todoId}")
    public ResponseEntity<Boolean> UpdateTodo(@PathVariable("todoId")  String todoId, boolean finished) {
        log.info("requested to update todo with id {} ", todoId);
        todoService.updateTodo(todoId, finished);
        return new ResponseEntity("Todo updated ",  HttpStatus.OK);
    }
}
