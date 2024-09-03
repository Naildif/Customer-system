package com.customer_manager.customer_system;

import com.customer_manager.customer_system.controller.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler (CustomerNotFoundException.class)
    public ResponseEntity<String>
    handleCustomerNotFoundException(CustomerNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> handleGlobalException (Exception ex){
        return new ResponseEntity<>(" ૮꒰◞ ˕ ◟꒱ა \nAn unexpected error has occurred: " + ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
