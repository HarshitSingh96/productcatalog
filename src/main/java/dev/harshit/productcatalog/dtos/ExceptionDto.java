package dev.harshit.productcatalog.dtos;

import org.springframework.http.HttpStatusCode;


public class ExceptionDto {
    String message;
    HttpStatusCode status;

    public ExceptionDto(String message, HttpStatusCode statusCode) {
        this.message = message;
        this.status = statusCode;
    }
}
