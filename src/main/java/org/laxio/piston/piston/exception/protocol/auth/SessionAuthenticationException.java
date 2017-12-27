package org.laxio.piston.piston.exception.protocol.auth;

import org.laxio.piston.piston.exception.PistonException;

public class SessionAuthenticationException extends PistonException {

    public SessionAuthenticationException(String message) {
        super(message);
    }

    public SessionAuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }

}
