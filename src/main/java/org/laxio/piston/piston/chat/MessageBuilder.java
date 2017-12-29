package org.laxio.piston.piston.chat;

public class MessageBuilder {

    private String message;

    private MessageBuilder() {
        // empty but private
    }

    public MessageBuilder message(String message) {
        this.message = message;
        return this;
    }

    public MessageComponent build() {
        String splitter = ChatColor.COLOR_CHAR + "";
        return null;
    }

    public static MessageBuilder builder() {
        return new MessageBuilder();
    }

}
