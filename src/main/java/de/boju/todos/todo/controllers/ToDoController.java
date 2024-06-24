package de.boju.todos.todo.controllers;

import de.boju.todos.api.TodosApi;
import de.boju.todos.commons.controller.BaseController;
import de.boju.todos.model.NewToDoDto;
import de.boju.todos.model.ToDoDto;
import de.boju.todos.todo.entities.ToDoEntity;
import de.boju.todos.todo.mappers.ToDoMapper;
import de.boju.todos.todo.services.ToDoService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class ToDoController extends BaseController implements TodosApi {

    private final ToDoMapper mapper;

    private final ToDoService toDoService;

    @Override
    public ResponseEntity<List<ToDoDto>> getToDos() {
        log.info("Retrieved GetToDos request");
        List<ToDoEntity> resultEntities = toDoService.getAllToDos();
        return ResponseEntity.ok().body(resultEntities.stream().map(mapper::toDto).toList());
    }

    @Override
    public ResponseEntity<List<ToDoDto>> getToDosByCategory(String category) {
        log.info("Retrieved GetToDosByCategory request");
        var resultEntities = toDoService.getToDosByCategory(category);
        return ResponseEntity.ok().body(resultEntities.stream().map(mapper::toDto).toList());
    }

    @Override
    public ResponseEntity<ToDoDto> createTodo(NewToDoDto toDoDto) {
        log.info("Retrieved CreateTodo request");
        var createdEntity = toDoService.createToDo(mapper.toEntity(toDoDto));
        return ResponseEntity.status(201).body(mapper.toDto(createdEntity));
    }

    @Override
    public ResponseEntity<ToDoDto> setToDoDone(String id) {
        log.info("Retrieved SetToDoDone request for ToDo with id {}", id);
        return ResponseEntity.ok().body(mapper.toDto(toDoService.setToDone(id)));
    }
}
