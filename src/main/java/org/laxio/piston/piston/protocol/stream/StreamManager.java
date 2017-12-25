package org.laxio.piston.piston.protocol.stream;

import org.laxio.piston.piston.exception.protocol.stream.UnconfiguredStreamException;

import java.util.logging.Logger;

public class StreamManager {

    public static final StreamManager MANAGER = new StreamManager();

    private StreamHandler handler;

    /**
     * Gets the handler currently being used by Piston
     * @return The current handler
     */
    public StreamHandler getHandler() {
        synchronized (MANAGER) {
            if (handler == null)
                throw new UnconfiguredStreamException();

            return handler;
        }
    }

    /**
     * Sets the handler to be used
     * @param handler The handler to set
     */
    public void setHandler(StreamHandler handler) {
        synchronized (MANAGER) {
            if (this.handler != null) {
                Logger.getGlobal().info("Stream Handler set to " + handler.getClass());
            }

            this.handler = handler;
        }
    }

}
