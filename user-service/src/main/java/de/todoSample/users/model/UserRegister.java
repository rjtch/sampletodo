package de.todoSample.users.model;

public record UserRegister(
        Integer userId,
        String  username,
        String  password,
        String email
) {
}
