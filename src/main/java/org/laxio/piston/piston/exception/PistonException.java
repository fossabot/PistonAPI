package org.laxio.piston.piston.exception;

/**
 * Superclass for all Piston exceptions
 */
public class PistonException extends Exception {

    public PistonException() {
        // empty
    }

    public PistonException(String message) {
        super(message);
    }

    public PistonException(String message, Throwable cause) {
        super(message, cause);
    }

    public PistonException(Throwable cause) {
        super(cause);
    }

    public PistonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
