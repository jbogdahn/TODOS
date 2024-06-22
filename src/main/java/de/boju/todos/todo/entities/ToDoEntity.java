package de.boju.todos.todo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(schema = "public", name = "todo")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ToDoEntity {
    @Id
    @Column(name = "id")
    private String id;

    @Version
    @Column(name = "version")
    private Long version;

    @Column(name = "title")
    private String title;

    @Column(name = "category")
    private String category;

    @Column(name = "description")
    private String description;

    @Column(name = "done")
    private boolean done;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ToDoEntity that = (ToDoEntity) o;
        return done == that.done && Objects.equals(id, that.id) && Objects.equals(version, that.version) &&
                Objects.equals(title, that.title) && Objects.equals(category, that.category) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(version);
        result = 31 * result + Objects.hashCode(title);
        result = 31 * result + Objects.hashCode(category);
        result = 31 * result + Objects.hashCode(description);
        result = 31 * result + Boolean.hashCode(done);
        return result;
    }

    @Override
    public String toString() {
        return "ToDoEntity{" + "id='" + id + '\'' + ", version=" + version + ", title='" + title + '\'' +
                ", category='" + category + '\'' + ", description='" + description + '\'' + ", done=" + done + '}';
    }
}
