package org.laxio.piston.piston.world;

public interface Block {

    Location getLocation();

    /**
     * Gets the block's X position in the chunk
     *
     * @return the block's X position in the chunk
     */
    default int getChunkX() {
        return getLocation().getBlockX() % 16;
    }

    /**
     * Gets the block's Z position in the chunk
     *
     * @return the block's Z position in the chunk
     */
    default int getChunkZ() {
        return getLocation().getBlockZ() % 16;
    }

}
