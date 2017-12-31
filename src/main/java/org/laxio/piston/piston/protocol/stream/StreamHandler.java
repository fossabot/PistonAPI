package org.laxio.piston.piston.protocol.stream;

        /*-
         * #%L
         * Piston API
         * %%
         * Copyright (C) 2017 Laxio
         * %%
         * This file is part of Piston, licensed under the MIT License (MIT).
         *
         * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
         *
         * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
         *
         * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
         * #L%
         */

import org.laxio.piston.piston.entity.Metadata;
import org.laxio.piston.piston.entity.player.Player;

import java.io.IOException;

/**
 * Handles reading data types that are not available to be constructed from the API
 */
public interface StreamHandler {

    /**
     * Reads the player from the input
     *
     * @param input The input to read from
     *
     * @return The Player object reference for this handler
     */
    Player readPlayer(PistonInput input) throws IOException;

    /**
     * Writes the player reference to the output
     *
     * @param output The output to write to
     * @param player The player to write
     */
    void writeMetadata(PistonOutput output, Player player) throws IOException;

    /**
     * Reads the metadata from the input
     *
     * @param input The input to read from
     *
     * @return The Metadata from the input source
     */
    Metadata readMetadata(PistonInput input) throws IOException;

    /**
     * Writes the supplied metadata to the output
     *
     * @param output   The output to write to
     * @param metadata The metadata to write
     */
    void writeMetadata(PistonOutput output, Metadata metadata) throws IOException;

}
