package org.laxio.piston.piston.command.manager;

        /*-
         * #%L
         * Piston API
         * %%
         * Copyright (C) 2017 Laxio
         * %%
         * This file is part of Piston, licensed under the MIT License (MIT).
         *
         * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
         *
         * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
         *
         * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
         * #L%
         */

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
