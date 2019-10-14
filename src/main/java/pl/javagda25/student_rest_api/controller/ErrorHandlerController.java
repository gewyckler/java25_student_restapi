package pl.javagda25.student_rest_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.javagda25.student_rest_api.model.ErrorMessage;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<ErrorMessage> handleEntityNotFound(EntityNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST) //400
                .body(new ErrorMessage("Unable to find entity " + exception.getMessage()));
    }
}
