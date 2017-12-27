package org.laxio.piston.piston.versioning;

import org.laxio.piston.piston.exception.versioning.PistonModuleException;

public enum PistonModuleType {

    PISTON,
    PROTOCOL,
    STICKYPISTON,
    IGNITION,
    MINECRAFT;

    private PistonModule module;

    /**
     * Gets the module that has been set for this type
     *
     * @return The module set for this type
     */
    public PistonModule getModule() {
        return module;
    }

    /**
     * Sets the module for this type
     *
     * @param module The module to set
     */
    public void setModule(PistonModule module) {
        if (this.module != null) {
            throw new PistonModuleException("Module is already set", this);
        }

        this.module = module;
    }

}
