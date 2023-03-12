package com.example.demo.core.exceptions;

public class MyException {
    private String errorType;
    private String message;

    public MyException(String logref, String message) {
        this.errorType = logref;
        this.message = message;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
