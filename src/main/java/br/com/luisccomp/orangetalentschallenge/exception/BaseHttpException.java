package br.com.luisccomp.orangetalentschallenge.exception;

import org.springframework.http.HttpStatus;

public abstract class BaseHttpException extends RuntimeException {

    private final HttpStatus status;
    private final Object details;

    public BaseHttpException(String message, HttpStatus status, Object details) {
        super(message);
        this.status = status;
        this.details = details;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public Object getDetails() {
        return details;
    }

}
