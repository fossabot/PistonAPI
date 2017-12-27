package org.laxio.piston.piston.entity;

public enum GlobalEntityType {

    THUNDERBOLT(1);

    private byte type;

    GlobalEntityType(byte type) {
        this.type = type;
    }

    GlobalEntityType(int type) {
        this.type = (byte) type;
    }

    public byte getType() {
        return type;
    }

}
