package org.laxio.piston.piston.protocol.stream;

import org.laxio.piston.piston.data.Identifier;
import org.laxio.piston.piston.entity.Velocity;
import org.laxio.piston.piston.player.Player;
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

    double readDouble() throws IOException;

    float readFloat() throws IOException;

    short readShort() throws IOException;

    int readInt() throws IOException;

    /**
     * Read a UUID
     * @return The UUID that is available in this stream
     * @throws IOException
     */
    UUID readUUID() throws IOException;

    /**
     * Read a UUID
     * @param dashes If true read the UUID as a string with dashes
     * @return The UUID that is available in this stream
     * @throws IOException
     */
    UUID readUUID(boolean dashes) throws IOException;

    /**
     * Reads a string
     * @see <a href="http://wiki.vg/Protocol#Data_types">Protocol Data Types</a>
     * @return The string available
     * @throws IOException
     */
    String readString() throws IOException;

    /**
     * Reads a VarInt
     * @see <a href="http://wiki.vg/Protocol#Data_types">Protocol Data Types</a>
     * @return The VarInt available
     * @throws IOException
     */
    int readVarInt() throws IOException;

    /**
     * Reads a VarLong
     * @see <a href="http://wiki.vg/Protocol#Data_types">Protocol Data Types</a>
     * @return The VarLong available
     * @throws IOException
     */
    long readVarLong() throws IOException;

    /**
     * Reads an Identifier
     * @see <a href="http://wiki.vg/Protocol#Data_types">Protocol Data Types</a>
     * @return The Identifier available
     * @throws IOException
     */
    Identifier readIdentifier() throws IOException;

    default Player readPlayer() throws IOException {
        return StreamManager.MANAGER.getHandler().readPlayer(this);
    }

    Location readLocation() throws IOException;

    Location readLocation(boolean yawPitch) throws IOException;

    float readRotation() throws IOException;

    Velocity readVelocity() throws IOException;

}
