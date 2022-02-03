package com.example.hugtrainning.exceptions.WebClientError;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Conflict Exception
 *
 * @author fkabouche
 */
@ResponseStatus(code = HttpStatus.CONFLICT)
public class ConflictException extends RuntimeException {
    public ConflictException(String message, Object... args) {
        super(String.format(message, args));
    }
}
