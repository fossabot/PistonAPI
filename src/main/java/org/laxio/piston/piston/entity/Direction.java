package org.laxio.piston.piston.entity;

        /*-
         * #%L
         * Piston API
         * %%
         * Copyright (C) 2017 - 2018 Laxio
         * %%
         * This file is part of Piston, licensed under the MIT License (MIT).
         *
         * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
         *
         * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
         *
         * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
         * #L%
         */

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
