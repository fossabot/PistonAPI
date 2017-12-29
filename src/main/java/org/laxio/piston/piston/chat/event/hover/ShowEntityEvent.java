package org.laxio.piston.piston.chat.event.hover;

import org.laxio.piston.piston.entity.Entity;

/**
 * Represents the show_entity action.
 * Displays the supplied entity
 */
public class ShowEntityEvent implements HoverEvent {

    private final Entity entity;

    public ShowEntityEvent(Entity entity) {
        this.entity = entity;
    }

    public Entity getEntity() {
        return entity;
    }

    @Override
    public String getAction() {
        return "show_entity";
    }

    @Override
    public Object getValue() {
        // TODO: this event
        throw new UnsupportedOperationException("Items are not currently implemented");
    }

}
