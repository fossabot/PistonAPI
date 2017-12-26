package org.laxio.piston.piston.entity;

/**
 * See <a href="http://wiki.vg/Protocol#Entity_Velocity">here</a> for reference.
 * Velocity is 1/8000 of a block per 50ms. -1343/8000 would be -0.167875 (-3.3575 blocks per second)
 */
public class Velocity {

    private short x;
    private short y;
    private short z;

    public Velocity(short x, short y, short z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public short getX() {
        return x;
    }

    public short getY() {
        return y;
    }

    public short getZ() {
        return z;
    }

}
