package org.laxio.piston.piston.exception.protocol;

import org.laxio.piston.piston.exception.PistonRuntimeException;

public class ProtocolEncryptionException extends PistonRuntimeException {

    public ProtocolEncryptionException(String message) {
        super(message);
    }

    public ProtocolEncryptionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProtocolEncryptionException(Throwable cause) {
        super(cause);
    }

}
