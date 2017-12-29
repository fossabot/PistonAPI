package org.laxio.piston.piston.entity.player;

import org.laxio.piston.piston.command.CommandSender;
import org.laxio.piston.piston.entity.Entity;
import org.laxio.piston.piston.entity.type.LivingEntity;
import org.laxio.piston.piston.protocol.Connection;
import org.laxio.piston.piston.session.Profile;

import java.util.List;

public interface Player extends Entity, CommandSender, LivingEntity {

    Profile getProfile();

    String getName();

    Connection getConnection();

    List<Statistic> getStatistics();

    Statistic getStatistic(String name);

}
