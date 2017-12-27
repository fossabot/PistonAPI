package org.laxio.piston.piston.entity;

import org.laxio.piston.piston.world.Location;

import java.util.UUID;

public interface Entity {

    int getEntityId();

    UUID getUUID();

    EntityType getType();

    /**
     * Gets the data int for this entity
     * See <a href="http://wiki.vg/Object_Data">here</a> for details
     *
     * @return The data int for this entity
     */
    int getData();

    Location getLocation();

    Velocity getVelocity();

}
