package io.pismo.test.core.exception;

import io.pismo.test.core.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

/**
 * The type Rest exception handler.
 */
@ControllerAdvice
public class RestExceptionHandler{


    /**
     * Handle bad request response entity.
     *
     * @param ex      the ex
     * @param request the request
     * @return the response entity
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Error> handleBadRequest(Exception ex, WebRequest request) {
        Error error = Error.builder()
                .withTimestamp(LocalDateTime.now())
                .withStatus(HttpStatus.NOT_FOUND.value())
                .withError(ex.getMessage())
                .build();

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handle internal error response entity.
     *
     * @param ex      the ex
     * @param request the request
     * @return the response entity
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleInternalError(Exception ex, WebRequest request) {
        Error error = Error.builder()
                .withTimestamp(LocalDateTime.now())
                .withStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .withError(ex.getMessage())
                .build();

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
