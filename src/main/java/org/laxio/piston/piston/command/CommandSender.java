package org.laxio.piston.piston.command;

import org.laxio.piston.piston.chat.ChatPosition;
import org.laxio.piston.piston.chat.MessageComponent;
import org.laxio.piston.piston.chat.StatusLevel;

public interface CommandSender {

    String getName();

    default void sendMessage(String message) {
        sendMessage(ChatPosition.CHAT, message);
    }

    default void sendMessage(StatusLevel level, String message) {
        sendMessage(ChatPosition.CHAT, level, message);
    }

    default void sendMessage(MessageComponent message) {
        sendMessage(ChatPosition.CHAT, message);
    }

    void sendMessage(ChatPosition position, String message);

    void sendMessage(ChatPosition position, StatusLevel level, String message);

    void sendMessage(ChatPosition position, MessageComponent message);

    boolean hasPermission(String string);

}
