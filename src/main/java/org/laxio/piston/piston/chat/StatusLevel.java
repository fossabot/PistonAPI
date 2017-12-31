package org.laxio.piston.piston.chat;

import org.laxio.piston.piston.logging.Logger;
import org.laxio.piston.piston.util.DebugLevel;

import java.util.logging.Level;

public enum StatusLevel {

    DEBUG(ChatColor.LIGHT_PURPLE) {
        @Override
        void log(Logger logger, String message) {
            logger.log(DEBUG_LEVEL, message);
        }
    },
    CONFIG(ChatColor.AQUA) {
        @Override
        void log(Logger logger, String message) {
            logger.config(message);
        }
    },
    WARNING(ChatColor.RED) {
        @Override
        void log(Logger logger, String message) {
            logger.warning(message);
        }
    },
    SEVERE(ChatColor.YELLOW) {
        @Override
        void log(Logger logger, String message) {
            logger.severe(message);
        }
    },
    NORMAL(ChatColor.WHITE) {
        @Override
        void log(Logger logger, String message) {
            logger.info(message);
        }
    };

    public static final Level DEBUG_LEVEL = new DebugLevel();

    private final ChatColor color;

    StatusLevel(ChatColor color) {
        this.color = color;
    }

    public ChatColor getColor() {
        return color;
    }

    public void log(String message) {
        log(Logger.getGlobal(), message);
    }

    abstract void log(Logger logger, String message);

}
