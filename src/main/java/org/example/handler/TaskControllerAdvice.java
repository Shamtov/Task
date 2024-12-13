package org.example.handler;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.example.exceptions.ErrorResponse;
import org.example.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

import static org.example.exceptions.StringUtil.ACCESS_DENIED;
import static org.example.exceptions.StringUtil.AUTH_ERROR;
import static org.example.exceptions.StringUtil.BAD_REQUEST;
import static org.example.exceptions.StringUtil.ERROR_FOR_LOG;
import static org.example.exceptions.StringUtil.INVALID_AUTH_DATA;
import static org.example.exceptions.StringUtil.NOT_ENOUGH_RIGHTS;
import static org.example.exceptions.StringUtil.NOT_FOUND;
import static org.example.exceptions.StringUtil.TASK_NOT_FOUND;


@RestControllerAdvice
@Slf4j
public class TaskControllerAdvice {

    @ExceptionHandler(ValidationException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleValidationException(ValidationException exception) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorDetail(exception.getCause().getMessage())
                .errorTitle(BAD_REQUEST)
                .build();
        log.error(ERROR_FOR_LOG + exception.getClass().getSimpleName() + exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleAuthenticationException(AuthenticationException exception) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorDetail(INVALID_AUTH_DATA)
                .errorTitle(AUTH_ERROR)
                .build();
        log.error(ERROR_FOR_LOG + exception.getClass().getSimpleName() + exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleAuthenticationException(AccessDeniedException exception) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorDetail(NOT_ENOUGH_RIGHTS)
                .errorTitle(ACCESS_DENIED)
                .build();
        log.error(ERROR_FOR_LOG + exception.getClass().getSimpleName() + exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleValidationExceptions(ConstraintViolationException exception) {
        List<String> errors = new ArrayList<>();
        exception.getConstraintViolations().forEach(error -> {
            String errorMessage = error.getMessage();
            errors.add(errorMessage);
        });
        log.error(ERROR_FOR_LOG + exception.getClass().getSimpleName() + exception.getMessage());
        var errorBuilder = ErrorResponse.builder();
        ErrorResponse errorResponse = (errorBuilder.errorDetails(errors))
                .errorTitle(BAD_REQUEST)
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleNotFoundExceptions(NotFoundException exception) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorDetail(TASK_NOT_FOUND)
                .errorTitle(NOT_FOUND)
                .build();
        log.error(ERROR_FOR_LOG + exception.getClass().getSimpleName() + exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
