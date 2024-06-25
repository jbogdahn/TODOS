package de.boju.todos.todo.controller;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import de.boju.todos.commons.controller.RestExceptionHandler;
import de.boju.todos.model.ToDoDto;
import de.boju.todos.todo.controllers.ToDoController;
import de.boju.todos.todo.entities.ToDoEntity;
import de.boju.todos.todo.mappers.ToDoMapper;
import de.boju.todos.todo.mappers.ToDoMapperImpl;
import de.boju.todos.todo.services.ToDoService;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.specification.MockMvcRequestSpecification;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class TodoControllerTests {

    private final ToDoMapper mapper = new ToDoMapperImpl();

    private final ToDoService toDoService = mock(ToDoService.class);

    private final ToDoController toDoController = new ToDoController(mapper, toDoService);

    private MockMvcRequestSpecification givenController() {
        return given().standaloneSetup(toDoController, new RestExceptionHandler()).contentType(ContentType.JSON);
    }

    @Test
    void testGetToDos() {
        //GIVEN
        when(toDoService.getAllToDos()).thenReturn(testToDoList());

        //WHEN
        var result =
                givenController().when().get("/api/v1/todos").then().status(HttpStatus.OK).extract().as(List.class);

        //THEN
        verify(toDoService, times(1)).getAllToDos();
        Assertions.assertEquals(2, result.size());
        //TODO more Assertions?
    }

    @Test
    void testSetToDoToDone() {
        //GIVEN
        String testId = UUID.randomUUID().toString();
        when(toDoService.setToDone(anyString())).thenReturn(testToDoEntity(testId));

        //WHEN
        var result = givenController().when()
                .patch("/api/v1/todos/" + testId + "/done")
                .then()
                .status(HttpStatus.OK)
                .extract()
                .as(ToDoDto.class);

        //THEN
        verify(toDoService, times(1)).setToDone(testId);
        Assertions.assertEquals(true, result.getDone());
        Assertions.assertEquals(testId, result.getId().toString());
    }

    private List<ToDoEntity> testToDoList() {
        return List.of(new ToDoEntity(UUID.randomUUID().toString(), 0L, "Title1", "category1", "description1", true),
                       new ToDoEntity(UUID.randomUUID().toString(), 0L, "Title2", "category2", "description2", true));
    }

    private ToDoEntity testToDoEntity(String id) {
        var useId = (id == null) ? UUID.randomUUID().toString() : id;
        return new ToDoEntity(useId, 0L, "Title3", "category3", "description3", true);
    }
}
