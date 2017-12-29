package org.laxio.piston.piston.chat.event.hover;

/**
 * Represents the show_item action.
 * Displays the supplied item
 */
public class ShowItemEvent implements HoverEvent {

    /*
    private final ItemStack item;

    public ShowItemEvent(ItemStack item) {
        this.item = item;
    }

    public ItemStack getItem() {
        return item;
    }
    */

    @Override
    public String getAction() {
        return "show_item";
    }

    @Override
    public Object getValue() {
        // TODO: this event
        throw new UnsupportedOperationException("Items are not currently implemented");
    }

}
