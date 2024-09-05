package ru.antins.clientservice.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler(value = {ClientNotFoundException.class})
    public ResponseEntity<Object> handleUserNotFoundException(ClientNotFoundException clientNotFoundException) {
        ClientException userException = new ClientException(
                clientNotFoundException.getMessage(),
                clientNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(userException, userException.httpStatus());
    }
}
