package org.laxio.piston.piston.inventory;

public enum InventoryType {

    CONTAINER,
    CHEST,
    CRAFTING_TABLE,
    FURNACE,
    DISPENSER,
    ENCHANTING_TABLE,
    BREWING_STAND,
    VILLAGER,
    BEACON,
    ANVIL,
    HOPPER,
    DROPPER,
    SHULKER_BOX,
    HORSE("EntityHorse");

    private String name;

    InventoryType() {
        this.name = "minecraft:" + name().toLowerCase();
    }

    InventoryType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
