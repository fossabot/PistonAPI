package org.laxio.piston.piston.chat.component;

import org.json.JSONArray;
import org.json.JSONObject;
import org.laxio.piston.piston.chat.ChatColor;
import org.laxio.piston.piston.chat.MessageComponent;
import org.laxio.piston.piston.chat.event.click.ClickEvent;
import org.laxio.piston.piston.chat.event.hover.HoverEvent;
import org.laxio.piston.piston.exception.chat.ChatFormatException;

/**
 * Represents a styled text component for the chat system
 */
public class FormattedComponent implements MessageComponent {

    private final MessageComponent[] extra;
    private ChatColor color;
    private ChatColor[] format;
    private ClickEvent clickEvent;
    private HoverEvent hoverEvent;

    public FormattedComponent(MessageComponent[] extra, ChatColor color, ChatColor[] format, ClickEvent clickEvent, HoverEvent hoverEvent) {
        this.extra = extra;
        this.color = color;
        this.format = format;
        this.clickEvent = clickEvent;
        this.hoverEvent = hoverEvent;
    }

    @Override
    public MessageComponent[] getExtra() {
        return extra;
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

    public ClickEvent getClickEvent() {
        return clickEvent;
    }

    public void setClickEvent(ClickEvent clickEvent) {
        this.clickEvent = clickEvent;
    }

    public HoverEvent getHoverEvent() {
        return hoverEvent;
    }

    public void setHoverEvent(HoverEvent hoverEvent) {
        this.hoverEvent = hoverEvent;
    }

    @Override
    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        if (color != null) {
            json.put("color", color.getName());
        }

        if (format != null) {
            for (ChatColor color : format) {
                json.put(color.getName(), true);
            }
        }

        if (clickEvent != null) {
            json.put("click_event", clickEvent.toJSON());
        }

        if (hoverEvent != null) {
            json.put("hover_event", hoverEvent.toJSON());
        }

        if (extra != null && extra.length > 0) {
            JSONArray array = new JSONArray();
            for (MessageComponent component : extra) {
                array.put(component.toJSON());
            }

            json.put("extra", array);
        }

        return json;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
