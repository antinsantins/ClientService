package ru.antins.clientservice.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Data
public record ClientException(String message, Throwable throwable, HttpStatus httpStatus) {
}
