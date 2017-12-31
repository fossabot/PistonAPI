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
