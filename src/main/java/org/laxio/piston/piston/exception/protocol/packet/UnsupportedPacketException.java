package org.laxio.piston.piston.exception.protocol.packet;

import org.laxio.piston.piston.exception.PistonException;

/**
 * Thrown during the configuration process if a Packet does not meet the requirements
 */
public class UnsupportedPacketException extends PistonException {

    public UnsupportedPacketException(String message) {
        super(message);
    }

    public UnsupportedPacketException(String message, Throwable cause) {
        super(message, cause);
    }

}
