package org.laxio.piston.piston;

import me.hfox.aphelion.Aphelion;
import me.hfox.aphelion.CommandRegistration;
import org.laxio.piston.piston.command.CommandSender;
import org.laxio.piston.piston.command.ConsoleCommandSender;
import org.laxio.piston.piston.event.ListenerManager;
import org.laxio.piston.piston.event.listener.ListenerOwner;
import org.laxio.piston.piston.logging.Logger;
import org.laxio.piston.piston.protocol.Protocol;
import org.laxio.piston.piston.session.MinecraftSessionService;
import org.laxio.piston.piston.translator.ProtocolTranslator;
import org.laxio.piston.piston.versioning.Version;

import java.net.InetSocketAddress;
import java.security.KeyPair;
import java.util.List;

public interface PistonServer extends ListenerOwner {

    /**
     * Gets the name of this server
     *
     * @return The name of this server
     */
    String getName();

    /**
     * Gets the version of this PistonServer implementation
     *
     * @return The version of this implementation
     */
    Version getVersion();

    /**
     * Gets the Minecraft version that this server is based on
     *
     * @return The Minecraft version
     */
    Version getMinecraftVersion();

    /**
     * Gets the native protocol
     *
     * @return The native protocol
     */
    Protocol getProtocol();

    /**
     * Gets the protocol for the supplied version
     *
     * @param version The version of the protocol to get
     *
     * @return The Protocol with the supplied version, or null if that Protocol isn't loaded
     */
    Protocol getProtocol(int version);

    /**
     * Adds the supplied Protocol to the list of available protocols
     * @param protocol The protocol to add
     */
    void addProtocol(Protocol protocol);

    /**
     * Gets a list of all the protocol translators
     * @return A list of translators
     */
    List<ProtocolTranslator> getTranslators();

    /**
     * Attempts to add a translator
     *
     * @param translator The translator to add
     *
     * @return true if the add was successful, false if there is already a translator matching that class
     */
    boolean addTranslator(ProtocolTranslator translator);

    /**
     * Gets the ListenerManager for this server
     * @return The ListenerManager for this server
     */
    ListenerManager getManager();

    /**
     * Gets the KeyPair for this server
     * @return The KeyPair for this server
     */
    KeyPair getKeyPair();

    /**
     * Returns if this server is in Online-Mode or not
     * @return true if the server is online-mode, false otherwise
     */
    boolean isOnlineMode();

    /**
     * Gets the session service being used by this server
     * @return The session service used by this server
     */
    MinecraftSessionService getSessionService();

    /**
     * Gets the address that this server is bound to
     * @return The address that this server is bound to
     */
    InetSocketAddress getBindAddress();

    /**
     * Gets the Logger that this server is writing to
     * @return The logger that this server is writing to
     */
    Logger getLogger();

    /**
     * Gets the command sender that represents the console for this server
     *
     * @return The console command sender for this server
     */
    ConsoleCommandSender getConsole();

    /**
     * Gets the Aphelion instance which manages the commands for this server
     * @return The Aphelion instance for this server
     */
    Aphelion<CommandSender> getAphelion();

    /**
     * Gets the command registration for this server
     * @return The command registration for this server
     */
    CommandRegistration<CommandSender> getCommandRegistration();

    /**
     * Starts the server
     *
     * @return Returns false if there was an issue starting the server, otherwise true
     */
    boolean start();

    /**
     * Returns if the server is running
     *
     * @return True if the server is running, false otherwise
     */
    boolean isRunning();

    /**
     * Stops the server
     */
    void stop();

}
