package org.laxio.piston.piston.protocol;

import java.net.InetSocketAddress;

public interface Connection {

    ProtocolState getState();

    void setState(ProtocolState state);

    void sendPacket(Packet packet);

    boolean isEncrypted();

    InetSocketAddress getAddress();

}
