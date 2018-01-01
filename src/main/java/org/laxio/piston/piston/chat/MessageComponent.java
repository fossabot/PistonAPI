package org.laxio.piston.piston.chat;

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
         * ========================LICENSE_END==================================
         */

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

import org.laxio.piston.piston.chat.event.click.ClickEvent;
import org.laxio.piston.piston.chat.event.hover.HoverEvent;
import org.laxio.piston.piston.exception.chat.ChatFormatException;

public interface MessageComponent extends ChatComponent {

    MessageComponent[] getExtra();

    void setExtra(MessageComponent[] extra);

    default <T extends MessageComponent> T addExtra(T extra) {
        if (getExtra() == null) {
            setExtra(new MessageComponent[]{extra});
            return extra;
        }

        MessageComponent[] clone = new MessageComponent[getExtra().length + 1];
        clone[clone.length - 1] = extra;

        for (int i = 0; i < clone.length - 1; i++) {
            clone[i] = getExtra()[i];
        }

        setExtra(clone);
        return extra;
    }

    /**
     * Gets the color of this component
     *
     * @return The color of this component
     */
    ChatColor getColor();

    /**
     * Sets the color of this component
     *
     * @param color The color to set
     *
     * @throws ChatFormatException If the supplied color is a formatter
     */
    void setColor(ChatColor color);

    /**
     * Gets the formatting elements set on this component
     *
     * @return The formatting elements for this component
     */
    ChatColor[] getFormat();

    void setFormat(ChatColor[] format);

    default void addFormat(ChatColor format) {
        if (!format.isFormat()) {
            throw new ChatFormatException(format.name() + " is not a valid formatter", this);
        }

        if (getFormat() == null) {
            setFormat(new ChatColor[]{format});
            return;
        }

        ChatColor[] clone = new ChatColor[getFormat().length + 1];
        clone[0] = format;

        for (int i = 1; i < clone.length; i++) {
            clone[i] = getFormat()[i - 1];
        }

        setFormat(clone);
    }

    default boolean hasFormat(ChatColor format) {
        if (!format.isFormat()) {
            throw new ChatFormatException(format.name() + " is not a valid formatter", this);
        }

        if (getFormat() == null) {
            return false;
        }

        for (ChatColor color : getFormat()) {
            if (color.equals(format)) {
                return true;
            }
        }

        return false;
    }

    ClickEvent getClickEvent();

    void setClickEvent(ClickEvent event);

    HoverEvent getHoverEvent();

    void setHoverEvent(HoverEvent event);

    default <T extends MessageComponent> T add(T component) {
        if (getColor() != null)
            component.setColor(getColor());

        if (getFormat() != null)
            component.setFormat(getFormat());

        if (getClickEvent() != null)
            component.setClickEvent(getClickEvent());

        if (getHoverEvent() != null)
            component.setHoverEvent(getHoverEvent());

        addExtra(component);
        return component;
    }

}
