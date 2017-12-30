package org.laxio.piston.piston.world;

public class Location {

    protected double x;
    protected double y;
    protected double z;

    protected float yaw;
    protected float pitch;

    public Location(int x, int y, int z) {
        this.x = asBlockPoint(x);
        this.y = asBlockPoint(y);
        this.z = asBlockPoint(z);
    }

    public Location(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Location(double x, double y, double z, float yaw, float pitch) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public float getYaw() {
        return yaw;
    }

    public float getPitch() {
        return pitch;
    }

    public int getBlockX() {
        return asBlockPoint(this.x);
    }

    public int getBlockY() {
        return asBlockPoint(this.y);
    }

    public int getBlockZ() {
        return asBlockPoint(this.z);
    }

    private int asBlockPoint(double pos) {
        return (int) Math.floor(pos);
    }

}
