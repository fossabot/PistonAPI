package org.laxio.piston.piston.protocol;

import org.laxio.piston.piston.exception.protocol.packet.PacketNotFoundException;
import org.laxio.piston.piston.exception.protocol.packet.UnsupportedPacketException;

/**
 * Protocol interface implemented by StickyProtocol
 */
public interface Protocol {

    Packet getPacket(ProtocolState state, PacketDirection direction, int id) throws UnsupportedPacketException, PacketNotFoundException;

    int getId(Packet packet) throws PacketNotFoundException;

    int getVersion();

}
