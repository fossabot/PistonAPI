package org.laxio.piston.piston.logging;

import java.util.logging.Level;

public interface LogHandler {

    void handle(Level level, String message);

}
