package org.laxio.piston.piston.entity;

        /*-
         * #%L
         * Piston API
         * %%
         * Copyright (C) 2017 Laxio
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
 * Represents a type of entity
 * See <a href="http://wiki.vg/Entity_metadata#Entity">here</a> for further detail
 */
public enum EntityType {

    ITEM(1),
    XP_ORB(2),
    AREA_EFFECT_CLOUD(3),
    ELDER_GUARDIAN(4),
    WITHER_SKELETON(5),
    STRAY(6),
    THROWN_EGG(7),
    LEASH_KNOT(8),
    PAINTING(9),
    ARROW(10),
    SNOWBALL(11),
    FIREBALL(12),
    SMALL_FIREBALL(13),
    THROWN_ENDERPEARL(14),
    EYE_OF_ENDER_SIGNAL(15),
    THROWN_POTION(16, "minecraft:potion"),
    THROWN_EXP_BOTTLE(17, "minecraft:xp_bottle"),
    ITEM_FRAME(18),
    WITHER_SKULL(19),
    PRIMED_TNT(20, "minecraft:tnt"),
    FALLING_SAND(21, "minecraft:falling_block"),
    FIREWORKS_ROCKET(22),
    HUSK(23),
    SPECTRAL_ARROW(24),
    SHULKER_BULLET(25),
    DRAGON_FIREBALL(26),
    ZOMBIE_VILLAGER(27),
    SKELETON_HORSE(28),
    ZOMBIE_HORSE(29),
    ARMOR_STAND(30),
    DONKEY(31),
    MULE(32),
    EVOCATION_FANGS(33),
    EVOCATION_ILLAGER(34),
    VEX(35),
    VINDICATION_ILLAGER(36),
    ILLUSION_ILLAGER(37),
    MINECART_COMMAND_BLOCK(40, "minecraft:commandblock_minecart"),
    BOAT(41),
    MINECART_RIDEABLE(42, "minecraft:minecart"),
    MINECART_CHEST(43, "minecraft:chest_minecart"),
    MINECART_FURNACE(44, "minecraft:furnace_minecart"),
    MINECART_TNT(45, "minecraft:tnt_minecart"),
    MINECART_HOPPER(46, "minecraft:hopper_minecart"),
    MINECART_SPAWNER(47, "minecraft:spawner_minecart"),
    CREEPER(50),
    SKELETON(51),
    SPIDER(52),
    GIANT(53),
    ZOMBIE(54),
    SLIME(55),
    GHAST(56),
    PIG_ZOMBIE(57, "minecraft:zombie_pigman"),
    ENDERMAN(58),
    CAVE_SPIDER(59),
    SILVERFISH(60),
    BLAZE(61),
    MAGMA_CUBE(62),
    ENDER_DRAGON(63),
    WITHER(64),
    BAT(65),
    WITCH(66),
    ENDERMITE(67),
    GUARDIAN(68),
    SHULKER(69),
    PIG(90),
    SHEEP(91),
    COW(92),
    CHICKEN(93),
    SQUID(94),
    WOLF(95),
    MOOSHROOM(96),
    SNOWMAN(97),
    OCELOT(98),
    VILLAGER_GOLEM(99),
    HORSE(100),
    RABBIT(101),
    POLAR_BEAR(102),
    LLAMA(103),
    LLAMA_SPIT(104),
    PARROT(105),
    VILLAGER(120),
    ENDER_CRYSTAL(200, "minecraft:end_crystal"),
    PLAYER(-1);

    private int type;
    private String id;

    EntityType(int type) {
        this.type = type;
        this.id = "minecraft:" + name().toLowerCase();
    }

    EntityType(int type, String id) {
        this.type = type;
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public String getId() {
        return id;
    }

}
