package org.laxio.piston.piston.command;

import org.laxio.piston.piston.chat.ChatPosition;
import org.laxio.piston.piston.chat.MessageComponent;
import org.laxio.piston.piston.chat.StatusLevel;

public interface ConsoleCommandSender extends CommandSender {

    void sendMessage(String message);

    void sendMessage(StatusLevel level, String message);

    void sendMessage(MessageComponent message);

    default void sendMessage(ChatPosition position, String message) {
        sendMessage(message);
    }

    default void sendMessage(ChatPosition position, StatusLevel level, String message) {
        sendMessage(level, message);
    }

    default void sendMessage(ChatPosition position, MessageComponent message) {
        sendMessage(message);
    }

}
