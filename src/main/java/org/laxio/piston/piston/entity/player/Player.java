package org.laxio.piston.piston.entity.player;

import org.laxio.piston.piston.command.CommandSender;
import org.laxio.piston.piston.entity.Entity;
import org.laxio.piston.piston.protocol.Connection;
import org.laxio.piston.piston.session.Profile;

public interface Player extends Entity, CommandSender {

    Profile getProfile();

    String getName();

    Connection getConnection();

}
