package de.boju.todos.todo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ToDoEntity {
    @Id
    private String id;

    @Version
    private Long version;

    private String title;

    private String category;

    private String description;

    private boolean done;
}
