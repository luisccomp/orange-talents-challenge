package br.com.luisccomp.orangetalentschallenge.domain.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"status", "message", "details"})
public class ErrorResponse {

    @JsonProperty("status")
    private Integer status;

    @JsonProperty("message")
    private String message;

    @JsonProperty("details")
    private Object details;

    public ErrorResponse() {

    }

    @JsonPropertyOrder({"field", "error"})
    public static class FieldErrorDetails {
        @JsonProperty("field")
        private String field;

        @JsonProperty("error")
        private String error;

        public FieldErrorDetails() {

        }

        public FieldErrorDetails(String field, String error) {
            this.field = field;
            this.error = error;
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }

    public ErrorResponse(Integer status, String message, Object details) {
        this.status = status;
        this.message = message;
        this.details = details;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getDetails() {
        return details;
    }

    public void setDetails(Object details) {
        this.details = details;
    }

}
