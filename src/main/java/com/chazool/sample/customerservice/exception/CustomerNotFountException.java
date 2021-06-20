package com.chazool.sample.customerservice.exception;

public class CustomerNotFountException extends RuntimeException {

    public CustomerNotFountException(String message) {
        super(message);
    }

    public CustomerNotFountException(String message, Throwable cause) {
        super(message, cause);
    }


}
