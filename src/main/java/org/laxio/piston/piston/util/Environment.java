package org.laxio.piston.piston.util;

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
            Environment.debugMode = debugMode;
        }
    }

}
