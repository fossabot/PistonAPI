package org.laxio.piston.piston.session;

import java.util.UUID;

public class SessionResponse {

    private final String name;
    private final UUID uuid;
    // properties

    public SessionResponse(String name, UUID uuid) {
        this.name = name;
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public UUID getUuid() {
        return uuid;
    }

}
