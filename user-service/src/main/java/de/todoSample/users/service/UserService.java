package de.todoSample.users.service;

import de.todoSample.amqp.RabbitMQMessageProducer;
import de.todoSample.clients.notification.NotificationRequest;
import de.todoSample.users.model.User;
import de.todoSample.users.model.UserRegister;
import de.todoSample.users.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;

    public void createUser(UserRegister register) {
        User user = User.builder()
                .userId(register.userId())
                .username(register.username())
                .password(register.password())
                .email(register.email())
                .build();
        userRepository.save(user);

        NotificationRequest notificationRequest  = new NotificationRequest(
                user.getUserId(),
                user.getUsername(),
                String.format("Hi %s, welcome to todosample...",
                        user.getUsername())
        );

        rabbitMQMessageProducer.publish(
                notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key"
        );

    }
}
