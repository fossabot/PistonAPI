package org.laxio.piston.piston.exception.protocol.packet;

import org.laxio.piston.piston.exception.PistonException;

/**
 * Thrown when a Packet cannot be found by the Protocol
 */
public class PacketNotFoundException extends PistonException {

    public PacketNotFoundException(String message) {
        super(message);
    }

    public PacketNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
