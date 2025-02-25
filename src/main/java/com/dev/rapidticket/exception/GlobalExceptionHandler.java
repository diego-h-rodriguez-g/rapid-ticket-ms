package com.dev.rapidticket.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

import static com.dev.rapidticket.commons.utilities.Constants.RESPONSE_MESSAGE_GLOBAL;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ErrorDetails.builder()
                .timestamp(new Date())
                .generalMessage(RESPONSE_MESSAGE_GLOBAL)
                .details(ex.getMessage())
                .message(request.getDescription(false))
                .build(), HttpStatus.BAD_REQUEST);
    }
}
