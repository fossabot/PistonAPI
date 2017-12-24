package org.laxio.piston.piston.protocol;

import org.laxio.piston.piston.PistonServer;

/**
 * Interface implemented by Protocol packets
 */
public interface Packet {

    /**
     * Returns the server that this Packet belongs too
     * @return The server that this packet belongs too
     */
    PistonServer getServer();

}
