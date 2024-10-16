package com.retrowalk.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.ResponseEntity;


@JsonPropertyOrder(value = {"statusCode", "message", "url", "exceptionTrace"})
public class ErrorResponse<T> {

    /**
     * Exception trace.
     */
    private String exceptionTrace;

    /**
     * url path of the request.
     */
    private String url;

    /**
     * Status code.
     */
    private Integer statusCode;

    /**
     * Error message.
     */
    private String message;

    public ErrorResponse(String exceptionTrace, String url, Integer statusCode, String message) {
        this.exceptionTrace = exceptionTrace;
        this.url = url;
        this.statusCode = statusCode;
        this.message = message;
    }

    public ErrorResponse() {
    }

    /**
     * Get response entity.
     *
     * @return ResponseEntity
     */
    @JsonIgnore
    public ResponseEntity<ErrorResponse<T>> getResponseEntity() {
        return ResponseEntity.ok(this);
    }

    public String getExceptionTrace() {
        return exceptionTrace;
    }

    public void setExceptionTrace(String exceptionTrace) {
        this.exceptionTrace = exceptionTrace;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}