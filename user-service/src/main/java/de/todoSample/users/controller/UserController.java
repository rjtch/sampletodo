package de.todoSample.users.controller;

import de.todoSample.clients.todo.TodoClient;
import de.todoSample.clients.todo.TodoRequest;
import de.todoSample.users.model.UserRegister;
import de.todoSample.users.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private final UserService userService;

    @Autowired
    private final TodoClient todoClient;

    @PostMapping
    public void userRegistration(@RequestBody UserRegister userRegister) {
        userService.createUser(userRegister);
        log.info("New User created: {} ", userRegister.username());
    }

    @GetMapping(path = "{userId}")
    public ResponseEntity<List<TodoRequest>> getTodosUsers(@PathVariable Integer userId) {
        return todoClient.listTodos(userId);
    }
}
