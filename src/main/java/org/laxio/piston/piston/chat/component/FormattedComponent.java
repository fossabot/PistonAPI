package org.laxio.piston.piston.chat.component;

import org.json.JSONObject;
import org.laxio.piston.piston.chat.ChatColor;
import org.laxio.piston.piston.chat.MessageComponent;
import org.laxio.piston.piston.exception.chat.ChatFormatException;

/**
 * Represents a styled text component for the chat system
 */
public class FormattedComponent implements MessageComponent {

    private final MessageComponent[] extra;
    private ChatColor color;
    private ChatColor[] format;

    public FormattedComponent(ChatColor color, ChatColor[] format, MessageComponent[] extra) {
        this.color = color;
        this.format = format;
        this.extra = extra;
    }

    /**
     * Gets the color of this component
     *
     * @return The color of this component
     */
    public ChatColor getColor() {
        return color;
    }

    /**
     * Sets the color of this component
     *
     * @param color The color to set
     *
     * @throws ChatFormatException If the supplied color is a formatter
     */
    public void setColor(ChatColor color) {
        if (color.isFormat()) {
            throw new ChatFormatException(color.name() + " is a formatter not a color", this);
        }

        this.color = color;
    }

    /**
     * Gets the formatting elements set on this component
     *
     * @return The formatting elements for this component
     */
    public ChatColor[] getFormat() {
        return format;
    }

    public void setFormat(ChatColor[] format) {
        for (ChatColor color : format) {
            if (!color.isFormat()) {
                throw new ChatFormatException(color.name() + " is not a valid formatter", this);
            }
        }

        this.format = format;
    }

    @Override
    public MessageComponent[] getExtra() {
        return extra;
    }

    @Override
    public JSONObject toJSON() {
        return null;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
