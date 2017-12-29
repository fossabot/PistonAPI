package org.laxio.piston.piston.entity.player;

public enum Animation {

    SWING_MAIN_ARM(0),
    TAKE_DAMAGE(1),
    LEAVE_BED(2),
    SWING_OFFHAND(3),
    CRITICAL_EFFECT(4),
    MAGIC_CRITICAL_EFFECT(5);

    private byte id;

    Animation(int id) {
        this.id = (byte) id;
    }

    public byte getId() {
        return id;
    }

}
