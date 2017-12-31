package org.laxio.piston.piston.protocol;

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

import org.laxio.piston.piston.PistonServer;
import org.laxio.piston.piston.protocol.stream.PistonInput;
import org.laxio.piston.piston.protocol.stream.PistonOutput;

import java.io.IOException;

/**
 * Interface implemented by Protocol packets
 */
public interface Packet {

    /**
     * Returns the version of this packet
     *
     * @return The version of this packet
     */
    int getVersion();

    /**
     * Returns the connection that this Packet belongs too
     *
     * @return The connection that this packet belongs too
     */
    Connection getConnection();

    /**
     * Sets the connection that this Packet belongs to
     *
     * @param connection The connection to set
     *
     * @throws org.laxio.piston.piston.exception.protocol.packet.PacketConfigurationException When there is already a connection set
     */
    void setConnection(Connection connection);

    /**
     * Returns the server that this Packet belongs too
     *
     * @return The server that this packet belongs too
     */
    PistonServer getServer();

    /**
     * Sets the server that this Packet belongs to
     *
     * @param server The server to set
     *
     * @throws org.laxio.piston.piston.exception.protocol.packet.PacketConfigurationException When there is already a server set
     */
    void setServer(PistonServer server);

    /**
     * Responds to this packet with the supplied response
     *
     * @param packet The packet to respond with
     */
    default void reply(Packet packet) {
        getConnection().sendPacket(packet);
    }

    /**
     * Reads the data from the input
     *
     * @param input The source of data
     *
     * @throws IOException
     * @throws UnsupportedOperationException If this packet can't be read
     */
    void onRead(PistonInput input) throws IOException;

    /**
     * Called by the server when a Packet is being read
     *
     * @param input The input source
     *
     * @throws IOException
     * @throws UnsupportedOperationException If this packet can't be read
     */
    void read(PistonInput input) throws IOException;

    /**
     * Writes the data to the output
     *
     * @param output The output destination
     *
     * @throws IOException
     * @throws UnsupportedOperationException If this packet can't be written
     */
    void onWrite(PistonOutput output) throws IOException;

    /**
     * Called by the server when a Packet is being written
     *
     * @param output The output destination
     *
     * @throws IOException
     * @throws UnsupportedOperationException If this packet can't be written
     */
    void write(PistonOutput output) throws IOException;

}
