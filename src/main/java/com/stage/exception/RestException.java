package com.stage.exception;

import com.sun.istack.NotNull;
import lombok.Getter;
import org.springframework.http.HttpStatus;

public class RestException extends RuntimeException{

    private final @Getter
    HttpStatus httpStatus;


    public RestException(@NotNull String message, @NotNull HttpStatus status) {
        super(message);
        this.httpStatus = status;
    }
}
