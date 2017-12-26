package org.laxio.piston.piston.protocol;

public interface Connection {

    ProtocolState getState();

    void setState(ProtocolState state);

    void sendPacket(Packet packet);

}
