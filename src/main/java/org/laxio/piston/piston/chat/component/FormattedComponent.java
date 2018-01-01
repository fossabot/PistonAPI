/*-
 * ========================LICENSE_START========================
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
 * ========================LICENSE_END========================
 */
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

    private MessageComponent[] extra;
    private ChatColor color;
    private ChatColor[] format;
    private ClickEvent clickEvent;
    private HoverEvent hoverEvent;

    public FormattedComponent() {
        this.extra = null;
        this.color = null;
        this.format = null;
        this.clickEvent = null;
        this.hoverEvent = null;
    }

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

    @Override
    public void setExtra(MessageComponent[] extra) {
        this.extra = extra;
    }

    @Override
    public ChatColor getColor() {
        return color;
    }

    @Override
    public void setColor(ChatColor color) {
        if (color.isFormat()) {
            throw new ChatFormatException(color.name() + " is a formatter not a color", this);
        }

        this.color = color;
    }

    @Override
    public ChatColor[] getFormat() {
        return format;
    }

    @Override
    public void setFormat(ChatColor[] format) {
        for (ChatColor color : format) {
            if (!color.isFormat()) {
                throw new ChatFormatException(color.name() + " is not a valid formatter", this);
            }
        }

        this.format = format;
    }

    @Override
    public ClickEvent getClickEvent() {
        return clickEvent;
    }

    @Override
    public void setClickEvent(ClickEvent clickEvent) {
        this.clickEvent = clickEvent;
    }

    @Override
    public HoverEvent getHoverEvent() {
        return hoverEvent;
    }

    @Override
    public void setHoverEvent(HoverEvent hoverEvent) {
        this.hoverEvent = hoverEvent;
    }

    @Override
    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        if (extra != null && extra.length > 0) {
            JSONArray array = new JSONArray();
            for (MessageComponent component : extra) {
                array.put(component.toJSON());
            }

            json.put("extra", array);
        }

        if (clickEvent != null) {
            json.put("click_event", clickEvent.toJSON());
        }

        if (hoverEvent != null) {
            json.put("hover_event", hoverEvent.toJSON());
        }

        for (ChatColor color : ChatColor.format()) {
            json.put(color.getName(), hasFormat(color));
        }

        if (color != null) {
            json.put("color", color.getName());
        }

        return json;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
