package org.laxio.piston.piston.translator;

import org.laxio.piston.piston.PistonServer;
import org.laxio.piston.piston.protocol.Packet;
import org.laxio.piston.piston.versioning.Version;

public interface ProtocolTranslator {

    PistonServer getServer();

    Version getNativeMinecraftVersion();

    int getNativeVersion();

    int getTranslatedVersion();

    boolean matches(Packet packet);

    Packet translateToNative(Packet packet);

    Packet translateFromNative(Packet packet);

}
