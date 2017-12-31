package org.laxio.piston.piston.command.manager;

import me.hfox.aphelion.command.CommandContext;
import me.hfox.aphelion.command.annotations.Command;
import me.hfox.aphelion.command.annotations.CommandPermission;
import me.hfox.aphelion.exception.CommandException;
import org.laxio.piston.piston.PistonServer;
import org.laxio.piston.piston.ServerManager;
import org.laxio.piston.piston.chat.StatusLevel;
import org.laxio.piston.piston.command.CommandSender;

public class ServerManagerCommands {

    @Command(aliases = {"stop"}, description = "Stops the server", max = 0)
    @CommandPermission("piston.manager.stop")
    public static void stop(CommandSender sender, CommandContext args) {
        sender.sendMessage(StatusLevel.WARNING, "Stopping all servers...");
        ServerManager manager = ServerManager.getInstance();
        for (PistonServer server : manager.getServers()) {
            server.stop();
        }

        System.exit(0);
    }

    @Command(aliases = {"cmd", "command"}, description = "Sends a command to a supplied server", usage = "[server] [cmd]", min = 2)
    @CommandPermission("piston.manager.cmd")
    public static void cmd(CommandSender sender, CommandContext args) throws CommandException {
        ServerManager manager = ServerManager.getInstance();
        PistonServer server = manager.getServer(args.getString(0));
        if (server == null) {
            throw new CommandException("Server not found with name '" + args.getString(0) + "'");
        }

        CommandSender proxy = sender;
        if (sender instanceof ServerManager) {
            proxy = server.getConsole();
        }

        server.runCommand(proxy, args.getJoinedString(1));
    }

}
