package org.laxio.piston.piston;

import org.laxio.piston.piston.event.ListenerManager;
import org.laxio.piston.piston.protocol.Protocol;

import java.security.KeyPair;

public interface PistonServer {

    String getVersion();

    String getMinecraftVersion();

    Protocol getProtocol();

    ListenerManager getManager();

    KeyPair getKeyPair();

    boolean isOnlineMode();

}
