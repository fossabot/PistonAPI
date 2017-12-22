package org.laxio.piston.piston;

import org.laxio.piston.piston.protocol.Protocol;

public interface PistonServer {

    String getVersion();

    String getMinecraftVersion();

    Protocol getProtocol();

}
