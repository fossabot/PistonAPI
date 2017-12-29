package org.laxio.piston.piston.entity;

public enum Direction {

    DOWN(0),
    UP(1),
    NORTH(2),
    SOUTH(3),
    WEST(4),
    EAST(5);

    private int id;

    Direction(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Direction getById(int id) {
        for (Direction direction : values()) {
            if (direction.id == id) {
                return direction;
            }
        }

        return null;
    }

}
