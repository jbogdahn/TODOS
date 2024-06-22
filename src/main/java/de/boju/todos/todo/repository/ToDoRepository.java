package de.boju.todos.todo.repository;

import de.boju.todos.todo.entities.ToDoEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository<ToDoEntity, String> {

    List<ToDoEntity> getByCategory(String category);
}
