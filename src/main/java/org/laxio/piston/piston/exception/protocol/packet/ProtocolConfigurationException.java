package org.laxio.piston.piston.exception.protocol.packet;

import org.laxio.piston.piston.exception.PistonException;
import org.laxio.piston.piston.protocol.Packet;
import org.laxio.piston.piston.protocol.Protocol;

/**
 * Thrown when there is an issue configuring the Protocol
 */
public class ProtocolConfigurationException extends PistonException {

    private final Protocol protocol;
    private final Class<? extends Packet> packet;

    public ProtocolConfigurationException(String message, Protocol protocol, Class<? extends Packet> packet) {
        super(message);
        this.protocol = protocol;
        this.packet = packet;
    }

    public ProtocolConfigurationException(String message, Throwable cause, Protocol protocol, Class<? extends Packet> packet) {
        super(message, cause);
        this.protocol = protocol;
        this.packet = packet;
    }

    public ProtocolConfigurationException(String message, Protocol protocol) {
        this(message, protocol, null);
    }

    public ProtocolConfigurationException(String message, Throwable cause, Protocol protocol) {
        this(message, cause, protocol, null);
    }

    /**
     * Get the Protocol which fired the exception
     * @return The Protocol which fired the exception
     */
    public Protocol getProtocol() {
        return protocol;
    }

    /**
     * The Packet class which caused the exception
     * @return The Packet class which caused the exception, if packet was not the cause, returns null
     */
    public Class<? extends Packet> getPacket() {
        return packet;
    }

}
