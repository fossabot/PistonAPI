package org.laxio.piston.piston.protocol.stream;

import org.laxio.piston.piston.data.Identifier;
import org.laxio.piston.piston.entity.Metadata;
import org.laxio.piston.piston.entity.Velocity;
import org.laxio.piston.piston.entity.player.Player;
import org.laxio.piston.piston.world.Location;

import java.io.IOException;
import java.util.UUID;

/**
 * Implemented by Protocol to manage Buffer/Stream output
 */
public interface PistonOutput {

    void write(int data) throws IOException;

    void write(byte[] data) throws IOException;

    void writeByte(byte data) throws IOException;

    default void writeBytes(byte[] data) throws IOException {
        writeVarInt(data.length);
        write(data);
    }

    void writeLong(long data) throws IOException;

    void writeDouble(double data) throws IOException;

    void writeFloat(float data) throws IOException;

    void writeShort(int data) throws IOException;

    void writeInt(int data) throws IOException;

    void writeBoolean(boolean data) throws IOException;

    /**
     * Writes the supplied UUID
     *
     * @param data The UUID to write
     *
     * @throws IOException
     * @see <a href="http://wiki.vg/Protocol#Data_types">Protocol Data Types</a>
     */
    PistonOutput writeUUID(UUID data) throws IOException;

    /**
     * Writes the supplied UUID
     *
     * @param data   The UUID to write
     * @param dashes If true write the UUID as a string with dashes
     *
     * @throws IOException
     * @see <a href="http://wiki.vg/Protocol#Data_types">Protocol Data Types</a>
     */
    PistonOutput writeUUID(UUID data, boolean dashes) throws IOException;

    /**
     * Writes the supplied String
     *
     * @param data The String to write
     *
     * @throws IOException
     * @see <a href="http://wiki.vg/Protocol#Data_types">Protocol Data Types</a>
     */
    PistonOutput writeString(String data) throws IOException;

    /**
     * Writes the supplied VarInt
     *
     * @param data The VarInt to write
     *
     * @throws IOException
     * @see <a href="http://wiki.vg/Protocol#Data_types">Protocol Data Types</a>
     */
    PistonOutput writeVarInt(int data) throws IOException;

    /**
     * Writes the supplied VarLong
     *
     * @param data The VarLong to write
     *
     * @throws IOException
     * @see <a href="http://wiki.vg/Protocol#Data_types">Protocol Data Types</a>
     */
    PistonOutput writeVarLong(long data) throws IOException;

    /**
     * Writes the supplied Identifier
     *
     * @param data The Identifier to write
     *
     * @throws IOException
     * @see <a href="http://wiki.vg/Protocol#Data_types">Protocol Data Types</a>
     */
    PistonOutput writeIdentifier(Identifier data) throws IOException;

    default PistonOutput writePlayer(Player data) throws IOException {
        StreamManager.MANAGER.getHandler().writeMetadata(this, data);
        return this;
    }

    PistonOutput writeLocation(Location data) throws IOException;

    PistonOutput writeLocation(Location data, boolean yawPitch) throws IOException;

    PistonOutput writeRotation(float data) throws IOException;

    PistonOutput writeVelocity(Velocity data) throws IOException;

    PistonOutput writePosition(Location data) throws IOException;

    default PistonOutput writeMetadata(Metadata metadata) throws IOException {
        StreamManager.MANAGER.getHandler().writeMetadata(this, metadata);
        return this;
    }

}
