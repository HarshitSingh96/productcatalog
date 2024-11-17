package dev.harshit.productcatalog.exceptions;

import dev.harshit.productcatalog.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerAdvices {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDto> handleNotFoundException(NotFoundException notFoundException) {
        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(
                new ExceptionDto(notFoundException.getMessage(), HttpStatus.NOT_FOUND),
                HttpStatus.NOT_FOUND
        );

        return response;
    }
}
