package de.boju.todos.todo.exceptions;

import de.boju.todos.commons.exceptions.BaseException;
import org.springframework.http.HttpStatus;

public class ToDoNotFoundException extends BaseException {
    public ToDoNotFoundException(String message) {
        super("ERR1-TODO-NOT-FOUND", message, HttpStatus.NOT_FOUND);
    }
}
