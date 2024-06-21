package de.boju.todos.commons.controller;

import de.boju.todos.commons.exceptions.BaseException;
import de.boju.todos.model.RequestErrorDto;
import jakarta.validation.ConstraintViolationException;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@AllArgsConstructor
@Slf4j
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @SneakyThrows
    @ExceptionHandler(Throwable.class)
    protected ResponseEntity<RequestErrorDto> handleConflict(Throwable ex, WebRequest request) {

        HttpStatusCode status = HttpStatus.INTERNAL_SERVER_ERROR;
        RequestErrorDto error = new RequestErrorDto();

        if (ex instanceof BaseException) {
            error = ((BaseException) ex).toError();
            status = ((BaseException) ex).getStatus();
        } else if (ex instanceof ConstraintViolationException) {
            //API validation error
            status = HttpStatus.BAD_REQUEST;
            error.setCode("INVALID_REQUEST_FORMAT");
            error.setMessage(ex.getMessage());
        } else if (ex instanceof ResponseStatusException statusException) {
            status = statusException.getStatusCode();
            error.setCode(status.toString());
            Throwable rootCause = statusException.getRootCause();
            error.setMessage(rootCause == null ? statusException.getReason() : rootCause.getMessage());
        } else {
            error.setCode("UNKNOWN_ERROR");
            error.setMessage("Unexpected exception in backend.");
            log.error("Unexpected exception resulting in Status 500", ex);
        }

        error.setStatus(status.value());
        log.error(String.valueOf(ex));

        var response = ResponseEntity.status(status).body(error);
        response.getHeaders().add(HttpHeaders.CONTENT_TYPE, "application/json");

        return response;
    }
}
