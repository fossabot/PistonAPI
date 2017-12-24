package org.laxio.piston.piston.exception.protocol.packet;

import org.laxio.piston.piston.exception.PistonRuntimeException;

/**
 * Thrown when there is an issue with the state id (can't match state to id)
 */
public class InvalidStateException extends PistonRuntimeException {

    private int state;

    public InvalidStateException(int state) {
        super("Received " + state);
        this.state = state;
    }

    /**
     * Gets the state id which is invalid
     * @return The invalid state id
     */
    public int getState() {
        return state;
    }

}
