package de.todoSample.users.service;

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

    public void createUser(UserRegister register) {
        User user = User.builder()
                .userId(register.userId())
                .username(register.username())
                .password(register.password())
                .email(register.email())
                .build();
        userRepository.save(user);

    }
}
