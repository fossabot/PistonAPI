package org.laxio.piston.piston;

import java.util.ArrayList;
import java.util.List;

public class ServerManager {

    private static final ServerManager instance;

    static {
        instance = new ServerManager();
    }

    private final List<PistonServer> servers;

    private ServerManager() {
        this.servers = new ArrayList<>();
    }

    public List<PistonServer> getServers() {
        return servers;
    }

    public void addServer(PistonServer server) {
        this.servers.add(server);
    }

    public static ServerManager getInstance() {
        return instance;
    }

}
