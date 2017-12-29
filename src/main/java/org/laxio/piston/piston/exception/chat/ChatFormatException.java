package org.laxio.piston.piston.exception.chat;

import org.laxio.piston.piston.chat.MessageComponent;
import org.laxio.piston.piston.exception.PistonRuntimeException;

/**
 * Thrown when the format of this supplied component is invalid
 */
public class ChatFormatException extends PistonRuntimeException {

    private MessageComponent component;

    public ChatFormatException(String message, MessageComponent component) {
        super(message);
        this.component = component;
    }

    public MessageComponent getComponent() {
        return component;
    }

}
