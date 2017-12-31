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

import org.laxio.piston.piston.data.Identifier;
import org.laxio.piston.piston.entity.Metadata;
import org.laxio.piston.piston.entity.Velocity;
import org.laxio.piston.piston.entity.player.Player;
import org.laxio.piston.piston.world.Location;

import java.io.IOException;
import java.util.UUID;

/**
 * Implemented by Protocol to manage Buffer/Stream input
 */
public interface PistonInput {

    int readableBytes();

    int read() throws IOException;

    byte readByte() throws IOException;

    byte[] readBytes() throws IOException;

    byte[] readBytes(int length) throws IOException;

    long readLong() throws IOException;

    int readUnsignedShort() throws IOException;

    int readUnsignedByte() throws IOException;

    double readDouble() throws IOException;

    float readFloat() throws IOException;

    short readShort() throws IOException;

    int readInt() throws IOException;

    boolean readBoolean() throws IOException;

    /**
     * Read a UUID
     *
     * @return The UUID that is available in this stream
     *
     * @throws IOException
     */
    UUID readUUID() throws IOException;

    /**
     * Read a UUID
     *
     * @param dashes If true read the UUID as a string with dashes
     *
     * @return The UUID that is available in this stream
     *
     * @throws IOException
     */
    UUID readUUID(boolean dashes) throws IOException;

    /**
     * Reads a string
     *
     * @return The string available
     *
     * @throws IOException
     * @see <a href="http://wiki.vg/Protocol#Data_types">Protocol Data Types</a>
     */
    String readString() throws IOException;

    /**
     * Reads a VarInt
     *
     * @return The VarInt available
     *
     * @throws IOException
     * @see <a href="http://wiki.vg/Protocol#Data_types">Protocol Data Types</a>
     */
    int readVarInt() throws IOException;

    /**
     * Reads a VarLong
     *
     * @return The VarLong available
     *
     * @throws IOException
     * @see <a href="http://wiki.vg/Protocol#Data_types">Protocol Data Types</a>
     */
    long readVarLong() throws IOException;

    /**
     * Reads an Identifier
     *
     * @return The Identifier available
     *
     * @throws IOException
     * @see <a href="http://wiki.vg/Protocol#Data_types">Protocol Data Types</a>
     */
    Identifier readIdentifier() throws IOException;

    default Player readPlayer() throws IOException {
        return StreamManager.MANAGER.getHandler().readPlayer(this);
    }

    Location readLocation() throws IOException;

    Location readLocation(boolean yawPitch) throws IOException;

    float readRotation() throws IOException;

    Velocity readVelocity() throws IOException;

    Location readPosition() throws IOException;

    default Metadata readMetadata() throws IOException {
        return StreamManager.MANAGER.getHandler().readMetadata(this);
    }

}
