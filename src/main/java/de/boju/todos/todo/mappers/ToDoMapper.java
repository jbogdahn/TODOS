package de.boju.todos.todo.mappers;

import de.boju.todos.model.ToDoDto;
import de.boju.todos.todo.entities.ToDoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ToDoMapper {

    ToDoDto toDto(ToDoEntity entity);

    @Mapping(target = "version", ignore = true)
    ToDoEntity toEntity(ToDoDto dto);
}
