package de.todoSample.todo.model;

public enum TodoPriority {
    LOW (0),
    MEDIUM (1),
    HIGH (2);

    private final int value;

    TodoPriority(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }
}
