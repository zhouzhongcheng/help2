package com.github.Yasenia.flea_school.server.exception;

public class DBException extends RuntimeException {

    private static final long serialVersionUID = 4076226180514805662L;

    public DBException() {
        super();
    }

    public DBException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public DBException(String message, Throwable cause) {
        super(message, cause);
    }

    public DBException(String message) {
        super(message);
    }

    public DBException(Throwable cause) {
        super(cause);
    }

}
