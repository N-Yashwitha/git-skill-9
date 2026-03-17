package com.klu.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.klu.dto.ErrorResponse;
import com.klu.exception.InvalidInputException;
import com.klu.exception.StudentNotFoundException;

public class GlobalExceptionalHandler {
	@ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleStudentNotFound(StudentNotFoundException ex){

        ErrorResponse error=new ErrorResponse(
                LocalDateTime.now(),
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value()
                );

                return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
            }

            @ExceptionHandler(InvalidInputException.class)
            public ResponseEntity<ErrorResponse> handleInvalidInput(InvalidInputException ex){

                ErrorResponse error=new ErrorResponse(
                        LocalDateTime.now(),
                        ex.getMessage(),
                        HttpStatus.BAD_REQUEST.value()
                );

                return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
            }

}
