package br.com.luisccomp.orangetalentschallenge.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends BaseHttpException {

    public NotFoundException(String message, Object details) {
        super(message, HttpStatus.NOT_FOUND, details);
    }

    public NotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND, null);
    }

}
