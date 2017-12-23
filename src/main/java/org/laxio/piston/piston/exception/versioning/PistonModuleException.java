package org.laxio.piston.piston.exception.versioning;

import org.laxio.piston.piston.exception.PistonRuntimeException;
import org.laxio.piston.piston.versioning.PistonModuleType;

/**
 * Thrown when there is an error with a PistonModule
 */
public class PistonModuleException extends PistonRuntimeException {

    private PistonModuleType type;

    public PistonModuleException(String message, PistonModuleType type) {
        super(message);
        this.type = type;
    }

    /**
     * Gets the type of module which caused the exception
     * @return The module type
     */
    public PistonModuleType getType() {
        return type;
    }

}
