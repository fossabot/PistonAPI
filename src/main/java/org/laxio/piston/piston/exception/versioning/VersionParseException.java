package org.laxio.piston.piston.exception.versioning;

import org.laxio.piston.piston.exception.PistonRuntimeException;

/**
 * Thrown when there is an issue parsing a version string
 */
public class VersionParseException extends PistonRuntimeException {

    private String version;

    public VersionParseException(String message, String version) {
        super(message + ": " + version);
        this.version = version;
    }

    /**
     * Get the version that had issues while parsing
     * @return The version with parsing issues
     */
    public String getVersion() {
        return version;
    }

}
