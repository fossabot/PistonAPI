package org.laxio.piston.piston.protocol.stream;

import org.laxio.piston.piston.data.Identifier;
import org.laxio.piston.piston.player.Player;

import java.io.IOException;
import java.util.UUID;

/**
 * Implemented by Protocol to manage Buffer/Stream input
 */
public interface PistonInput {

    int read() throws IOException;

    byte readByte() throws IOException;

    long readLong() throws IOException;

    /**
     * Read a UUID
     * @return The UUID that is available in this stream
     * @throws IOException
     */
    UUID readUUID() throws IOException;

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

}
