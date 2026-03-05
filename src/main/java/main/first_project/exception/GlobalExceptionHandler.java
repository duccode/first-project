package main.first_project.exception;

import main.first_project.common.ApiResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ApiResponse<?> handleNotFound(NotFoundException ex) {
        return new ApiResponse<>(false, null, ex.getMessage());
    }

}
