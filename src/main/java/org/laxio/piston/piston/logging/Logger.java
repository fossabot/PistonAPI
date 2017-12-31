package org.laxio.piston.piston.logging;

import org.laxio.piston.piston.chat.StatusLevel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

public class Logger {

    private static final String GLOBAL_NAME = "";
    private static final Logger GLOBAL_LOGGER;
    private static final Map<String, Logger> loggers = new HashMap<>();

    static {
        GLOBAL_LOGGER = new Logger(GLOBAL_NAME);
        loggers.put(GLOBAL_NAME, GLOBAL_LOGGER);
    }

    private final String name;
    private List<LogHandler> handlers;

    public Logger(String name) {
        this.name = name;
        this.handlers = new ArrayList<>();
        this.handlers.add(new JavaLogHandler(java.util.logging.Logger.getGlobal()));
    }

    public String getName() {
        return name;
    }

    public void log(Level level, String message, Object... args) {
        String prefix = "";
        if (name != null && name.length() > 0) {
            prefix = "[" + name + "] ";
        }

        String replaced = message;
        for (int i = 0; i < args.length; i++) {
            Object obj = args[i];
            if (!replaced.contains("{}")) {
                throw new IndexOutOfBoundsException("#" + i + " exceeds suppliers");
            }

            replaced = replaced.replaceFirst("\\{}", obj.toString());
        }

        replaced = prefix + replaced;
        for (LogHandler handler : handlers) {
            handler.handle(level, replaced);
        }
    }

    public void info(String message, Object... args) {
        log(Level.INFO, message, args);
    }

    public void warning(String message, Object... args) {
        log(Level.WARNING, message, args);
    }

    public void severe(String message, Object... args) {
        log(Level.SEVERE, message, args);
    }

    public void config(String message, Object... args) {
        log(Level.CONFIG, message, args);
    }

    public void debug(String message, Object... args) {
        log(StatusLevel.DEBUG_LEVEL, message, args);
    }

    public static Logger getLogger(String name) {
        if (name == null || name.length() <= 0 || name.equalsIgnoreCase(GLOBAL_NAME)) {
            return GLOBAL_LOGGER;
        }

        Logger logger = loggers.get(name);
        if (logger == null) {
            logger = new Logger(name);
        }

        return logger;
    }

    public static Logger getGlobal() {
        return GLOBAL_LOGGER;
    }

}
