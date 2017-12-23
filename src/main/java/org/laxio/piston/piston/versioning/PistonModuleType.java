package org.laxio.piston.piston.versioning;

import org.laxio.piston.piston.exception.versioning.PistonModuleException;

public enum PistonModuleType {

    PISTON,
    PROTOCOL,
    STICKYPISTON,
    IGNITION;

    private PistonModule module;

    public PistonModule getModule() {
        return module;
    }

    public void setModule(PistonModule module) {
        if (module != null) {
            throw new PistonModuleException("Module is already set", this);
        }

        this.module = module;
    }

}
