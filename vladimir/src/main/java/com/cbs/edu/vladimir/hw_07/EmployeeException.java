package com.cbs.edu.vladimir.hw_07;

/**
 * Created by Vladimir on 20.04.2017.
 */
public class EmployeeException extends Exception {
    public EmployeeException() {
    }

    public EmployeeException(Throwable cause) {
        super(cause);
    }

    public EmployeeException(String message) {
        super(message);
    }

    public EmployeeException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
