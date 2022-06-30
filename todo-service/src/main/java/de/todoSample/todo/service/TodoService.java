package de.todoSample.todo.service;

import de.todoSample.amqp.RabbitMQMessageProducer;
import de.todoSample.clients.notification.NotificationRequest;
import de.todoSample.clients.todo.TodoRequest;
import de.todoSample.todo.model.Todo;
import de.todoSample.todo.model.TodoRequestRegister;
import de.todoSample.todo.repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;

    public void registerTodo(TodoRequestRegister register) {
        Todo todo = Todo.builder()
                .userId(register.userId())
                .author(register.author())
                .createdDate(register.createdDate())
                .modifiedDate(register.modifiedDate())
                .taskName(register.taskName())
                .taskDescription(register.taskDescription())
                .finished(register.finished())
                .category(register.category())
                .priority(register.priority())
                .build();

        NotificationRequest todoResponse = new NotificationRequest(
                todo.getUserId(),
                todo.getAuthor(),
                String.format("Hi %s, welcome to sampletodo...", todo.getTaskDescription()));

        rabbitMQMessageProducer.publish(todoResponse,
                "internal.exchange", "internal.notification.routing-key");

        //Todo find a way to flush the data first like it is done in jpa
        todoRepository.save(todo);

    }

    public List<Todo> listTodosByUser(Integer userId) {
        if (userId <= 0) {
            return new ArrayList<>();
        }
        return todoRepository.findTodosByUserId(userId);
    }

    public Todo getTodo(String todoId) {
        if (todoId == null) {
            return null;
        }
        return todoRepository.findTodoBy_id(todoId);
    }

    public boolean updateTodo(String todoId, boolean finished) {
        if (todoId == null) {
            return false;
        }

        Todo todo = todoRepository.findTodoBy_id(todoId);
        todo.setFinished(finished);
        todoRepository.save(todo);
        return true;
    }
}
