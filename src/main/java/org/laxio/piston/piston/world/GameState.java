package org.laxio.piston.piston.world;

public enum GameState {

    INVALID_BED(0),
    END_RAINING(1),
    BEGIN_RAINING(2),
    CHANGE_GAMEMODE(3),
    EXIT_END(4),
    DEMO_MESSAGE(5),
    ARROW_HITTING_PLAYER(6),
    FADE_VALUE(7),
    FADE_TIME(8),
    ELDER_GUARDIAN(10);

    private byte state;

    GameState(int state) {
        this.state = (byte) state;
    }

    public byte getState() {
        return state;
    }

}
