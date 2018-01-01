package org.laxio.piston.piston.logging;

        /*-
         * #%L
         * Piston API
         * %%
         * Copyright (C) 2017 - 2018 Laxio
         * %%
         * This file is part of Piston, licensed under the MIT License (MIT).
         *
         * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
         *
         * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
         *
         * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
         * #L%
         */

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
