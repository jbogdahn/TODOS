package de.boju.todos.todo.mapper;

import de.boju.todos.model.NewToDoDto;
import de.boju.todos.model.ToDoDto;
import de.boju.todos.todo.entities.ToDoEntity;
import de.boju.todos.todo.mappers.ToDoMapper;
import de.boju.todos.todo.mappers.ToDoMapperImpl;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ToDoMapperTests {

    private final ToDoMapper underTest = new ToDoMapperImpl();

    @Test
    void testMappingNewToDoDtoToEntity() {
        //GIVEN
        var testDto = new NewToDoDto();
        testDto.category("TestCategory");
        testDto.title("TestTitle");
        testDto.description("TestDescription");

        //WHEN
        ToDoEntity result = underTest.toEntity(testDto);

        //THEN
        Assertions.assertEquals(testDto.getCategory(), result.getCategory());
        Assertions.assertEquals(testDto.getTitle(), result.getTitle());
        Assertions.assertEquals(testDto.getDescription(), result.getDescription());
        Assertions.assertFalse(result.isDone());
    }

    @Test
    void testMappingToDto() {
        //GIVEN
        var testEntity = new ToDoEntity();
        testEntity.setDone(true);
        testEntity.setCategory("TestCategory");
        testEntity.setTitle("TestTitle");
        testEntity.setDescription("TestDescription");
        testEntity.setId(UUID.randomUUID().toString());

        //WHEN
        ToDoDto result = underTest.toDto(testEntity);

        //THEN
        Assertions.assertEquals(testEntity.getCategory(), result.getCategory());
        Assertions.assertEquals(testEntity.getTitle(), result.getTitle());
        Assertions.assertEquals(testEntity.getDescription(), result.getDescription());
        Assertions.assertEquals(testEntity.getId(), result.getId().toString());
        Assertions.assertEquals(testEntity.isDone(), result.getDone());
    }
}
