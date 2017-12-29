package org.laxio.piston.piston.chat;

import org.laxio.piston.piston.logging.Logger;

public enum StatusLevel {

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
