package de.todoSample.todo;

import de.todoSample.todo.model.Todo;
import de.todoSample.todo.model.TodoCategory;
import de.todoSample.todo.model.TodoPriority;
import de.todoSample.todo.repository.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@EnableMongoRepositories(basePackages = {"de.todoSample.todo.repository"})
@SpringBootApplication(
        scanBasePackages = {
                "de.todoSample.todo",
                "de.todoSample.amqp",
        }
)
@EnableFeignClients(
        basePackages = "de.todoSample.clients"
)
@PropertySources({
        @PropertySource("classpath:todo-clients-${spring.profiles.active}.properties")
})
public class TodoServiceApplication {

//    @Bean
//    CommandLineRunner init(TodoRepository todoRepository) {
//        return args->{
//            initTodos(todoRepository);
//        };
//    }
//
//    public void initTodos(TodoRepository todoRepository) {
//        List<Todo> toDoList = new ArrayList<>();
//        for (int id = 0; id < 50; id++) {
//            toDoList.add(new Todo(1243588, LocalDate.now(), LocalDate.now(), "Bob task " + id, "bob task description " + id,
//                                "bob " + id, false, TodoCategory.Personal, TodoPriority.valueOf("HIGH")));
//        }

//        todoRepository.deleteAll();
//        todoRepository.saveAll(toDoList);
//    }
    public static void main(String[] args) {
        SpringApplication.run(TodoServiceApplication.class, args);
    }
}
