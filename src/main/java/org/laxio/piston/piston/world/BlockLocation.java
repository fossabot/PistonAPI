package org.laxio.piston.piston.world;

public class BlockLocation extends Location {

    private World world;

    public BlockLocation(World world, int x, int y, int z) {
        super(x, y, z);
    }

    @Override
    public float getYaw() {
        throw new UnsupportedOperationException("Blocks don't have yaw/pitch");
    }

    @Override
    public float getPitch() {
        throw new UnsupportedOperationException("Blocks don't have yaw/pitch");
    }

}
