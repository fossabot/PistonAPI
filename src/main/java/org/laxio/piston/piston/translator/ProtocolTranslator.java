package org.laxio.piston.piston.translator;

import org.laxio.piston.piston.protocol.Packet;

public interface ProtocolTranslator {

    int getTranslatedVersion();

    int getNativeVersion();

    boolean matches(Packet packet);

    Packet translateToNative(Packet packet);

    Packet translateFromNative(Packet packet);

}
