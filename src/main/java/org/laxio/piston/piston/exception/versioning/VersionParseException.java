/*-
 * ========================LICENSE_START========================
 * Piston API
 * %%
 * Copyright (C) 2017 - 2018 Laxio
 * %%
 * This file is part of Piston, licensed under the MIT License (MIT).
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * ========================LICENSE_END========================
 */
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

    public VersionParseException(String message, Throwable cause, String version) {
        super(message, cause);
        this.version = version;
    }

    /**
     * Get the version that had issues while parsing
     *
     * @return The version with parsing issues
     */
    public String getVersion() {
        return version;
    }

}
