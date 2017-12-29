package org.laxio.piston.piston.entity.type;

import org.laxio.piston.piston.entity.Direction;
import org.laxio.piston.piston.entity.Entity;

public interface PaintingEntity extends Entity {

    String getTitle();

    Direction getDirection();

}
