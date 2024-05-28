package edu.phystech.hw5.exception;

/**
 * @author kzlv4natoly
 */
public class ValidationException extends RuntimeException {
    private String exceptionMessage;
    public ValidationException(String s) {
        exceptionMessage = s;
    }

    public String getMessage() {
        return exceptionMessage;
    }
}
