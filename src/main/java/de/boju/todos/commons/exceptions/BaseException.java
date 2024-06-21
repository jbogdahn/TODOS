package de.boju.todos.commons.exceptions;

import de.boju.todos.model.RequestErrorDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class BaseException extends RuntimeException {

    private final String errorCode;
    private final HttpStatus status;

    protected BaseException(String errorCode, String message, HttpStatus status) {
        super(message);
        this.errorCode = errorCode;
        this.status = status;
    }

    public RequestErrorDto toError() {
        RequestErrorDto error = new RequestErrorDto();
        error.setMessage(getMessage());
        error.setCode(getErrorCode());
        error.setStatus(getStatus().value());
        return error;
    }

}
