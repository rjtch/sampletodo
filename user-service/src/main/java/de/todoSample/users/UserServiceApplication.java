package de.todoSample.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication(scanBasePackages = "de.todoSample.users")
@EnableFeignClients(
        basePackages = "de.todoSample.clients"
)
@PropertySources({
        @PropertySource("classpath:todo-clients-${spring.profiles.active}.properties")
})
public class UserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

}
