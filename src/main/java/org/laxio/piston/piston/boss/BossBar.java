package org.laxio.piston.piston.boss;

import java.util.UUID;

public interface BossBar {

    UUID getUniqueId();

    String getTitle();

    void setTitle(String string);

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
