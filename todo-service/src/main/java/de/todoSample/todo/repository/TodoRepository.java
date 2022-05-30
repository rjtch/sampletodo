package de.todoSample.todo.repository;

import de.todoSample.todo.model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends MongoRepository<Todo, String> {
    List<Todo> findTodosByUserId(Integer userId);
    Todo findTodoBy_id(String todoId);
}
