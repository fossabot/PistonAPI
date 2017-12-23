package org.laxio.piston.piston.exception;

public class PistonRuntimeException extends RuntimeException {

    public PistonRuntimeException() {
        // blank
    }

    public PistonRuntimeException(String message) {
        super(message);
    }

    public PistonRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public PistonRuntimeException(Throwable cause) {
        super(cause);
    }

    public PistonRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
