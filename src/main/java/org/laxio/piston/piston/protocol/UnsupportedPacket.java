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
package org.laxio.piston.piston.protocol;

import org.laxio.piston.piston.PistonServer;
import org.laxio.piston.piston.protocol.stream.PistonInput;
import org.laxio.piston.piston.protocol.stream.PistonOutput;

import java.io.IOException;

public class UnsupportedPacket implements Packet {

    private Packet packet;

    public UnsupportedPacket(Packet packet) {
        this.packet = packet;
    }

    @Override
    public int getVersion() {
        return packet.getVersion();
    }

    @Override
    public Connection getConnection() {
        return packet.getConnection();
    }

    @Override
    public void setConnection(Connection connection) {
        throw new UnsupportedOperationException("Unsupported Packet");
    }

    @Override
    public PistonServer getServer() {
        return packet.getServer();
    }

    @Override
    public void setServer(PistonServer server) {
        throw new UnsupportedOperationException("Unsupported Packet");
    }

    @Override
    public void onRead(PistonInput input) {
        throw new UnsupportedOperationException("Unsupported Packet");
    }

    @Override
    public void read(PistonInput input) {
        throw new UnsupportedOperationException("Unsupported Packet");
    }

    @Override
    public void onWrite(PistonOutput output) throws IOException {
        throw new UnsupportedOperationException("Unsupported Packet");
    }

    @Override
    public void write(PistonOutput output) throws IOException {
        throw new UnsupportedOperationException("Unsupported Packet");
    }

}
