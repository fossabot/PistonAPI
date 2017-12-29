package org.laxio.piston.piston.event.login;

import org.laxio.piston.piston.entity.player.Player;
import org.laxio.piston.piston.event.Event;

public class PlayerPreLoginEvent implements Event {

    private final Player player;
    private LoginResult result;
    private String kickMessage;

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

    public String getKickMessage() {
        return kickMessage;
    }

    public void setKickMessage(String kickMessage) {
        this.kickMessage = kickMessage;
    }

    public enum LoginResult {

        ALLOWED,
        DISALLOWED

    }

}
