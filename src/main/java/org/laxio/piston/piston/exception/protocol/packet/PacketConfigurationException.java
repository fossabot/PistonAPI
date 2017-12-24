package org.laxio.piston.piston.exception.protocol.packet;

import org.laxio.piston.piston.exception.PistonRuntimeException;
import org.laxio.piston.piston.protocol.Packet;

/**
 * Thrown when a Packet has an issue with it's configuration
 */
public class PacketConfigurationException extends PistonRuntimeException {

    private Packet packet;

    public PacketConfigurationException(String message, Packet packet) {
        super(message);
        this.packet = packet;
    }

    /**
     * Gets that Packet that threw the exception
     * @return The packet
     */
    public Packet getPacket() {
        return packet;
    }

}
