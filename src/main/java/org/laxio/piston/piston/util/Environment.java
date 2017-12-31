package org.laxio.piston.piston.util;

import org.laxio.piston.piston.chat.StatusLevel;

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
                Logger.getGlobal().setLevel(StatusLevel.DEBUG_LEVEL);
            }

            Environment.debugMode = debugMode;
        }
    }

}
