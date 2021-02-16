package br.com.luisccomp.orangetalentschallenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends BaseHttpException {

    public NotFoundException(String message, Object details) {
        super(message, HttpStatus.NOT_FOUND, details);
    }

    public NotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND, null);
    }

}
