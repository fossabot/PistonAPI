package org.laxio.piston.piston.exception.event;

import org.laxio.piston.piston.event.listener.Listener;

public class ListenerConfigurationException extends RuntimeException {

    private Listener listener;

    public ListenerConfigurationException(Throwable cause, Listener listener) {
        super(cause);
        this.listener = listener;
    }

    public ListenerConfigurationException(String message, Listener listener) {
        super(message);
        this.listener = listener;
    }

    public ListenerConfigurationException(String message, Throwable cause, Listener listener) {
        super(message, cause);
        this.listener = listener;
    }

    public Listener getListener() {
        return listener;
    }

}
