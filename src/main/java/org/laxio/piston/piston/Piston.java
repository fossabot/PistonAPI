package org.laxio.piston.piston;

import org.laxio.piston.piston.list.LockableLinkedList;
import org.laxio.piston.piston.versioning.PistonModule;

import java.util.List;

public class Piston {

    private final static List<PistonModule> modules;

    public static List<PistonModule> getModules() {
        return modules;
    }

    static {
        modules = new LockableLinkedList<>();

    }

}
