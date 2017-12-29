package org.laxio.piston.piston.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaLogHandler implements LogHandler {

    private final Logger logger;

    public JavaLogHandler(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void handle(Level level, String message) {
        logger.log(level, message);
    }

}
