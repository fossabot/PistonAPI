package org.laxio.piston.piston.protocol.stream;

import org.laxio.piston.piston.data.Identifier;
import org.laxio.piston.piston.player.Player;

import java.io.IOException;
import java.util.UUID;

/**
 * Implemented by Protocol to manage Buffer/Stream output
 */
public interface PistonOutput {

    void write(int data) throws IOException;

    void write(byte[] data) throws IOException;

    void writeByte(byte data) throws IOException;

    void writeLong(long data) throws IOException;

    /**
     * Writes the supplied UUID
     * @see <a href="http://wiki.vg/Protocol#Data_types">Protocol Data Types</a>
     * @param data The UUID to write
     * @throws IOException
     */
    PistonOutput writeUUID(UUID data) throws IOException;

    /**
     * Writes the supplied String 
     * @see <a href="http://wiki.vg/Protocol#Data_types">Protocol Data Types</a>
     * @param data The String to write
     * @throws IOException
     */
    PistonOutput writeString(String data) throws IOException;

    /**
     * Writes the supplied VarInt 
     * @see <a href="http://wiki.vg/Protocol#Data_types">Protocol Data Types</a>
     * @param data The VarInt to write
     * @throws IOException
     */
    PistonOutput writeVarInt(int data) throws IOException;

    /**
     * Writes the supplied VarLong 
     * @see <a href="http://wiki.vg/Protocol#Data_types">Protocol Data Types</a>
     * @param data The VarLong to write
     * @throws IOException
     */
    PistonOutput writeVarLong(long data) throws IOException;

    /**
     * Writes the supplied Identifier 
     * @see <a href="http://wiki.vg/Protocol#Data_types">Protocol Data Types</a>
     * @param data The Identifier to write
     * @throws IOException
     */
    PistonOutput writeIdentifier(Identifier data) throws IOException;

    default PistonOutput writePlayer(Player data) throws IOException {
        StreamManager.MANAGER.getHandler().writePlayer(this, data);
        return this;
    }

}
