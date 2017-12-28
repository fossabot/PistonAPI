package org.laxio.piston.piston.protocol.stream;

import org.laxio.piston.piston.entity.player.Player;

import java.io.IOException;

/**
 * Handles reading data types that are not available to be constructed from the API
 */
public interface StreamHandler {

    /**
     * Reads the player from the input
     *
     * @param input The input to read from
     *
     * @return The Player object reference for this handler
     */
    Player readPlayer(PistonInput input) throws IOException;

    /**
     * Writes the player reference to the output
     *
     * @param output The output to write to
     * @param player The player to write
     */
    void writePlayer(PistonOutput output, Player player) throws IOException;

}
