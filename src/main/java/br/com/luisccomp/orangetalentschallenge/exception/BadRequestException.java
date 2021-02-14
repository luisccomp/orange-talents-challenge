package br.com.luisccomp.orangetalentschallenge.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends BaseHttpException {

    public BadRequestException(String message, Object details) {
        super(message, HttpStatus.BAD_REQUEST, details);
    }

    public BadRequestException(String message) {
        super(message, HttpStatus.BAD_REQUEST, null);
    }

}
