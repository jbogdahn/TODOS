package de.boju.todos.todo.services;

import de.boju.todos.todo.entities.ToDoEntity;
import java.util.List;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ToDoService {

    public List<ToDoEntity> getAllToDos() {
        return List.of(new ToDoEntity(UUID.randomUUID().toString(), 1L, "Test", "category", "Test decription", false),
                       new ToDoEntity(UUID.randomUUID().toString(),
                                      1L,
                                      "Test2",
                                      "category2",
                                      "Test decription2",
                                      false));
    }

    public List<ToDoEntity> getToDosByCategory(String category) {
        return List.of(new ToDoEntity(UUID.randomUUID().toString(),
                                      1L,
                                      "Test3",
                                      "category3",
                                      "Test decription",
                                      false));
    }

    public ToDoEntity createToDo(ToDoEntity entity) {
        return new ToDoEntity(UUID.randomUUID().toString(),
                              0L,
                              entity.getTitle(),
                              entity.getCategory(),
                              entity.getDescription(),
                              false);
    }

    public ToDoEntity setToDone(String id) {

        return new ToDoEntity(id, 0L, "titleDone", "categoryDone", "descriptionDone", true);
    }
}
