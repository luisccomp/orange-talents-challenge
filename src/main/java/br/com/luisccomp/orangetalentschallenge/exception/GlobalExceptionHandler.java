package br.com.luisccomp.orangetalentschallenge.exception;

import br.com.luisccomp.orangetalentschallenge.domain.model.response.ErrorResponse;
import java.util.stream.Collectors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BaseHttpException.class)
    public ResponseEntity<Object> handleBaseHttpException(BaseHttpException ex, WebRequest request) {
        var response = new ErrorResponse(ex.getStatus().value(), ex.getMessage(), ex.getDetails());

        return handleExceptionInternal(ex, response, new HttpHeaders(), ex.getStatus(), request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        var details = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(error -> new ErrorResponse.FieldErrorDetails(((FieldError) error).getField(), error.getDefaultMessage()))
                .collect(Collectors.toList());

        var response = new ErrorResponse(status.value(), "Validation failed for one or more fields", details);

        return handleExceptionInternal(ex, response, headers, status, request);
    }

}
