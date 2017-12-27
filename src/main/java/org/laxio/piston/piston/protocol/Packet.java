package org.laxio.piston.piston.protocol;

import org.laxio.piston.piston.PistonServer;
import org.laxio.piston.piston.protocol.stream.PistonInput;
import org.laxio.piston.piston.protocol.stream.PistonOutput;

import java.io.IOException;

/**
 * Interface implemented by Protocol packets
 */
public interface Packet {

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
     * @throws IOException
     * @throws UnsupportedOperationException If this packet can't be read
     */
    void onRead(PistonInput input) throws IOException;

    /**
     * Called by the server when a Packet is being read
     *
     * @param input The input source
     * @throws IOException
     * @throws UnsupportedOperationException If this packet can't be read
     */
    void read(PistonInput input) throws IOException;

    /**
     * Writes the data to the output
     *
     * @param output The output destination
     * @throws IOException
     * @throws UnsupportedOperationException If this packet can't be written
     */
    void onWrite(PistonOutput output) throws IOException;

    /**
     * Called by the server when a Packet is being written
     *
     * @param output The output destination
     * @throws IOException
     * @throws UnsupportedOperationException If this packet can't be written
     */
    void write(PistonOutput output) throws IOException;

}
