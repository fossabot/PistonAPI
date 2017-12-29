package org.laxio.piston.piston.chat;

import org.json.JSONObject;
import org.laxio.piston.piston.chat.component.TextComponent;

import java.util.ArrayList;
import java.util.List;

public class MessageBuilder {

    private String message;
    private JSONObject json;

    private MessageBuilder() {
        // empty but private
    }

    public MessageBuilder message(String message) {
        this.json = null;
        this.message = message;
        return this;
    }

    public MessageBuilder json(JSONObject json) {
        this.message = null;
        this.json = json;
        return this;
    }

    public MessageComponent build() {
        if (this.message != null) {
            TextComponent component = new TextComponent();
            String splitter = ChatColor.COLOR_CHAR + "";
            if (!message.contains(splitter)) {
                component.setText(message);
                return component;
            }

            List<ColorString> message = new ArrayList<>();
            TextComponent primary = new TextComponent();
            component = primary;

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

            int pos = 0;
            for (ColorString entry : message) {
                if (pos == 1) {
                    // first component is primary component
                    primary = component;
                }

                pos++;
                ChatColor color = entry.getColor();
                String text = entry.getString();

                if (color.isFormat()) {
                    if (component.hasFormat(color)) {
                        if (text != null) {
                            // format already included but has text
                            component.setText(component.getText() + text);
                        }

                        continue;
                    }

                    if (text != null && text.length() > 0) {
                        if (component.getText() != null && component.getText().length() > 0) {
                            // add new component with existing formatting
                            (component = component.add(new TextComponent())).setText(text);
                        } else {
                            // use parent component because it was empty
                            component.setText(text);
                        }
                    }

                    // add the format supplied by this tag to the component
                    component.addFormat(color);
                } else {
                    // new color, new component
                    component = component.addExtra(new TextComponent());
                    if (text == null) {
                        text = "";
                    }

                    component.setText(text);
                    component.setColor(color);
                }
            }

            if (pos == 1) {
                // first component is primary component
                primary = component;
            }

            return primary;
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

        private ColorString(ChatColor color, String string) {
            this.color = color;
            this.string = string;
        }

        private ChatColor getColor() {
            return color;
        }

        private String getString() {
            return string;
        }

        @Override
        public String toString() {
            return "{" + color.name() + ":'" + string + "'}";
        }

    }

}
