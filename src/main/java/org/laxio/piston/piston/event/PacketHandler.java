package org.laxio.piston.piston.event;

import org.laxio.piston.piston.event.listener.ListenerPriority;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PacketHandler {

    /**
     * Used to define the priority which this method should be fired on
     *
     * @return the priority
     */
    ListenerPriority priority() default ListenerPriority.NORMAL;

}
