package org.laxio.piston.piston.protocol;

        /*-
         * #%L
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
         * #L%
         */

import org.laxio.piston.piston.PistonServer;
import org.laxio.piston.piston.exception.protocol.packet.PacketNotFoundException;
import org.laxio.piston.piston.exception.protocol.packet.UnsupportedPacketException;

/**
 * Protocol interface implemented by StickyProtocol
 */
public interface Protocol {

    PistonServer getServer();

    void setServer(PistonServer server);

    Packet getPacket(ProtocolState state, PacketDirection direction, int id) throws UnsupportedPacketException, PacketNotFoundException;

    int getId(Packet packet) throws PacketNotFoundException;

    int getVersion();

}
