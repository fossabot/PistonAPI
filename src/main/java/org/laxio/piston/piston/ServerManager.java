package org.laxio.piston.piston;

        /*-
         * #%L
         * Piston API
         * %%
         * Copyright (C) 2017 - 2018 Laxio
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

import me.hfox.aphelion.Aphelion;
import me.hfox.aphelion.CommandRegistration;
import org.laxio.piston.piston.chat.MessageComponent;
import org.laxio.piston.piston.chat.StatusLevel;
import org.laxio.piston.piston.command.CommandSender;
import org.laxio.piston.piston.command.ConsoleCommandSender;
import org.laxio.piston.piston.command.manager.ServerManagerCommands;
import org.laxio.piston.piston.logging.Logger;

import java.util.ArrayList;
import java.util.List;

public class ServerManager implements ConsoleCommandSender {

    private static final ServerManager instance;

    static {
        instance = new ServerManager();
    }

    private final List<PistonServer> servers;
    private final Aphelion<CommandSender> aphelion;

    private ServerManager() {
        this.servers = new ArrayList<>();
        this.aphelion = new Aphelion<CommandSender>(CommandSender.class) {
            @Override
            public boolean hasPermission(CommandSender sender, String s) {
                return sender.hasPermission(s);
            }
        };
        this.aphelion.getRegistration().register(ServerManagerCommands.class);
    }

    @Override
    public PistonServer getServer() {
        throw new UnsupportedOperationException("ServerManager does not have a server");
    }

    public List<PistonServer> getServers() {
        return servers;
    }

    public void addServer(PistonServer server) {
        if (this.servers.contains(server)) {
            return;
        }

        this.servers.add(server);
    }

    public PistonServer getServer(String name) {
        for (PistonServer server : servers) {
            if (name.equalsIgnoreCase(server.getName())) {
                return server;
            }
        }

        return null;
    }

    public Aphelion<CommandSender> getAphelion() {
        return aphelion;
    }

    public CommandRegistration<CommandSender> getCommandRegistration() {
        return aphelion.getRegistration();
    }

    @Override
    public String getName() {
        return "ServerManager";
    }

    @Override
    public void sendMessage(String message) {
        sendMessage(StatusLevel.NORMAL, message);
    }

    @Override
    public void sendMessage(StatusLevel level, String message) {
        Logger.getGlobal().log(level.getLevel(), message);
    }

    @Override
    public void sendMessage(MessageComponent message) {
        // TODO: convert message into readable string
    }

    @Override
    public boolean hasPermission(String string) {
        return true;
    }

    public static ServerManager getInstance() {
        return instance;
    }

}
