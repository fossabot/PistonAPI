package org.laxio.piston.piston;

import org.laxio.piston.piston.list.LockableLinkedList;
import org.laxio.piston.piston.versioning.PistonModule;

import java.util.List;

public class Piston {

    private final static List<PistonModule> modules;

    static {
        modules = new LockableLinkedList<>();

    }

    public static List<PistonModule> getModules() {
        return modules;
    }

}
