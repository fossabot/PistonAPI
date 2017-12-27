package org.laxio.piston.piston.session;

import java.util.UUID;

public interface Profile {

    UUID getUniqueId();

    String getName();

    boolean isAuthenticated();

    void authenticate(String hash);

}
