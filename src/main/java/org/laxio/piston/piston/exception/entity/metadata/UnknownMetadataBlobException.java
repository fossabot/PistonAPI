package org.laxio.piston.piston.exception.entity.metadata;

import org.laxio.piston.piston.exception.PistonException;

/**
 * Thrown by Protocol when a blob type is read that is unknown
 */
public class UnknownMetadataBlobException extends PistonException {

    private int type;

    public UnknownMetadataBlobException(String message, int type) {
        super(message);
        this.type = type;
    }

    public int getType() {
        return type;
    }

}
