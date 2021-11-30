package com.bulletin_board.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
