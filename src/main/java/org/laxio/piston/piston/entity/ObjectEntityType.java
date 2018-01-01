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

/**
 * Represents a type of object
 * See <a href="http://wiki.vg/Entity_metadata#Objects">here</a> for further detail
 */
public enum ObjectEntityType {

    BOAT(1),
    ITEM_STACK(2),
    AREA_EFFECT_CLOUD(3),
    MINECART(10),
    ACTIVATED_TNT(50),
    ENDER_CRYSTAL(51),
    TIPPED_ARROW(60),
    SNOWBALL(61),
    EGG(62),
    FIRE_BALL(63),
    FIRE_CHARGE(64),
    THROWN_ENDERPEARL(65),
    WITHER_SKULL(66),
    SHULKER_BULLET(67),
    LLAMA_SPIT(68),
    FALLING_OBJECTS(70),
    ITEM_FRAMES(71),
    EYE_OF_ENDER(72),
    THROWN_POTION(73),
    THROWN_EXP_BOTTLE(75),
    FIREWORK_ROCKET(76),
    LEASH_KNOT(77),
    ARMOR_STAND(78),
    EVOCATION_FANGS(79),
    FISHING_HOOK(90),
    SPECTRAL_ARROW(91),
    DRAGON_FIREBALL(93);

    private byte id;

    ObjectEntityType(int id) {
        this((byte) id);
    }

    ObjectEntityType(byte id) {
        this.id = id;
    }

    public byte getId() {
        return id;
    }

}
