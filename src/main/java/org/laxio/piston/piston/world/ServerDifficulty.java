package org.laxio.piston.piston.world;

public enum ServerDifficulty {

    PEACEFUL(0),
    EASY(1),
    NORMAL(2),
    HARD(3);

    private byte id;

    ServerDifficulty(int id) {
        this.id = (byte) id;
    }

    public byte getId() {
        return id;
    }

}
