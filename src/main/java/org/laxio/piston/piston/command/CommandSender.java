package org.laxio.piston.piston.command;

import org.laxio.piston.piston.chat.MessageComponent;
import org.laxio.piston.piston.chat.StatusLevel;

public interface CommandSender {

    String getName();

    void sendMessage(String message);

    void sendMessage(StatusLevel level, String message);

    void sendMessage(MessageComponent message);

    boolean hasPermission(String string);

}
