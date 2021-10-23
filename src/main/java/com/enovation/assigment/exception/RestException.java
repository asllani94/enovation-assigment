package com.enovation.assigment.exception;

import org.springframework.http.HttpStatus;


public class RestException extends Exception {

    private  String message;
    private HttpStatus statusCode;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public  RestException(String message, HttpStatus statusCode){
        super(message);
        this.message=message;
        this.statusCode=statusCode;
    }

    public  RestException(String message){
        super(message);
        this.message = message;
        this.statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
    }
}