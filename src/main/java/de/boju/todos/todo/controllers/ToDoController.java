package de.boju.todos.todo.controllers;

import de.boju.todos.api.TodosApi;
import de.boju.todos.commons.controller.BaseController;
import de.boju.todos.model.ToDoDto;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToDoController extends BaseController implements TodosApi {

    @Override
    public ResponseEntity<List<ToDoDto>> getToDos() {
        return TodosApi.super.getToDos();
    }
}
