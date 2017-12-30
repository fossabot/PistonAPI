package org.laxio.piston.piston.world;

import org.laxio.piston.piston.PistonServer;

import java.util.List;

public interface World {

    PistonServer getServer();

    List<Chunk> getChunks();

    Block getBlock(Location location);

}
