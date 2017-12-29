package org.laxio.piston.piston.chat.event;

import org.json.JSONObject;
import org.laxio.piston.piston.chat.ChatComponent;

public interface ChatEvent extends ChatComponent {

    String getAction();

    Object getValue();

    @Override
    default JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("action", getAction());
        json.put("value", getValue());
        return json;
    }

}