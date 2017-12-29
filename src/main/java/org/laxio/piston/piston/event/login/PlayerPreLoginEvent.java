package org.laxio.piston.piston.event.login;

import org.laxio.piston.piston.chat.MessageBuilder;
import org.laxio.piston.piston.chat.MessageComponent;
import org.laxio.piston.piston.entity.player.Player;
import org.laxio.piston.piston.event.Event;

public class PlayerPreLoginEvent implements Event {

    private final Player player;
    private LoginResult result;
    private MessageComponent kickMessage;

    public PlayerPreLoginEvent(Player player) {
        this.player = player;
        this.result = LoginResult.ALLOWED;
    }

    public Player getPlayer() {
        return player;
    }

    public LoginResult getResult() {
        return result;
    }

    public void setResult(LoginResult result) {
        this.result = result;
    }

    public MessageComponent getKickMessage() {
        return kickMessage;
    }

    @Deprecated
    public void setKickMessage(String message) {
        this.kickMessage = MessageBuilder.builder().message(message).build();
    }

    public void setKickMessage(MessageComponent kickMessage) {
        this.kickMessage = kickMessage;
    }

    public enum LoginResult {

        ALLOWED,
        DISALLOWED

    }

}
