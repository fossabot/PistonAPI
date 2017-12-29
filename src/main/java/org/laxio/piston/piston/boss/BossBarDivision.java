package org.laxio.piston.piston.boss;

public enum BossBarDivision {

    NONE(0, 0),
    SIX(1, 6),
    TEN(2, 10),
    TWELVE(3, 12),
    TWENTY(4, 20);

    private int id;
    private int notches;

    BossBarDivision(int id, int notches) {
        this.id = id;
        this.notches = notches;
    }

    public int getId() {
        return id;
    }

    public int getNotches() {
        return notches;
    }

}
