package org.laxio.piston.piston.boss;

import org.laxio.piston.piston.chat.MessageComponent;

import java.util.UUID;

public interface BossBar {

    UUID getUniqueId();

    MessageComponent getTitle();

    void setTitle(MessageComponent title);

    float getHealth();

    void setHealth(float value);

    BossBarColor getColor();

    void setColor(BossBarColor color);

    BossBarDivision getDivision();

    void setDivision(BossBarDivision division);

    boolean isDarken();

    void setDarken(boolean darken);

    boolean isDragon();

    void setDragon(boolean dragon);

}
