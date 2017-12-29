package org.laxio.piston.piston.chat;

import org.laxio.piston.piston.chat.component.TextComponent;

import java.util.ArrayList;
import java.util.List;

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
        if (this.message != null) {
            String splitter = ChatColor.COLOR_CHAR + "";

            List<ColorString> message = new ArrayList<>();
            TextComponent primary = new TextComponent();
            TextComponent component = primary;
            if (this.message.contains(splitter)) {
                String[] split = this.message.split(splitter);
                // Splits the string by color codes

                for (String str : split) {
                    if (str.length() < 1) {
                        // Removes double code
                        continue;
                    }

                    // Creates a color string for color:text
                    char ch = str.charAt(0);
                    ChatColor color = ChatColor.getByChar(ch);
                    str = str.substring(1);

                    message.add(new ColorString(color, str));
                }
            } else {
                // No color codes, set the next for the component and finish
                component.setText(this.message);
                return component;
            }


            List<TextComponent> extra = new ArrayList<>();

            int pos = 1;
            for (ColorString entry : message) {
                ChatColor color = entry.getColor();
                String text = entry.getString();

                if (color.isFormat()) {

                }
            }
        }

        return null;
    }

    public static MessageBuilder builder() {
        return new MessageBuilder();
    }

    /**
     * Represents a string prefixed by a supplied color
     */
    private static class ColorString {

        private ChatColor color;
        private String string;

        public ColorString(ChatColor color, String string) {
            this.color = color;
            this.string = string;
        }

        public ChatColor getColor() {
            return color;
        }

        public String getString() {
            return string;
        }

        @Override
        public String toString() {
            return color.name() + ": " + string;
        }

    }

}
