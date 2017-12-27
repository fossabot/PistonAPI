package org.laxio.piston.piston.session;

import org.laxio.piston.piston.exception.protocol.auth.SessionAuthenticationException;

public interface MinecraftSessionService {

    SessionResponse hasJoined(Profile profile, String serverId) throws SessionAuthenticationException;

}
