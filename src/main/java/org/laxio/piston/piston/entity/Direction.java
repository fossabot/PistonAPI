package org.laxio.piston.piston.entity;

public enum Direction {

    DOWN(0, -1),
    UP(1, -1),
    NORTH(2, 2),
    SOUTH(3, 0),
    WEST(4, 1),
    EAST(5, 3);

    private int id;
    private byte paintingId;

    Direction(int id, int paintingId) {
        this.id = id;
        this.paintingId = (byte) paintingId;
    }

    public int getId() {
        return id;
    }

    public byte getPaintingId() {
        return paintingId;
    }

    public static Direction getById(int id) {
        for (Direction direction : values()) {
            if (direction.id == id) {
                return direction;
            }
        }

        return null;
    }

    public static Direction getByPaintingId(int id) {
        for (Direction direction : values()) {
            if (direction.paintingId == id) {
                return direction;
            }
        }

        return null;
    }

}
