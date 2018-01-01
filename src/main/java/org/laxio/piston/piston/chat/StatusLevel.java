/*-
 * ========================LICENSE_START========================
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
 * ========================LICENSE_END========================
 */
package org.laxio.piston.piston.chat;

import org.laxio.piston.piston.logging.Logger;
import org.laxio.piston.piston.util.DebugLevel;

import java.util.logging.Level;

public enum StatusLevel {

    DEBUG(null, ChatColor.LIGHT_PURPLE) {
        @Override
        void log(Logger logger, String message) {
            logger.log(DEBUG_LEVEL, message);
        }
    },
    CONFIG(Level.CONFIG, ChatColor.AQUA) {
        @Override
        void log(Logger logger, String message) {
            logger.config(message);
        }
    },
    WARNING(Level.WARNING, ChatColor.RED) {
        @Override
        void log(Logger logger, String message) {
            logger.warning(message);
        }
    },
    SEVERE(Level.SEVERE, ChatColor.YELLOW) {
        @Override
        void log(Logger logger, String message) {
            logger.severe(message);
        }
    },
    NORMAL(Level.INFO, ChatColor.WHITE) {
        @Override
        void log(Logger logger, String message) {
            logger.info(message);
        }
    };

    public static final Level DEBUG_LEVEL = new DebugLevel();
    private final ChatColor color;
    private Level level;

    StatusLevel(Level level, ChatColor color) {
        this.level = level;
        this.color = color;
    }

    public Level getLevel() {
        if (this.level == null) {
            this.level = DEBUG_LEVEL;
        }

        return level;
    }

    public ChatColor getColor() {
        return color;
    }

    public void log(String message) {
        log(Logger.getGlobal(), message);
    }

    abstract void log(Logger logger, String message);

    public static StatusLevel getLevel(Level level) {
        for (StatusLevel status : values()) {
            if (status.getLevel().equals(level)) {
                return status;
            }
        }

        return NORMAL;
    }

}
