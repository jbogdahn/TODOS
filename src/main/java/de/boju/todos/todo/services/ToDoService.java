package de.boju.todos.todo.services;

import de.boju.todos.todo.entities.ToDoEntity;
import de.boju.todos.todo.exceptions.ToDoNotFoundException;
import de.boju.todos.todo.repository.ToDoRepository;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class ToDoService {

    private final ToDoRepository repository;

    public List<ToDoEntity> getAllToDos() {
        log.info("Service getAllToDos");
        return repository.findAll();
    }

    public List<ToDoEntity> getToDosByCategory(String category) {
        log.info("Service getToDosByCategory for category {}", category);
        return repository.getByCategory(category);
    }

    public ToDoEntity createToDo(ToDoEntity entity) {
        log.info("Service createToDo for {}", entity.toString());
        entity.setId(UUID.randomUUID().toString());
        entity.setVersion(0L);
        return repository.save(entity);
    }

    public ToDoEntity setToDone(String id) {
        log.info("Service setToDone for {}", id);
        var entityOptional = repository.findById(id);
        if (entityOptional.isPresent()) {
            var entity = entityOptional.get();
            entity.setDone(true);
            return repository.save(entity);
        } else {
            throw new ToDoNotFoundException("The ToDo with id " + id + " does not exist");
        }
    }
}
