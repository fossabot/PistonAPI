package org.laxio.piston.piston.translator;

import org.laxio.piston.piston.protocol.Packet;
import org.laxio.piston.piston.versioning.Version;

public interface ProtocolTranslator {

    Version getTranslatedVersion();

    Version getNativeVersion();

    boolean matches(Packet packet);

}
