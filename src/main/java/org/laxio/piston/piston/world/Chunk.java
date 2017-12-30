package org.laxio.piston.piston.world;

import org.laxio.piston.piston.PistonServer;

public interface Chunk {

    PistonServer getServer();

    World getWorld();

    int getX();

    int getZ();

}
