package org.laxio.piston.piston.boss;

public enum BossBarColor {

    PINK(0),
    BLUE(1),
    RED(2),
    GREEN(3),
    YELLOW(4),
    PURPLE(5),
    WHITE(6);

    private int id;

    BossBarColor(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
