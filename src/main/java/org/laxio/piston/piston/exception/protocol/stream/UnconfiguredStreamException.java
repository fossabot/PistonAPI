package org.laxio.piston.piston.exception.protocol.stream;

import org.laxio.piston.piston.exception.PistonRuntimeException;

/**
 * Thrown when the StreamHandler has not been configured
 * @see org.laxio.piston.piston.protocol.stream.StreamManager
 */
public class UnconfiguredStreamException extends PistonRuntimeException {

    public UnconfiguredStreamException() {
        super();
    }

}
