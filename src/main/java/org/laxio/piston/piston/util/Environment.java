package org.laxio.piston.piston.util;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Environment {

    private static final Object lock = new Object();
    private static boolean debugMode = false;

    public static boolean isDebugMode() {
        synchronized (lock) {
            return debugMode;
        }
    }

    public static void setDebugMode(boolean debugMode) {
        synchronized (lock) {
            if (debugMode) {
                Logger.getGlobal().setLevel(Level.ALL);
            }

            Environment.debugMode = debugMode;
        }
    }

}
