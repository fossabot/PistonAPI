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

    private Level level;
    private final ChatColor color;

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
