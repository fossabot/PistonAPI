package org.laxio.piston.piston.chat;

import org.laxio.piston.piston.chat.event.click.ClickEvent;
import org.laxio.piston.piston.chat.event.hover.HoverEvent;

public interface MessageComponent extends ChatComponent {

    MessageComponent[] getExtra();

    void setExtra(MessageComponent[] extra);

    ChatColor getColor();

    void setColor(ChatColor color);

    ChatColor[] getFormat();

    void setFormat(ChatColor[] format);

    ClickEvent getClickEvent();

    void setClickEvent(ClickEvent event);

    HoverEvent getHoverEvent();

    void setHoverEvent(HoverEvent event);

}
