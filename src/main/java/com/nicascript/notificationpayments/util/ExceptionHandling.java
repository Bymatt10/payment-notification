package com.nicascript.notificationpayments.util;

import com.nicascript.notificationpayments.dto.response.GenericResponseDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandling {
    @ExceptionHandler({ EntityNotFoundException.class})
    public ResponseEntity<Object> handlePaymentNotFoundException(Exception exception) {
        var response = new GenericResponseDto<>();
        response.setCode(HttpStatus.NOT_FOUND.value());
        response.setMessage(exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

}
