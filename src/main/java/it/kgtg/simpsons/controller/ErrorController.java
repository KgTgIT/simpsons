package it.kgtg.simpsons.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Represents custom exception handler. It catches all server errors and redirects user to the custom error template.
 */
@Slf4j
@ControllerAdvice
public class ErrorController extends ResponseEntityExceptionHandler {

    private static final String UNKNOWN_ERROR = "Server error:</br>";

    @ExceptionHandler(value = {Throwable.class})
    private ResponseEntity<Object> handleServerException(RuntimeException ex, WebRequest request) {
        log.error("Exception during execution of application: " + ex.getMessage(), ex);
        return handleExceptionInternal(ex, UNKNOWN_ERROR + ex.getMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

}